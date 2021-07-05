import com.xu.c3p0.UserDao;
import com.xu.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestC3P0 {
    @Test
    public void demo1() {
        User user = new User();
        user.setId(1);
        user.setUsername("xz");
        user.setPassword("456");
        String xmlPath = "com/xu/c3p0/beans.xml";
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
        UserDao userDao = (UserDao) applicationContext.getBean("userDaoId");
        userDao.update(user);
    }
}
