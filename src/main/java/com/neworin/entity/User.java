package com.neworin.entity;

import java.io.Serializable;

/**
 * Created by NewOrin Zhang on 2016/6/26.
 * Email: NewOrinZhang@Gmail.com
 */
public class User implements Serializable {
    private int _id;
    private String name;
    private int age;

    public User() {
        super();
    }

    public User(int _id, int age, String name) {
        this._id = _id;
        this.age = age;
        this.name = name;
    }

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "_id=" + _id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
