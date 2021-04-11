package src.test;

import com.pn.dao.UserMapper;
import com.pn.entity.User;
import com.pn.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;

;import java.util.List;

public class UserDaoTest {


    @Test
    public void getUserById(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.getUserById(2);
        System.out.println(user);
        sqlSession.close();
    }

@Test
    public  void test(){
        //第⼀步：获得SqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();
//⽅式⼀：getMapper
        UserMapper usermapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = usermapper.getUserList();
        //方式二
        //List<User> useList=sqlSession.selectList("com.pn.dao.UserDao.getUserList") ;
        for (User user : userList) {
            System.out.println(user);
        }
//关闭SqlSession
        sqlSession.close();
    }

}