import com.pn.dao.TeacherMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;

import com.pn.entity.Teacher;
import com.pn.utils.MybatisUtils;

import java.util.List;

public class Mytest {
    @Test
    public void test(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
       TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
        List<Teacher> teacherList = mapper.getTeacher();
        for (Teacher teacher : teacherList) {
            System.out.println(teacher);
        }
        sqlSession.close();
    }
    @Test
    public void getTeacher2(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
        Teacher teacher = mapper.getTeacher2(1);

            System.out.println(teacher);

        sqlSession.close();
    }
    @Test
    public void getTeacher3(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
        Teacher teacher = mapper.getTeacher2(1);

        System.out.println(teacher);

        sqlSession.close();
    }
}
