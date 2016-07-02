package com.neworin.test;

import com.neworin.dao.UserDao;
import com.neworin.dao.impl.UserDaoImpl;
import com.neworin.entity.User;
import com.neworin.utils.MybatisSessionFactory;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

/**
 * Created by NewOrin Zhang on 2016/6/26.
 * Email: NewOrinZhang@Gmail.com
 */
public class MyBatisTest {

    UserDao userDao;

    @Before
    public void init() {
        userDao = new UserDaoImpl();
    }

    /**
     * 根据Id查询
     */
    @Test
    public void testQueryById() {
        userDao.queryById(1);
    }

    /**
     * 查询所有
     */
    @Test
    public void testQueryAll() {
        userDao.queryAll();
    }

    /**
     * 增加操作
     */
    @Test
    public void testInsert() {
        User user = new User("信工一哥", 22);
        userDao.insert(user);
    }

    /**
     * 删除操作
     */
    @Test
    public void testDelete() {
        userDao.delete(4);
    }

    @Test
    public void testUpdate() {
        User user = new User(1, 20, "钢铁侠");
        userDao.update(user);
    }

    @After
    public void closeSession() {
        MybatisSessionFactory.closeSession();
    }
}
