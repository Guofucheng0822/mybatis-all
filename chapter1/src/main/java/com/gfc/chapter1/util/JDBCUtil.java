package com.gfc.chapter1.util;

import com.gfc.chapter1.main.JdbcExample;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * JDBCUtil
 * 封装原生的JDBC
 *
 * @author guofucheng
 * @date 2020/09/30
 */
public class JDBCUtil {

    private static String url="url";
    private static String username="username";
    private static String password="password";
    private static String driver="driver";

    static {
        try {
            Properties properties=new Properties();
            InputStream inputStream = JDBCUtil.class.getClassLoader().getResourceAsStream("application.properties");
            properties.load(inputStream);
            url=properties.getProperty(url);
            username=properties.getProperty(username);
            password=properties.getProperty(password);
            driver=properties.getProperty(driver);
            Class.forName(driver);
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获得连接
     *
     * @return {@link Connection}* @throws SQLException SQLException异常
     */
    public static Connection getConnection() throws SQLException {
            return DriverManager.getConnection(url, username, password);
    }

    /**
     * 得到Statement对象
     *
     * @return {@link Statement}* @throws SQLException SQLException异常
     */
    public static Statement getStatement() throws SQLException {
        Connection connection = getConnection();
        return connection.createStatement();
    }
    /**
     * 得到Statement对象
     *
     * @return {@link Statement}* @throws SQLException SQLException异常
     */
    public static PreparedStatement getPrepareStatement(String sql) throws SQLException {
        Connection connection = getConnection();
        return connection.prepareStatement(sql);
    }
    /**
     * 释放资源
     * @param rs
     * @param st
     * @param conn
     */
    public static void close(ResultSet rs, Statement st, Connection conn){
        if (rs != null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(st != null){
            try {
                st.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (conn != null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
