package com.itheima.mybatis.dao.imp;

import java.util.List;

import com.itheima.mybatis.dao.UserDao;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.itheima.mybatis.pojo.User;

/**
 * Dao
 *
 * @author lx
 */
public class UserDaoImpl implements UserDao {

    //注入
    private SqlSessionFactory sqlSessionFactory;

    public UserDaoImpl(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    //通过用户ID查询一个用户
    @Override
    public User selectUserById(Integer id) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        return sqlSession.selectOne("test.findUserById", id);
    }


}
