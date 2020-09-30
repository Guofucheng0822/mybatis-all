package com.pers.gfc.chapter1.main;

import com.pers.gfc.chapter1.util.JDBCUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 示例测试[使用JDBCUtil]
 *
 * @author guofucheng
 * @date 2020/09/30
 */
public class ExampleTest {
    public static void main(String[] args) throws SQLException {
        Connection connection = JDBCUtil.getConnection();
        PreparedStatement prepareStatement = connection.prepareStatement("select * from t_role where id = ?");
        prepareStatement.setInt(1,3);
        ResultSet resultSet = prepareStatement.executeQuery();
        while (resultSet.next()){
            System.out.println(resultSet.getInt("id"));
            System.out.println(resultSet.getString("role_name"));
            System.out.println(resultSet.getString("note"));
        }
        // 关闭连接，释放资源
        JDBCUtil.close(resultSet,prepareStatement,connection);
    }
}
