package student_management.Model.repo;

import java.sql.Connection;
import java.sql.DriverManager;

public class BaseConnection {
    String className = "com.mysql.cj.jdbc.Driver";
    String url = "jdbc:mysql://localhost:3306/student_management_test";
    String username = "root";
    String password = "nhat2102";

    public Connection getConnection(){
        try {
            Class.forName(className);
            Connection conn = DriverManager.getConnection(url, username, password);
            return conn;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

}
