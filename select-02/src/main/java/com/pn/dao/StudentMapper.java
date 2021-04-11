package com.pn.dao;


import com.pn.entity.Student;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface StudentMapper {
    @Select("select * from teacher where id= #{tid}")
    Student getTeacher(@Param("tid")int id);
}
