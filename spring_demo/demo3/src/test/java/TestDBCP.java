import com.xu.domain.User;
import com.xu.dbcp.UserDao;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class TestDBCP {
    @Test
    public void demo1() {
        User user = new User();
        user.setId(1);
        user.setUsername("xzh");
        user.setPassword("456");
        String xmlPath = "com/xu/dbcp/beans.xml";
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
        UserDao userDao = (UserDao) applicationContext.getBean("userDaoId");
        userDao.update(user);
    }
}
