package com.itheima.mybatis.dao;

import com.itheima.mybatis.pojo.User;

import java.util.List;

public interface UserDao {
    /**
     * 根据id查询用户
     *
     * @param id
     * @return
     */
    User queryUserById(int id);

    /**
     * 根据用户名模糊查询用户列表
     *
     * @param username
     * @return
     */
    List<User> queryUserByUsername(String username);

    /**
     * 保存
     *
     * @param user
     */
    void saveUser(User user);


}
