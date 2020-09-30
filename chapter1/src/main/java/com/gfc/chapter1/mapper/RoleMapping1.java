package com.gfc.chapter1.mapper;

import com.gfc.chapter1.po.Role;
import org.apache.ibatis.annotations.Select;

public interface RoleMapping1 {
    @Select(value = "select id,role_name as roleName,note from t_role where id =#{id} ")
    Role getRole(Long id);
}