package com.example.demo_chatbox.model.repo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.example.demo_chatbox.model.entity.User;

@Repository
public class UserRepo {

    public ArrayList<User> getAllUsers() {
        ArrayList<User> userList = new ArrayList<>();
        try {
            Class.forName(BaseConnection.className);
            Connection conn = DriverManager.getConnection(BaseConnection.url, BaseConnection.username,
                    BaseConnection.password);
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from user");
            while (rs.next()) {
                int id = rs.getInt("id");
                String username = rs.getString("username");
                String password = rs.getString("password");
                User user = new User(id, username, password);
                userList.add(user);
            }
            st.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return userList;
    }

    public User getUserById(int id) {
        try {
            Class.forName(BaseConnection.className);
            Connection conn = DriverManager.getConnection(BaseConnection.url, BaseConnection.username,
                    BaseConnection.password);
            PreparedStatement ps = conn.prepareStatement("select * from user where id = ?;");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            rs.next();
            id = rs.getInt("id");
            String username = rs.getString("username");
            String password = rs.getString("password");
            User user = new User(id, username, password);
            ps.close();
            return user;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

}
