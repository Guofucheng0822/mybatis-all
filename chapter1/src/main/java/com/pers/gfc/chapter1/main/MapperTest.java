package com.pers.gfc.chapter1.main;


import com.pers.gfc.chapter1.mapper.RoleMapper;
import com.pers.gfc.chapter1.pojo.Role;
import com.pers.gfc.chapter1.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

/**
 * 映射器测试
 *
 * @author guofucheng
 * @date 2020/09/30
 */
public class MapperTest {
    public static void main(String[] args) {
        SqlSessionFactory sqlSessionFactory;
        SqlSession sqlSession = null;
        try {
            sqlSessionFactory = MyBatisUtil.getSqlSessionFactory();
            sqlSession = sqlSessionFactory.openSession();
            RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
            Role role = roleMapper.findByRoleId(3);
            System.out.println(role);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            MyBatisUtil.close(sqlSession);
        }
    }
}
