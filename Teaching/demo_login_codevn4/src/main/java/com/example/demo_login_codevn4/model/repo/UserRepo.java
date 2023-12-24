package com.example.demo_login_codevn4.model.repo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.example.demo_login_codevn4.model.entity.User;

@Repository
public class UserRepo {
    ArrayList<User> userList = new ArrayList<>();

    public ArrayList<User> getAllUsers() {
        try {
            Class.forName(BaseConnection.className);
            Connection connection = DriverManager.getConnection(BaseConnection.url, BaseConnection.username,
                    BaseConnection.password);
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("select * from demo_login.user;");
            while (rs.next()) {
                int id = rs.getInt("id");
                String username = rs.getString("username");
                String password = rs.getString("password");
                User user = new User(id, username, password);
                userList.add(user);
            }
            connection.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return userList;
    }

    public User getUserById(int id) {
        try {
            Class.forName(BaseConnection.className);
            Connection connection = DriverManager.getConnection(BaseConnection.url, BaseConnection.username,
                    BaseConnection.password);
            PreparedStatement ps = connection.prepareStatement("select * from demo_login.user where id = ?;");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            rs.next();
            id = rs.getInt("id");
            String username = rs.getString("username");
            String password = rs.getString("password");
            User user = new User(id, username, password);
            connection.close();
            return user;

        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public User getUserByUsername(String username) {
        try {
            Class.forName(BaseConnection.className);
            Connection connection = DriverManager.getConnection(BaseConnection.url, BaseConnection.username,
                    BaseConnection.password);
            PreparedStatement ps = connection.prepareStatement("select * from demo_login.user where username = ?;");
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            rs.next();
            int id = rs.getInt("id");
            username = rs.getString("username");
            String password = rs.getString("password");
            User user = new User(id, username, password);
            connection.close();
            return user;

        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

}
