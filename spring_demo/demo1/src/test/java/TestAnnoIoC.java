import com.xu.demo9.*;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAnnoIoC {
//    @Test
//    public void demo1() {
//        String xmlPath = "com/xu/demo8/beans.xml";
//        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
//        UserService userService = (UserService) applicationContext.getBean("userServiceId");
//        userService.addUser();
//    }
    @Test
    public void demo2() {
        String xmlPath = "com/xu/demo9/beans.xml";
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
        StudentAction studentAction = (StudentAction) applicationContext.getBean("studentActionId");
        studentAction.execute();
    }
}
