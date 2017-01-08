import Util.SessionFactory;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

/**
 * Created by L T on 2017/1/8.
 */
public class Main {
    SqlSessionFactory sqlSessionFactory;
    public Main(){
        sqlSessionFactory = SessionFactory.getInstance();
    }
    public static void main(String[] args) {
        Main m = new Main();
        m.test();
    }

    public void test(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
//        String uuid = UUID.randomUUID().toString();
//        sqlSession.insert("Mapper.StaffMapper.insert",new Staff(uuid,"li","男","M78","CS"));
//        sqlSession.getMapper(StaffMapper.class).insert(new Staff(uuid,"li","男","M78","CS"));
//        sqlSession.commit();
//        sqlSession.close();
//        sqlSession.selectList("Mapper.StaffMapper.selectAllStaff")
//                .stream()
//                .map(i->(Staff)i)
//                .forEach(i->{
//                    System.out.println(i.getId());
//                    System.out.println(i.getName());
//                });
    }
}
