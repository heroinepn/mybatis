package com.pn.dao;

import com.pn.entity.Blog;

import java.util.List;
import java.util.Map;

public interface BlogMapper {
    //插入数据
    int addBlog(Blog blog);
    //查询博客
    List<Blog>queryBlogIF(Map map);
    List<Blog>queryBlogChoose(Map map);
    //更新
    int updateBlog(Map map);
    //查询1-4记录
    List<Blog> queryBlogForeach(Map map);
}
