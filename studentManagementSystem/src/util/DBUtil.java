package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 数据库工具类，用于创建和提供数据库连接。
 * 负责加载JDBC驱动并建立与数据库的连接。
 */
public class DBUtil {
    // 定义JDBC驱动类名
    private static String jdbcDriver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";

    /**
     * 获取数据库连接的方法。
     * @return 返回一个与数据库的连接对象，如果连接失败返回null。
     */
    public static Connection getConnection() {
        Connection dbConnection = null;
        try {
            // 加载JDBC驱动类
            Class.forName(jdbcDriver);
        } catch (ClassNotFoundException e) {
            // 找不到驱动类时打印异常信息
            e.printStackTrace();
        }
        try {
            // 使用try-with-resources语句自动关闭数据库连接
            dbConnection = DriverManager.getConnection(
                    "jdbc:sqlserver://127.0.0.1:1433;DatabaseName=studentManagementSystem",
                    "sa", "123456");
            // 输出数据库连接成功的消息
            System.out.println("数据库连接成功");
        } catch (SQLException e) {
            // 数据库连接失败时打印异常信息
            e.printStackTrace();
        }
        return dbConnection;
    }
}