package com.neworin.dao.impl;

import com.neworin.dao.UserDao;
import com.neworin.entity.User;
import com.neworin.utils.MybatisSessionFactory;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * Created by NewOrin Zhang on 2016/6/29.
 * Email: NewOrinZhang@Gmail.com
 */
public class UserDaoImpl implements UserDao {

    private SqlSession sqlSession;

    public UserDaoImpl() {
        this.sqlSession = MybatisSessionFactory.getSession();
    }

    public void insert(User user) {
        sqlSession.insert("UserMapper.insertUser", user);
        sqlSession.commit();
        sqlSession.close();
        System.out.println("插入数据成功!" + user);
    }

    public void delete(int id) {
        sqlSession.delete("UserMapper.deleteUserById", id);
        sqlSession.commit();
        System.out.println("删除成功!");
        sqlSession.close();
    }

    public void update(User user) {
        sqlSession.update("UPDATE USER SET name=" + user.getName() + " WHERE _id=" + user.get_id());
        sqlSession.commit();
        sqlSession.close();
        System.out.println("更新成功!");
    }

    public List<User> queryAll() {
        String statement = "UserMapper.getAllUser";
        List<User> list = sqlSession.selectList(statement);
        for (User u : list) {
            System.out.println("查询成功!" + "\n" + u.toString());
        }
        sqlSession.close();
        return list;
    }

    public User queryById(int id) {
        String statement = "UserMapper.getUserById";
        /**
         * 映射sql的标识字符串，
         * com.neworin.entity.userMapping是userMapper.xml文件中mapper标签的namespace属性的值，
         * getUser是select标签的id属性值，通过select标签的id属性值就可以找到要执行的SQL
         */
        User user = sqlSession.selectOne(statement, id);
        System.out.println("查询成功!" + "\n" + user.toString());
        sqlSession.close();
        return user;
    }
}
