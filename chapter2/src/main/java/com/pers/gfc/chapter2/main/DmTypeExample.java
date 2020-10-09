package com.pers.gfc.chapter2.main;

import com.pers.gfc.chapter2.mapper.RoleMapper;
import com.pers.gfc.chapter2.po.Role;
import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 代码方式构建mybatis的例子
 *
 * @author guofucheng
 * @date 2020/10/09
 */
public class DmTypeExample {
    public static void main(String[] args) throws Exception {
        // 构建数据库连接池
        InputStream inputStream = Resources.getResourceAsStream("application.properties");
        Properties properties=new Properties();
        properties.load(inputStream);
        PooledDataSource pooledDataSource=new PooledDataSource();
        pooledDataSource.setDriver(properties.getProperty("driver"));
        pooledDataSource.setUrl(properties.getProperty("url"));
        pooledDataSource.setUsername(properties.getProperty("username"));
        pooledDataSource.setPassword(properties.getProperty("password"));
        // 构建数据库事务方式
        TransactionFactory transactionFactory=new JdbcTransactionFactory();
        // 构建数据库运行环境
        Environment environment=new Environment("dev",transactionFactory,pooledDataSource);
        // 创建mybatis的配置类
        Configuration configuration =new Configuration(environment);
        // 注册上下文别名
        configuration.getTypeAliasRegistry().registerAlias("role", Role.class);
        //加入映射器
        /*
          如果映射器的类路径和Mapper文件的路径不一致，
          会出现BindingException: Invalid bound statement (not found):com....xxxMapper。
          解决方法:使用configuration.getMapperRegistry().addMappers方式
         */
        configuration.addMapper(RoleMapper.class);
        // configuration.getMapperRegistry().addMappers("com.pers.gfc.chapter2.mapper",RoleMapper.class);
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder= new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(configuration);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
        Role role = roleMapper.getRole(3L);
        System.out.println(role);
        sqlSession.commit();
        sqlSession.close();
        Logger.getLogger(DmTypeExample.class.getName()).log(Level.INFO,"执行成功");
    }
}
