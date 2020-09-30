package com.gfc.chapter1.main;

import com.gfc.chapter1.mapper.RoleMapper;
import com.gfc.chapter1.po.Role;
import com.gfc.chapter1.util.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author guofucheng
 */
public class Chapter1Main {

    private static Logger logger = LogManager.getLogger(Chapter1Main.class.getName());

    public static void main(String[] args) {
        SqlSession sqlSession = null;
        try {
            sqlSession = SqlSessionFactoryUtil.openSqlSession();
            RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
            Role role = new Role("name", "note");
            roleMapper.insertRole(role);
            //roleMapper.deleteRole(1L);
            sqlSession.commit();
        } catch (Exception e) {
            System.err.println(e.getMessage());
            if (sqlSession != null) {
                sqlSession.rollback();
            }
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
        logger.info("执行成功!");
    }
}