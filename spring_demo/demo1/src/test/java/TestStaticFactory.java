import com.xu.demo4.UserService;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class TestStaticFactory {
    @Test
    public void demo1() {
        //spring3不兼容java8及以上版本
        String xmlPath = "com/xu/demo4/beans.xml";
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
        UserService userService = applicationContext.getBean("userServiceId", UserService.class);
        userService.addUser();
    }
}
