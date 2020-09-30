package com.pers.gfc.chapter1.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;

/**
 * MyBatis工具类
 *
 * @author guofucheng
 * @date 2020/09/30
 */
public class MyBatisUtil {
    private static SqlSessionFactory sqlSessionFactory;

    /**
     * 获得SqlSessionFactory
     *
     * @return {@link SqlSessionFactory}
     */
    public static SqlSessionFactory getSqlSessionFactory(){
        if (sqlSessionFactory==null){
            try {
                sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return sqlSessionFactory;
    }

    /**
     * 关闭SqlSession
     *
     * @param sqlSession sql会话
     */
    public static void close(SqlSession sqlSession){
        if (sqlSession !=null){
            sqlSession.close();
        }
    }
}
