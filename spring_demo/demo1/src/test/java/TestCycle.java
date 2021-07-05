import com.xu.demo5.UserService;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestCycle {
    @Test
    public void demo1() throws Exception {
        //spring3不兼容java8及以上版本
        String xmlPath = "com/xu/demo5/beans.xml";
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
        UserService userService = applicationContext.getBean("userServiceId", UserService.class);
        userService.addUser();
        applicationContext.getClass().getMethod("close").invoke(applicationContext);

    }
}
