package com.gfc.chapter1.mapper;

import com.gfc.chapter1.po.Role;

/**
 * configuration.addMapper(RoleMapper2.class)
 * 注册当前接口为映射器.
 */
public interface RoleMapper {
    Role getRole(Long id);

    int deleteRole(Long id);

    int insertRole(Role role);
}