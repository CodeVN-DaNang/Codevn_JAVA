package model.repository;

import java.sql.Connection;
import java.sql.DriverManager;

public class BaseConnection {
    static String className = "com.mysql.cj.jdbc.Driver";
    static String url = "jdbc:mysql://localhost:3306/codevn5_demo";
    static String username = "root";
    static String password = "nhat2102";


    static Connection getConnection(){
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
