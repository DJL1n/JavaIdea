package dao;

import model.Admin;
import view.IndexFrame;
import java.sql.ResultSet;
import java.sql.SQLException;

import static view.IndexFrame.admin;

/**
 * 管理员数据访问对象类，继承自BaseDao。
 * 包含管理员登录和密码修改的方法。
 */
public class AdminDao extends BaseDao {
    /**
     * 管理员登录方法。
     * @param name 管理员用户名。
     * @param password 管理员密码。
     * @return 如果登录成功返回Admin对象，否则返回null。
     */
    public Admin selectAdmin(String name, String password){
        // SQL查询语句
        String sqlStr = "select * from adminLogin where name = ? and password = ?";
        Admin admin = null;
        try {
            // 准备SQL语句
            this.pStatement = this.con.prepareStatement(sqlStr);
            this.pStatement.setString(1, name);
            this.pStatement.setString(2, password);
            // 执行查询
            ResultSet executeQuery = this.pStatement.executeQuery();
            if (executeQuery.next()) {
                // 创建Admin对象
                admin = new Admin(executeQuery.getInt(1), executeQuery.getString(2), executeQuery.getString(3));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 关闭数据库连接
            this.close();
        }
        return admin;
    }

    /**
     * 管理员密码修改方法。
     * @param name 管理员用户名。
     * @param newPassword 新密码。
     * @return 操作结果提示。
     */
    public String revisePassword(String name, String newPassword){
        String resultStr = "操作失败";
        // SQL更新语句
        String sqlStr = "update adminLogin set password = ? where name = ? and password = ?";
        try {
            // 准备SQL语句
            this.pStatement = this.con.prepareStatement(sqlStr);
            this.pStatement.setString(1, newPassword);
            this.pStatement.setString(2, admin.getName());
            this.pStatement.setString(3, admin.getPassword());
            // 执行更新
            if (pStatement.executeUpdate() > 0) {
                resultStr = "操作成功！";
                // 更新IndexFrame中的管理员密码
                IndexFrame.admin.setPassword(newPassword);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 关闭数据库连接
            this.close();
        }
        return resultStr;
    }
}