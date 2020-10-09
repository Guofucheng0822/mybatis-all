package com.pers.gfc.chapter3.main;

import com.pers.gfc.chapter3.po.Role;
import com.pers.gfc.chapter3.util.SqlSessionFactoryUtil;
import com.pers.gfc.chapter3.mapper.RoleMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Objects;

public class Chapter3Main {

    private static Logger logger = LogManager.getLogger(Chapter3Main.class.getName());

    public static void main(String[] args) {
        SqlSession sqlSession = null;
        try {
            sqlSession = SqlSessionFactoryUtil.openSqlSession();
            RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
//            Role role = new Role("name", "note");
//            roleMapper.insertRole(role);
//            roleMapper.deleteRole(1L);
            Role role = roleMapper.getRole(3);
            System.out.println(role);
            sqlSession.commit();
        } catch (Exception e) {
            System.err.println(e.getMessage());
            Objects.requireNonNull(sqlSession).rollback();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
        logger.info("执行成功!");
    }
}