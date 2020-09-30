package com.pers.gfc.chapter1.main;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

/**
 * Jdbc Example
 * 传统的JDBC编程
 *
 * @author guofucheng
 * @date 2020/09/30
 */
public class JdbcExample {
    public static void main(String[] args) throws Exception {
        Properties properties=new Properties();
        InputStream inputStream = JdbcExample.class.getClassLoader().getResourceAsStream("application.properties");
        properties.load(inputStream);
        System.out.println(properties);
        // 第1步：注册mysql数据库驱动
        Class.forName(properties.getProperty("driver"));
        // 第2步：通过DriverManager类获取数据库连接
        Connection connection = DriverManager.getConnection(properties.getProperty("url"), properties.getProperty("username"), properties.getProperty("password"));
        // 第3步：通过Connection对象获取Statement对象
        Statement statement = connection.createStatement();
        // 第4步：使用Statement执行SQL语句，返回一个ResultSet结果集对象
        ResultSet resultSet = statement.executeQuery("select * from t_role");
        // 第5步：使用操作ResultSet结果集
        while (resultSet.next()){
            System.out.println(resultSet.getInt("id"));
            System.out.println(resultSet.getString("role_name"));
            System.out.println(resultSet.getString("note"));
        }
        // 第6步：关闭连接，释放资源
        resultSet.close();
        statement.close();
        connection.close();
    }
}
