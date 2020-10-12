package com.pers.gfc.chapter3.main;

import com.pers.gfc.chapter3.mapper.UserMapper;
import com.pers.gfc.chapter3.po.Role;
import com.pers.gfc.chapter3.po.SexEnum;
import com.pers.gfc.chapter3.po.User;
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
//            RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
// 1.           Role role = new Role("name", "note");
//              roleMapper.insertRole(role);
// 2.           roleMapper.deleteRole(1L);
// 3.           Role role = roleMapper.getRole(3);
//            System.out.println(role);
            User newUser=new User();
            newUser.setCnName("李四");
            newUser.setUserName("李四");
            newUser.setSex(SexEnum.SEX_MALE);
            newUser.setMobile("13963696365");
            newUser.setEmail("10203658956@qq.com");
            newUser.setNote("李四note");
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
//            userMapper.insertUser(newUser);
            User user = userMapper.findById(2);
            System.out.println(user);
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