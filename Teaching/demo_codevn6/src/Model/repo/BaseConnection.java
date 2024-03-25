package Model.repo;

import java.sql.Connection;
import java.sql.DriverManager;

public class BaseConnection {
    static String url = "jdbc:mysql://localhost:3306/demo";
    static String username = "root";
    static String password = "nhat2102";
    static String nameClass = "com.mysql.cj.jdbc.Driver";

    public static Connection getConnection(){
        try {
            Class.forName(nameClass);
            return DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

}
