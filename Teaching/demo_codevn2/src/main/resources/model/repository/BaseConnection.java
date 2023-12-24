package model.repository;

import java.sql.Connection;
import java.sql.DriverManager;


public class BaseConnection {
    private String className = "com.mysql.jdbc.Driver";
    private String url = "jdbc:mysql://localhost:3306/test";
    private String username = "root";
    private String password = "";

    Connection getConnection() {
        Class.forName(className);
        Connection connection = DriverManager.getConnection(url, username, password);
        return connection;
    }
}
