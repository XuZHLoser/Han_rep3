import com.xu.demo1.UserService;
import com.xu.demo1.UserServiceImpl;
import com.xu.demo2.BookService;
import com.xu.demo8.*;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestIoC {
    @Test
    public void demo1() {
        UserService userService = new UserServiceImpl();
        userService.addUser();
    }
    @Test
    public void demo2() {
        String xmlPath = "com/xu/demo1/beans.xml";
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
        UserService userService = (UserService) applicationContext.getBean("userServiceId");
        userService.addUser();
    }
    @Test
    public void demo3() {
        String xmlPath = "com/xu/demo2/beans.xml";
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
        BookService bookService = (BookService) applicationContext.getBean("bookServiceId");
        bookService.addBook();
    }


}
