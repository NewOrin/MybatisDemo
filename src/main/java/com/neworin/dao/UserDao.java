package com.neworin.dao;

import com.neworin.entity.User;

import java.util.List;

/**
 * Created by NewOrin Zhang on 2016/6/29.
 * Email: NewOrinZhang@Gmail.com
 */
public interface UserDao {
    /**
     * 用户增加
     *
     * @param user
     */
    void insert(User user);

    /**
     * 根据id删除
     *
     * @param id
     */
    void delete(int id);

    /**
     * 更新User
     *
     * @param user
     */
    void update(User user);

    /**
     * 查询表中所有数据
     *
     * @return
     */
    List<User> queryAll();

    /**
     * 根据User查询
     *
     * @param id
     * @return
     */
    User queryById(int id);
}
