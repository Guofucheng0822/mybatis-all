package com.pers.gfc.chapter1.mapper;

import com.pers.gfc.chapter1.pojo.Role;

/**
 * 角色映射器
 *
 * @author guofucheng
 * @date 2020/09/30
 */
public interface RoleMapper {
    /**
     * 通过角色Id查询
     *
     * @param roleId 角色Id
     * @return {@link Role}
     */
    Role findByRoleId(Integer roleId);
}
