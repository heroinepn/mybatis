import com.pn.dao.UserMapper;
import com.pn.entity.User;
import com.pn.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserDaoTest {

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
    @Test
    public void getUserById(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.getUserById(1);
        System.out.println(user);
        sqlSession.close();
    }
    @Test
    public void getUserById2(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("mid",1);
        User id2 = mapper.getUserById2(map);
        System.out.println(id2);
        sqlSession.close();
    }
    //增删改需要提交事务
    @Test
    public void addUser(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int ff = mapper.addUser(new User(8, "hh", "128"));
        if (ff >=0) {
            System.out.println("success"+ff);
        }
        //提交事务
        sqlSession.commit();
        sqlSession.close();

    }

    @Test
    public void addUser2() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        HashMap<String, Object> map = new HashMap<String,Object>();
        map.put("mid",9);
        map.put("mname","jj");
        map.put("mpwd","129");
        mapper.addUser2(map);
        //提交事务
        sqlSession.commit();
        sqlSession.close();
    }
        @Test
    public void updateUser(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
       mapper.updateUser(new User(6,null,"128"));

        //提交事务
        sqlSession.commit();
        sqlSession.close();
    }
    @Test
    public void deleteUser(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.deleteUser(6);
        sqlSession.commit();
        sqlSession.close();
    }
    @Test
    public void getUserLike(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = mapper.getUserLike("j");
        for (User user:userList){
            System.out.println(user);
        }
        sqlSession.commit();
        sqlSession.close();
    }

}