package com.pn.dao;

import com.pn.entity.User;

import java.util.List;
import java.util.Map;

public interface UserMapper{
    //查询全部用户
    List<User> getUserList();
    //根据id查用户
    User getUserById(int id);
    User getUserById2(Map<String,Object> map);
    //Map
    int addUser2(Map<String,Object> map);
    //插入一个用户
    int addUser(User user);
    //修改用户
   void updateUser(User user);
   //删除一个用户
    void deleteUser(int id);
    //模糊查询
    List <User> getUserLike (String value);
}
