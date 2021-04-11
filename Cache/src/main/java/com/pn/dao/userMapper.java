package com.pn.dao;

import com.pn.entity.User;
import org.apache.ibatis.annotations.Param;

public interface userMapper {
    //查询全部用户
    User queryUserById(@Param("id") int id);
    //修改用户
    int updateUser(User user);
}
