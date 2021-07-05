import com.xu.demo3.MybeanFactory;
import com.xu.demo3.UserServiceImpl;
import org.junit.jupiter.api.Test;


public class Testcjlib {
    @Test
    public void demo1() {
        UserServiceImpl userService = MybeanFactory.createService();
        userService.addUser();
        userService.updateUser();
        userService.deleteUser();
    }
}
