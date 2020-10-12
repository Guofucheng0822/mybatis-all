package com.pers.gfc.chapter3.mapper;

import com.pers.gfc.chapter3.po.User;

/**
 * 用户映射器
 *
 * @author guofucheng
 * @date 2020/10/10
 */
public interface UserMapper {
    /**
     * 发现通过Id
     *
     * @param id id
     * @return {@link User}
     */
    User findById(Integer id);

    /**
     * 插入用户
     *
     * @param user 用户
     */
    void insertUser(User user);
}
