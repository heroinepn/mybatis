package com.pn.entity;

import lombok.Data;

import java.util.List;

@Data
public class Teacher {
    private int id;
    private String name;
    //⼀个⽼师拥有多个学⽣
    private List<Student> students;
}
