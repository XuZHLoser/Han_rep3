import com.xu.demo1.MybeanFactory;
import com.xu.demo1.UserService;
import org.junit.jupiter.api.Test;

public class TestJDK {
    @Test
    public void demo1() {
        UserService userService = MybeanFactory.createService();
        userService.addUser();
        userService.updateUser();
        userService.deleteUser();
    }
}
