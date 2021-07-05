import java.sql.*;

public class MysqlTest {
    public static void main(String[] args) throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("找不到驱动类！");
            e.printStackTrace();
        }

        String url = "jdbc:mysql://localhost:3306/demo1?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";
        String userName = "root";
        String password = "abcd";

        try (Connection connection = DriverManager.getConnection(url, userName, password)) {
            System.out.println("数据库链接成功！");


        }
    }
}
