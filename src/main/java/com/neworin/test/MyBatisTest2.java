package com.neworin.test;

import com.neworin.dao.UserDao2;
import com.neworin.entity.User;
import com.neworin.utils.MybatisSessionFactory;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * Created by NewOrin Zhang on 2016/6/30.
 * Email: NewOrinZhang@Gmail.com
 */
public class MyBatisTest2 {
    @Test
    public void testFindAll() {
        SqlSession session = MybatisSessionFactory.getSession();
        if (session == null) {
            System.out.println("无法获取连接");
        }
        List<User> userList = session.getMapper(UserDao2.class).findAll();
        for (User n : userList) {
            System.out.println(n);
        }
        MybatisSessionFactory.closeSession();
    }

    @Test
    public void testFindById() {
        SqlSession session = MybatisSessionFactory.getSession();
        if (session == null) {
            System.out.println("无法获取连接");
        }
        User user = session.getMapper(UserDao2.class).findById(1);
        System.out.println(user);
        MybatisSessionFactory.closeSession();
    }

    @Test
    public void testUpdateUser() {
        SqlSession session = MybatisSessionFactory.getSession();
        if (session == null) {
            System.out.println("无法获取连接");
        }
        User user = session.getMapper(UserDao2.class).findById(1);
        user.setName("玛莎拉蒂");
        session.getMapper(UserDao2.class).updateUser(user);
        session.commit();
        MybatisSessionFactory.closeSession();
        System.out.println("更新成功!");

    }
}
