package com.pn.dao;

import com.pn.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;
//注意：接⼝注册绑定到我们的核⼼配置⽂件中
public interface UserMapper{
    @Select("select * from user")
    List<User> getUsers();

    // ⽅法存在多个参数，所有的参数前⾯必须加上 @Param("id")注解
    @Select("select * from user where id = #{id}")
    User getUserByID(@Param("id") int id);
    //对象不用
    @Insert("insert into user(id,name,pwd) values (#{id},#{name},#{password})")
    int addUser(User user);
    @Update("update user set name=#{name},pwd=#{password} where id = #{id}")
            int updateUser(User user);
    //uid映射
    @Delete("delete from user where id = #{uid}")
    int deleteUser(@Param("uid") int id);
}

