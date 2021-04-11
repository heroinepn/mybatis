import com.pn.dao.userMapper;

import com.pn.entity.User;
import com.pn.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.testng.annotations.Test;


public class Test1 {




    @Test
    public void queryUser(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        userMapper mapper = sqlSession.getMapper(userMapper.class);
        User user = mapper.queryUserById(1);
        System.out.println(user);
        System.out.println("====缓存传入两次一样的ID看输出日志");
        User user2 = mapper.queryUserById(1);
        System.out.println(user2);
        mapper.updateUser(new User(10,"jk","123"));
        //sqlSession.clearCache();//手动清理缓存
        System.out.println("不一样的时候");
        User user3 = mapper.queryUserById(2);
        System.out.println(user3);
        sqlSession.close();
    }

    @Test
    public void queryUser2(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        SqlSession sqlSession2 = MybatisUtils.getSqlSession();
        userMapper mapper = sqlSession.getMapper(userMapper.class);
        User user = mapper.queryUserById(1);
        System.out.println(user);
        sqlSession.close();

        userMapper mapper2 = sqlSession2.getMapper(userMapper.class);

        User user2 = mapper2.queryUserById(1);
        System.out.println(user2);
        sqlSession2.close();
    }
}
