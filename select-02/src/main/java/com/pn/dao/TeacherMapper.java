package com.pn.dao;
import com.pn.entity.Teacher;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public  interface TeacherMapper{
    List<Teacher>getTeacher();
    //获取指定老师下的所有学生及老师的信息
    Teacher getTeacher2(@Param("tid") int id);
}
