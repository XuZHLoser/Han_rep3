
import com.xu.demo7.Person;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class TestSetter {
    @Test
    public void demo1() throws Exception {
        //spring3不兼容java8及以上版本
        String xmlPath = "com/xu/demo7/beans.xml";
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
        Person person = applicationContext.getBean("personId", Person.class);
        System.out.println(person);
    }
}
