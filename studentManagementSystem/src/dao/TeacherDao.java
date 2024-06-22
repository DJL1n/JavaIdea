package dao;

import model.Teacher;
import view.TeacherFrame;
import java.sql.*;

import static view.TeacherFrame.teacher;

/**
 * TeacherDao 类提供了教师相关的数据访问方法。
 * 继承自 BaseDao 类，用于执行与教师相关的数据库操作。
 */
public class TeacherDao extends BaseDao {
    /**
     * 根据用户名和密码查询教师账号。
     * @param name 教师的用户名。
     * @param password 教师的密码。
     * @return 如果查询成功，返回一个 Teacher 对象；如果失败，返回 null。
     */
    public Teacher selectTeacher(String name, String password) {
        String sqlStr = "select * from teacherLogin where name = ? and password = ?";
        Teacher teacher = null;
        try {
            this.pStatement = this.con.prepareStatement(sqlStr);
            this.pStatement.setString(1, name);
            this.pStatement.setString(2, password);
            ResultSet executeQuery = this.pStatement.executeQuery();
            if (executeQuery.next()) {
                teacher = new Teacher(
                        executeQuery.getInt("id"),
                        executeQuery.getString("name"),
                        executeQuery.getString("password")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.close();
        }
        return teacher;
    }

    /**
     * 允许教师修改自己的密码。
     * @param name 教师的用户名。
     * @param newPassword 新密码。
     * @return 操作结果的描述信息。
     */
    public String revisePassword(String name, String newPassword) {
        String resultStr = "操作失败";
        String sqlStr = "update teacherLogin set password = ? where name = ? and password = ?";
        try {
            this.pStatement = this.con.prepareStatement(sqlStr);
            this.pStatement.setString(1, newPassword);
            this.pStatement.setString(2, teacher.getName());
            this.pStatement.setString(3, teacher.getPassword());
            if (pStatement.executeUpdate() > 0) {
                resultStr = "操作成功！";
                teacher.setPassword(newPassword);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.close();
        }
        return resultStr;
    }

    // 以下是教师获取所教授课程名称的方法
    public String getTeachCourse(String name) throws SQLException {
        String resultTeachCourse = null;
        String sqlStr = "select teachCourseName from teacher where name = ?";
        try (PreparedStatement preparedStatement = this.con.prepareStatement(sqlStr)) {
            preparedStatement.setString(1, name);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                resultTeachCourse = resultSet.getString("teachCourseName");
            }
        }
        return resultTeachCourse;
    }

    // 同上，获取所教授课程ID的方法
    public String getTeachCourseID(String name) throws SQLException {
        String resultTeachCourseID = null;
        String sqlStr = "select teachCourseId from teacher where name = ?";
        try (PreparedStatement preparedStatement = this.con.prepareStatement(sqlStr)) {
            preparedStatement.setString(1, name);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                resultTeachCourseID = resultSet.getString("teachCourseId");
            }
        }
        return resultTeachCourseID;
    }

    /**
     * 教师设置或更新学生在某门课程中的成绩。
     * @param stuName 学生姓名。
     * @param courseName 课程名称。
     * @param grade 学生成绩。
     * @return 操作结果的描述信息。
     */
    public String SetStudentGrade(String stuName, String courseName, int grade) throws SQLException {
        String resultStr = "录入失败";
        String sqlStr = "update chooseCourse set grade=? where studentName = ? and courseName = ?";
        try (PreparedStatement preparedStatement = this.con.prepareStatement(sqlStr)) {
            preparedStatement.setInt(1, grade);
            preparedStatement.setString(2, stuName);
            preparedStatement.setString(3, courseName);
            if (preparedStatement.executeUpdate() >= 1) {
                resultStr = "录入成功";
            }
        }
        return resultStr;
    }

    /**
     * 教师查询学生在某门课程中的成绩。
     * @param stuName 学生姓名。
     * @param courseName 课程名称。
     * @return 学生的成绩，如果未找到则返回null。
     */
    public String FindStuGrade(String stuName, String courseName) throws SQLException {
        String resultStr = null;
        String sqlStr = "select grade from chooseCourse where studentName = ? and courseName = ?";
        try (PreparedStatement preparedStatement = this.con.prepareStatement(sqlStr)) {
            preparedStatement.setString(1, stuName);
            preparedStatement.setString(2, courseName);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                resultStr = resultSet.getString("grade");
            }
        }
        return resultStr;
    }

    /**
     * 教师更改学生在某门课程中的成绩。
     * @param stuName 学生姓名。
     * @param courseName 课程名称。
     * @param changeGrade 新的成绩。
     * @return 操作结果的描述信息。
     */
    public String ChangeStuGrade(String stuName, String courseName, int changeGrade) throws SQLException {
        String resultStr = null;
        String sqlStr = "update chooseCourse set grade = ? where studentName = ? and courseName = ?";
        try (PreparedStatement preparedStatement = this.con.prepareStatement(sqlStr)) {
            preparedStatement.setInt(1, changeGrade);
            preparedStatement.setString(2, stuName);
            preparedStatement.setString(3, courseName);
            if (preparedStatement.executeUpdate() >= 1) {
                resultStr = "修改成功";
            }
        }
        return resultStr;
    }

    // 以下是教师添加和删除信息的方法
    public String AddTeacher(int TeacherID, String TeacherName, String TeacherPassword, String TeachCourseName) throws SQLException {
        // 实现添加教师信息的逻辑
        String resultStr = "操作失败";
        // SQL 插入语句
        String sqlIns = "INSERT INTO teacherLogin(teacherId, name, password) VALUES (?, ?, ?)";
        try (PreparedStatement preparedStatement = this.con.prepareStatement(sqlIns)) {
            preparedStatement.setInt(1, TeacherID);
            preparedStatement.setString(2, TeacherName);
            preparedStatement.setString(3, TeacherPassword);
            if (preparedStatement.executeUpdate() > 0) {
                // 教师登录信息插入成功后，继续插入教师授课信息
                String sqlInsCourse = "INSERT INTO teacher(teachCourseName, teachCourseId) VALUES (?, (SELECT id FROM course WHERE name = ?))";
                try (PreparedStatement preparedStatementCourse = this.con.prepareStatement(sqlInsCourse)) {
                    preparedStatementCourse.setString(1, TeachCourseName);
                    preparedStatementCourse.setString(2, TeachCourseName);
                    if (preparedStatementCourse.executeUpdate() > 0) {
                        resultStr = "操作成功！";
                    }
                }
            }
        }
        return resultStr;
    }

    public String DeleteTeacher(String TeacherName, String TeacherID) throws SQLException {
        // 实现删除教师信息的逻辑
        String resultStr = "删除失败！";
        // SQL 删除语句
        String sqlDel = "DELETE FROM teacherLogin WHERE name = ? AND id = ?";
        try (PreparedStatement preparedStatement = this.con.prepareStatement(sqlDel)) {
            preparedStatement.setString(1, TeacherName);
            preparedStatement.setString(2, TeacherID);
            if (preparedStatement.executeUpdate() > 0) {
                resultStr = "删除成功！";
            }
        }
        return resultStr;
    }

    /**
     * 修改教师信息，包括授课课程名称、课程ID和密码。
     * @param TeacherName 教师姓名。
     * @param TeachCourseName 教师所教授的课程名称。
     * @param TeachCourseID 教师所教授的课程ID。
     * @param TeacherPassword 教师密码。
     * @return 操作结果的描述信息。
     */
    public String reviseTeacherInfo(String TeacherName, String TeachCourseName, int TeachCourseID, String TeacherPassword) throws SQLException {
        String resultStr = "修改失败！";
        // SQL 更新语句
        String sqlUpd = "UPDATE teacher SET teachCourseName = ?, teachCourseId = ? WHERE name = ?";
        try (PreparedStatement preparedStatement = this.con.prepareStatement(sqlUpd)) {
            preparedStatement.setString(1, TeachCourseName);
            preparedStatement.setInt(2, TeachCourseID);
            preparedStatement.setString(3, TeacherName);
            if (preparedStatement.executeUpdate() > 0) {
                // 更新教师信息成功后，继续更新密码信息
                String sqlUpdPwd = "UPDATE teacherLogin SET password = ? WHERE name = ?";
                try (PreparedStatement preparedStatementPwd = this.con.prepareStatement(sqlUpdPwd)) {
                    preparedStatementPwd.setString(1, TeacherPassword);
                    preparedStatementPwd.setString(2, TeacherName);
                    if (preparedStatementPwd.executeUpdate() > 0) {
                        resultStr = "修改成功！";
                    }
                }
            }
        }
        return resultStr;
    }

    //实现获取教室ID
    public String getId(String name) throws SQLException {
        String resultStr = null;
        String sqlStr = "select id from teacherLogin where name = ? ";
        PreparedStatement preparedStatement = this.con.prepareStatement(sqlStr);
        preparedStatement.setString(1,name);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            resultStr = resultSet.getString("id");
        }
        System.out.println(resultStr);
        return resultStr;
    }

    // 实现获取教师所教授课程名称
    public String getCourseName(String name) throws SQLException {
        String resultName = null;
        String sqlStr = "select teachCourseName from teacher where name = ?";
        PreparedStatement preparedStatement = this.con.prepareStatement(sqlStr);
        preparedStatement.setString(1,name);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            resultName = resultSet.getString("teachCourseName");
        }
        return resultName;
    }

    // 实现获取教师所教授课程ID
    public String getCourseID(String name) throws SQLException {
        String resultID = null;
        String sqlStr = "select teachCourseId from teacher where name = ?";
        PreparedStatement preparedStatement = this.con.prepareStatement(sqlStr);
        preparedStatement.setString(1,name);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            resultID = resultSet.getString("teachCourseId");
        }
        return resultID;
    }

}
