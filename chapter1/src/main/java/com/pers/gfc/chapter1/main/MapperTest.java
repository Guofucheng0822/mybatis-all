package com.pers.gfc.chapter1.main;


import com.pers.gfc.chapter1.mapper.RoleMapper;
import com.pers.gfc.chapter1.util.MyBatisUtil;

public class MapperTest {
    public static void main(String[] args) {
        System.out.println(MyBatisUtil.getSqlSessionFactory().openSession().getMapper(RoleMapper.class).findByRoleId(3));
    }
}
