package com.pers.gfc.chapter2.mapper;

import com.pers.gfc.chapter2.po.Role;
import org.apache.ibatis.annotations.Select;

/**
 * 注解方式实现
 *
 * @author guofucheng
 * @date 2020/10/09
 */
public interface RoleMapping1 {
    @Select(value = "select id,role_name as roleName,note from t_role where id =#{id} ")
    Role getRole(Long id);
}