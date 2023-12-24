package com.example.demo_chatbox.model.repo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo_chatbox.model.entity.Message;
import com.example.demo_chatbox.model.entity.User;

@Repository
public class MessageRepo {
    @Autowired
    UserRepo userRepo = new UserRepo();

    public ArrayList<Message> getAllMessages(int boxMessageId){
        ArrayList<Message> messageList = new ArrayList<>();
        try {
            Class.forName(BaseConnection.className);
            Connection conn = DriverManager.getConnection(BaseConnection.url, BaseConnection.username, BaseConnection.password);
            PreparedStatement ps = conn.prepareStatement("select * from message where id_box_message = ?;");
            ps.setInt(1, boxMessageId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int idMessage = rs.getInt("idMessage");
                String content = rs.getString("content");
                boolean status = rs.getBoolean("status");
                User userSend = userRepo.getUserById(rs.getInt("userSendId"));
                Message message = new Message(idMessage, content, status, userSend);
                messageList.add(message);
            }
            ps.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return messageList;
    }

    public void addNewMessage(Message message, int id_box_message){
        try {
            Class.forName(BaseConnection.className);
            Connection conn = DriverManager.getConnection(BaseConnection.url, BaseConnection.username, BaseConnection.password);
            PreparedStatement ps = conn.prepareStatement("insert into message(content, status, userSendId , id_box_message) values (?, ?, ?, ?) ");
            ps.setString(1, message.getContent());
            ps.setBoolean(2, message.isStatus());
            ps.setInt(3, message.getUserSend().getId());
            ps.setInt(4, id_box_message);
            ps.executeUpdate();
            conn.close();
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e);
        }
    }

}
