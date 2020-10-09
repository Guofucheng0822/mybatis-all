package com.pers.gfc.chapter3.mapper;

import com.pers.gfc.chapter3.po.Role;

/**
 * configuration.addMapper(RoleMapper2.class)
 * 注册当前接口为映射器.
 */
public interface RoleMapper {
    Role getRole(Integer id);

    int deleteRole(Long id);

    int insertRole(Role role);
}