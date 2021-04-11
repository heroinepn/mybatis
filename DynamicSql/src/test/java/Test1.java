import com.pn.dao.BlogMapper;
import com.pn.entity.Blog;
import com.pn.utils.IDUtils;
import com.pn.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;


public class Test1 {
    @Test
    public void addBlogTest() {
        //事务自动提交已配置
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        Blog blog = new Blog();
        blog.setId(IDUtils.getId());
        blog.setTitle("Mybatis");;
        blog.setAuthor("pn");
        blog.setCreateTime(new Date());
        blog.setViews(9999);

        mapper.addBlog(blog);

        blog.setId(IDUtils.getId());
        blog.setTitle("Java");
        mapper.addBlog(blog);

        blog.setId(IDUtils.getId());
        blog.setTitle("Spring");
        mapper.addBlog(blog);

        blog.setId(IDUtils.getId());
        blog.setTitle("微服务");
        mapper.addBlog(blog);
        //sqlSession.commit();//配置文件失效手动提交
        sqlSession.close();
    }
    @Test
    public void queryBlogIF(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        //因为是map参数 new一个map传进mapper.queryBlogIF返回Blog对象blogs for遍历Blog对象blog存储到blogs
        //put传键值对参数查询对应的信息 实例化后存储键值对
        HashMap map = new HashMap();
        map.put("title","Java");
        map.put("author","pn");
        List<Blog> blogs = mapper.queryBlogIF(map);
        for (Blog blog : blogs) {
            System.out.println(blog);
        }
        sqlSession.close();
    }
    @Test
    public void queryBlogChoose(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        HashMap map = new HashMap();
        //choose 选择一个满足即可
        map.put("views","9999");
        map.put("title","Java");
        map.put("author","pn");
        List<Blog> blogs = mapper.queryBlogChoose(map);
        for (Blog blog : blogs) {
            System.out.println(blog);
        }
        sqlSession.close();
    }
    @Test
    public void updateBlog(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        HashMap map = new HashMap();
        map.put("title","Java");
        map.put("id","4d1df69551b54001884c48e84dbc6c7c");
         mapper.updateBlog(map);

        sqlSession.close();
    }

    @Test
    public void queryBlogForeach(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        HashMap map = new HashMap();
        ArrayList<Integer> ids = new ArrayList<>();
        ids.add(1);
        ids.add(2);
         map.put("ids", ids);

        List<Blog> blogs = mapper.queryBlogForeach(map);

        for (Blog blog : blogs) {
            System.out.println(blog);
        }
        sqlSession.close();
    }
}