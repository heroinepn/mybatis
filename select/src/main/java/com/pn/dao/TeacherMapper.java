package com.pn.dao;

import com.pn.entity.Teacher;
import org.apache.ibatis.annotations.*;
public  interface TeacherMapper{
    @Select("select * from teacher where id= #{tid}")
    Teacher getTeacher(@Param("tid")int id);
}
