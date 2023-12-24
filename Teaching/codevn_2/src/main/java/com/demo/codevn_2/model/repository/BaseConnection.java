package com.demo.codevn_2.model.repository;

import java.sql.Connection;
import java.sql.DriverManager;

public class BaseConnection {
    static String url = "jdbc:mysql://localhost:3306/product_management_test";
    static String username = "root";
    static String password = "nhat2102";
    static String nameClass = "com.mysql.cj.jdbc.Driver";

    static Connection getConnection() throws Exception{
        Class.forName(nameClass);
        Connection conn = DriverManager.getConnection(url, username, password);
        return conn;
    }

}
