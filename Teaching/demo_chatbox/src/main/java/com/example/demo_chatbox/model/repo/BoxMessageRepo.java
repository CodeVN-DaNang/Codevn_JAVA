package com.example.demo_chatbox.model.repo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo_chatbox.model.entity.BoxMessage;
import com.example.demo_chatbox.model.entity.Message;
import com.example.demo_chatbox.model.entity.User;

@Repository
public class BoxMessageRepo {
    @Autowired
    UserRepo userRepo = new UserRepo();
    MessageRepo messageRepo = new MessageRepo();

    public ArrayList<User> getAllUsersOfBoxMessage(int idBoxMessage) {
        ArrayList<User> userList = new ArrayList<>();
        try {
            Class.forName(BaseConnection.className);
            Connection conn = DriverManager.getConnection(BaseConnection.url, BaseConnection.username,
                    BaseConnection.password);
            PreparedStatement ps = conn.prepareStatement(
                    "select *, user.* from detailmessage join boxmessage join user where detailmessage.id_box_message = boxmessage.idboxmessage and boxmessage.idboxmessage = ?  and detailmessage.userId = user.id;");
            ps.setInt(1, idBoxMessage);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String username = rs.getString("username");
                String password = rs.getString("password");
                User user = new User(id, username, password);
                userList.add(user);
            }
            ps.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return userList;
    }

    public ArrayList<Message> getAllMessagesOfBoxMessages(int idBoxMessage) {
        return messageRepo.getAllMessages(idBoxMessage);
    }

    public ArrayList<BoxMessage> getAllBoxMessages(User user) {
        ArrayList<BoxMessage> boxMessageList = new ArrayList<>();
        try {
            Class.forName(BaseConnection.className);
            Connection conn = DriverManager.getConnection(BaseConnection.url, BaseConnection.username,
                    BaseConnection.password);
            PreparedStatement ps = conn.prepareStatement(
                    "select detailmessage.*, boxmessage.*, user.id from detailmessage join boxmessage join user where detailmessage.id_box_message = boxmessage.idboxmessage and detailmessage.userId = user.id and detailmessage.userId = ?;");
            ps.setInt(1, user.getId());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int idBoxMessage = rs.getInt("id_box_message");
                ArrayList<User> users = getAllUsersOfBoxMessage(idBoxMessage);
                ArrayList<Message> messages = getAllMessagesOfBoxMessages(idBoxMessage);
                BoxMessage boxMessage = new BoxMessage(idBoxMessage, users, messages);
                boxMessageList.add(boxMessage);
            }
            conn.close();
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e);
        }
        return boxMessageList;
    }

    public void addNewBoxMessage(BoxMessage boxMessage) {
        try {
            Class.forName(BaseConnection.className);
            Connection conn = DriverManager.getConnection(BaseConnection.url, BaseConnection.username,
                    BaseConnection.password);
            PreparedStatement ps = conn.prepareStatement("insert into BoxMessage(idBoxMessage) values ?;");
            ps.setInt(1, boxMessage.getIdBox());
            ps.executeUpdate();
            for (User user : boxMessage.getListUsers()) {
                PreparedStatement ps2 = conn.prepareStatement("insert into detailmessage(userId, id_box_message) values (?,?);");
                ps2.setInt(1, user.getId());
                ps2.setInt(2, boxMessage.getIdBox());
                ps2.executeUpdate();
            }
            conn.close();
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e);
        }
    }

}
