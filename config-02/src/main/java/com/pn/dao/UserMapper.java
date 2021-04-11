package com.pn.dao;

import com.pn.entity.User;

import java.util.List;

public interface UserMapper{
    //根据id查用户
    User getUserById(int id);

    List<User> getUserList();


}