package com.pn.entity;

import lombok.Data;

import java.util.Date;
@Data
public class Blog {
    private String id;
    private String title;
    private String author;
    //属性和数据库字段名不一样映射 这次在总配置文件用特定驼峰转换
    private Date createTime;
    private int views;
}
