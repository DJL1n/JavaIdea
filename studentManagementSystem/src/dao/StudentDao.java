package dao;


import model.Student;
import view.StudentFrame;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static view.StudentFrame.student;

/**
 * 学生数据访问对象类，继承自BaseDao。
 * 负责处理与学生相关的数据库操作，包括登录、密码修改、信息查询、
 * 选课以及查询成绩等。
 */
public class StudentDao extends BaseDao{
    /**
     * 根据用户名和密码查询学生信息。
     * @param name 学生的用户名。
     * @param password 学生的密码。
     * @return 如果查询成功，返回Student对象；如果失败，返回null。
     */
    public Student selectStudent(String name, String password){
        String sqlStr = "select * from studentLogin where name = ? and password = ?";
        Student student = null;
        try{
            this.pStatement = this.con.prepareStatement(sqlStr);
            this.pStatement.setString(1,name);
            this.pStatement.setString(2,password);

            ResultSet executeQuery = this.pStatement.executeQuery();
            if(executeQuery.next()){
                student = new Student(executeQuery.getInt(1),executeQuery.getString(2),executeQuery.getString(3));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            this.close();
        }
        return student;
    }

    /**
     * 允许学生修改自己的密码。
     * @param name 学生的用户名。
     * @param newPassword 新密码。
     * @return 操作结果的描述信息。
     */
    public String revisePassword(String name,String newPassword){
        String resultStr = "操作失败";
        String sqlStr = "update studentLogin set password = ? where name = ? and password = ?";
        try{
            this.pStatement = this.con.prepareStatement(sqlStr);
            this.pStatement.setString(1,newPassword);
            this.pStatement.setString(2,student.getName());
            this.pStatement.setString(3, student.getPassword());
            if(pStatement.executeUpdate()>0){
                resultStr = "操作成功！";
                StudentFrame.student.setPassword(newPassword);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            this.close();
        }
        return resultStr;
    }

    /**
     * 为管理员提供添加学生账号的方法。
     * @param id 学生ID。
     * @param name 学生姓名。
     * @param password 学生密码。
     * @return 操作结果的描述信息。
     */
    public String addStuLogin(String id,String name,String password) {
        String resultStr = "操作失败";
        String sqlStr = "insert into studentLogin values(?,?,?)";
        try {
            this.pStatement = this.con.prepareStatement(sqlStr);
            this.pStatement.setString(1, id);
            this.pStatement.setString(2, name);
            this.pStatement.setString(3, password);
            if(pStatement.executeUpdate()>0) {
                // 插入学生信息表
                String sqlStr1 = "insert into student values(?,?,null,null,null)";
                PreparedStatement preparedStatement = this.con.prepareStatement(sqlStr1);
                preparedStatement.setInt(1, Integer.parseInt(id));
                preparedStatement.setString(2,name);
                if(preparedStatement.executeUpdate()>=1){
                    resultStr = "操作成功";
                }

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            this.close();
        }
        return resultStr;
    }

    /**
     * 删除学生信息。
     * @param StuName 学生姓名。
     * @param StuID 学生ID。
     * @return 操作结果的描述信息。
     */
    public String deleteStuInfo(String StuName,int StuID) throws SQLException {
        String resultStr = "删除失败！";
        // 先删除选课信息
        String sqlStr1 = "delete from chooseCourse where studentName = ? and studentId = ?";
        PreparedStatement preparedStatement = this.con.prepareStatement(sqlStr1);
        preparedStatement.setString(1,StuName);
        preparedStatement.setInt(2,StuID);
        if(preparedStatement.executeUpdate()>=0){
            // 然后删除学生信息
            String sqlStr2 = "delete from student where name = ? and id = ?";
            PreparedStatement p = this.con.prepareStatement(sqlStr2);
            p.setString(1,StuName);
            p.setInt(2,StuID);
            if(p.executeUpdate()>=1){
                // 最后删除登录信息
                String sqlStr3 = "delete from studentLogin where name = ? and id = ?";
                PreparedStatement preparedStatement1 = this.con.prepareStatement(sqlStr3);
                preparedStatement1.setString(1,StuName);
                preparedStatement1.setInt(2,StuID);
                if(preparedStatement1.executeUpdate()>=1){
                    resultStr = "删除成功！";
                }
            }
        }
        return resultStr;
    }

    /**
     * 修改学生信息。
     * @param ChangeWho 需要修改信息的学生姓名。
     * @param StuSex 学生性别。
     * @param StuAge 学生年龄。
     * @param StuDept 学生系别。
     * @param StuPassword 学生密码，如果需要修改密码。
     * @return 操作结果的描述信息。
     */
    public String reviseStuInfo(String ChangeWho,String StuSex,int StuAge,String StuDept,String StuPassword) throws SQLException {
        String resultStr = "修改失败！";
        // 更新学生信息表
        String sqlStr = "update student set  sex = ? , age = ? , dept = ? where name = ?";

        PreparedStatement preparedStatement = this.con.prepareStatement(sqlStr);

        preparedStatement.setString(1,StuSex);
        preparedStatement.setInt(2,StuAge);
        preparedStatement.setString(3,StuDept);
        preparedStatement.setString(4,ChangeWho);
        if(preparedStatement.executeUpdate()>=0&&StuPassword==null){
            resultStr = "修改成功！";
        }
        if(StuPassword!=null){
            // 如果提供了新密码，更新学生登录表
            String sqlStr1 = "update studentLogin set password = ? where name = ?";
            PreparedStatement preparedStatement1 = this.con.prepareStatement(sqlStr1);
            preparedStatement1.setString(1,StuPassword);
            preparedStatement1.setString(2,ChangeWho);
            if(preparedStatement1.executeUpdate()>=1){
                resultStr = "修改成功！";
            }
        }
        return resultStr;
    }

    /**
     * 获取指定学生的ID。
     * @param name 学生的姓名。
     * @return 学生的ID，如果未找到则返回null。
     */
    public String getId(String name) throws SQLException {
        String resultStr = null;
        String sqlStr = "select id from student where name = ? ";
        PreparedStatement preparedStatement = this.con.prepareStatement(sqlStr);
        preparedStatement.setString(1,name);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            resultStr = resultSet.getString("id");
        }
        System.out.println(resultStr);
        return resultStr;
    }

    /**
     * 获取指定学生的系部信息。
     * @param name 学生的姓名。
     * @return 学生的系部信息，如果未找到则返回null。
     */
    public String getDept(String name) throws SQLException {
        String resultStr = null;
        String sqlStr = "select dept from student where name = ?";
        PreparedStatement preparedStatement = this.con.prepareStatement(sqlStr);
        preparedStatement.setString(1,name);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            resultStr = resultSet.getString("dept");
        }
        return resultStr;
    }

    /**
     * 获取指定学生的年龄。
     * @param name 学生的姓名。
     * @return 学生的年龄，如果未找到则返回null。
     */
    public String getAge(String name) throws SQLException {
        String resultAge = null;
        String sqlStr = "select age from student where name = ?";
        PreparedStatement preparedStatement = this.con.prepareStatement(sqlStr);
        preparedStatement.setString(1,name);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            resultAge = resultSet.getString("age");
        }
        return resultAge;
    }

    /**
     * 获取指定学生的性别。
     * @param name 学生的姓名。
     * @return 学生的性别，如果未找到则返回null。
     */
    public String getSex(String name) throws SQLException {
        String resultSex = null;
        String sqlStr = "select sex from student where name = ?";
        PreparedStatement preparedStatement = this.con.prepareStatement(sqlStr);
        preparedStatement.setString(1,name);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            resultSex = resultSet.getString("sex");
        }
        return resultSex;
    }


    public int FindGrade(String studentName,String courseName) throws SQLException {

        int result = 0;
        String sqlStr = "select grade from chooseCourse where studentName = ? and courseName = ?";
        PreparedStatement preparedStatement = this.con.prepareStatement(sqlStr);
        preparedStatement.setString(1,studentName);
        preparedStatement.setString(2,courseName);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            result = resultSet.getInt("grade");

        }
        return result;
    }

    /**
     * 学生选课操作。
     * @param stuID 学生ID。
     * @param stuName 学生姓名。
     * @param courseID 课程ID。
     * @param courseName 课程名称。
     * @return 操作结果的描述信息。
     */
    public String ChooseCourse(String stuID,String stuName,String courseID , String courseName) throws SQLException {
        String resultStr = "选课失败";
        String sqlStr = "insert into chooseCourse values(?,?,?,?,null)";
        PreparedStatement preparedStatement = this.con.prepareStatement(sqlStr);
        preparedStatement.setString(1,stuID);
        preparedStatement.setString(2,stuName);
        preparedStatement.setString(3,courseID);
        preparedStatement.setString(4,courseName);

        if(preparedStatement.executeUpdate()>=1){
            resultStr = "选课成功";
        }
        return resultStr;
    }

}
