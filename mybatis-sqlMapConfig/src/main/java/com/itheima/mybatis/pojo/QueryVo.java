package com.itheima.mybatis.pojo;

import java.io.Serializable;
import java.util.List;

/**
 * @program: mybatis-sqlMapConfig
 * @description: 封装User的类
 * @author: JClearLove
 * @Date: 2020/03/06 09:59
 */
public class QueryVo implements Serializable {
    private static final long serialVersionUID = 1L;
    private User user;

    private List<Integer> ids;

    public List<Integer> getIds() {
        return ids;
    }

    public void setIds(List<Integer> ids) {
        this.ids = ids;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

