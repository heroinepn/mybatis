import com.pn.dao.UserMapper;
import com.pn.entity.User;
import com.pn.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class TestLog {

    @Test
    public void test(){
        //注解容易造成混乱
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> users = mapper.getUsers();
        for (User user : users) {
            System.out.println(user);
        }
        sqlSession.close();
    }
@Test
    public void getById(){
        //注解容易造成混乱
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User userByID = mapper.getUserByID(1);
        System.out.println(userByID);

        sqlSession.close();
    }

@Test
public void getAddUser(){
        //注解容易造成混乱
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.addUser(new User(16, "test", "111"));
        sqlSession.close();
        }
     @Test
    public void updatUser(){
        //注解容易造成混乱
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.updateUser(new User(10,"tt","123"));
        sqlSession.close();
    }
    @Test
    public void deleteUser(){
        //注解容易造成混乱
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.deleteUser(16);
        sqlSession.close();
    }

}




