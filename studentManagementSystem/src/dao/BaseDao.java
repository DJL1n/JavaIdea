package dao;

import util.DBUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * 数据访问对象的基类，提供数据库连接和关闭连接的方法。
 */
public abstract class BaseDao {
    // 数据库连接对象
    protected Connection con = DBUtil.getConnection();
    // 预编译SQL语句对象
    protected PreparedStatement pStatement = null;

    /**
     * 关闭数据库连接的方法。
     */
    protected void close(){
        try {
            this.con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}