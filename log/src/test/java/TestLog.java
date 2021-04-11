import com.pn.dao.UserMapper;
import com.pn.entity.User;
import com.pn.utils.MybatisUtils;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;


import java.util.HashMap;
import java.util.List;



public class TestLog {
    static Logger logger = Logger.getLogger(TestLog.class);

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
//log4j在要使⽤Log4j 的类中，导⼊包 import org.apache.log4j.Logger;
//2. ⽇志对象，参数为当前类的class
    @Test
    public void testLog4j(){
        logger.info("info:进⼊了testLog4j");
        logger.debug("debug:进⼊了testLog4j");
        logger.error("error:进⼊了testLog4j");
    }

    @Test
    public void getUserByLimit(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
       HashMap<String, Integer> map = new HashMap<String, Integer>();
        map.put("startIndex",1);//和xml命名一样
        map.put("pageSize",3);
        List<User> userList = mapper.getUserByLimit(map);
        for (User user : userList) {
            System.out.println(user);
}
        sqlSession.close();
}

    @Test
    public void getUserByRowBounds(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
//RowBounds实现
        RowBounds rowBounds = new RowBounds(1, 2);
//通过Java代码层⾯实现分⻚
        List<User> userList =
                sqlSession.selectList("com.pn.dao.UserMapper.getUserByRowBounds",null,rowBounds);
        for (User user : userList) {
            System.out.println(user);
        }

        sqlSession.close();
    }


}
