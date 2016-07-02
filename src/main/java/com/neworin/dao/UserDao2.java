package com.neworin.dao;

import com.neworin.entity.User;

import java.util.List;

/**
 * Created by NewOrin Zhang on 2016/6/30.
 * Email: NewOrinZhang@Gmail.com
 */
public interface UserDao2 {
    List<User> findAll();

    User findById(int id);

    void updateUser(User user);
}
