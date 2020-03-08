package com.itheima.mybatis.mapper;

import com.itheima.mybatis.pojo.QueryVo;
import com.itheima.mybatis.pojo.User;

import java.util.List;

public interface UserMapper {


    /**
     * 遵循四个原则
     * 1 接口 方法名  == Mapper.xml 中 id 名
     * 2 返回值类型  与  Mapper.xml文件中返回值类型要一致
     * 3 方法的入参类型 与Mapper.xml中入参的类型要一致
     * 4 命名空间 绑定此接口
     *
     * @param id
     * @return
     */
    User findUserById(Integer id);

    /**
     * @param vo
     * @return
     */
    List<User> findUserByQueryVo(QueryVo vo);

    List<User> findUserBySexAndUserName(User user);

    List<User> findUserByIds(QueryVo vo);

    List<User> findUserByIdsUseList(List<Integer> ids);

    List<User> findUserByIdsUseArray(Integer[] ids);


}