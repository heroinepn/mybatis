package com.pn.dao;

import com.pn.entity.User;

import java.util.List;
import java.util.Map;

public interface UserMapper{
    //根据id查用户
    User getUserById(int id);

    List<User> getUserList();

    List<User> getUserByLimit(Map<String,Integer> map);
    //分⻚2
    List<User> getUserByRowBounds();


}