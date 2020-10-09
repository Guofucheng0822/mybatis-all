package com.pers.gfc.chapter2.util;

import lombok.NoArgsConstructor;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

@NoArgsConstructor
public class SqlSessionFactoryUtil {
    //类线程锁
    private static final Class CLASS_LOCK = SqlSessionFactoryUtil.class;
    private static final Logger logger = Logger.getLogger(SqlSessionFactoryUtil.class.getName());
    //SqlSessionFactory对象
    private static SqlSessionFactory sqlSessionFactory = null;

    private static SqlSessionFactory getInstance() {
        String resource = "mybatis-config.xml";
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            logger.log(Level.SEVERE, "======getInstance error======", e);
        }
        synchronized (CLASS_LOCK) {
            if (sqlSessionFactory == null) {
                sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            }
        }
        return sqlSessionFactory;
    }

    public static SqlSession openSqlSession() {
        if (sqlSessionFactory == null) {
            getInstance();
        }
        return sqlSessionFactory.openSession();
    }
}