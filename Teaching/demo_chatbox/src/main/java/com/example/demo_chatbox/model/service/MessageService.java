package com.example.demo_chatbox.model.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo_chatbox.model.entity.BoxMessage;
import com.example.demo_chatbox.model.entity.Message;
import com.example.demo_chatbox.model.entity.User;
import com.example.demo_chatbox.model.repo.BoxMessageRepo;
import com.example.demo_chatbox.model.repo.MessageRepo;

@Service
public class MessageService {
    @Autowired
    BoxMessageRepo boxMessageRepo = new BoxMessageRepo();
    MessageRepo messageRepo = new MessageRepo();

    public ArrayList<Message> getAllMessages(int idBoxMessage){
        return messageRepo.getAllMessages(idBoxMessage);
    }

    public ArrayList<BoxMessage> getAllBoxMessages(User user){
        return boxMessageRepo.getAllBoxMessages(user);
    }

    public void addNewBoxMessage(ArrayList<User> userList, Message firstMessage){
        ArrayList<Message> messageList = new ArrayList<>();
        messageList.add(firstMessage);
        BoxMessage boxMessage = new BoxMessage(0, userList, messageList);
        boxMessageRepo.addNewBoxMessage(boxMessage);
    }

    public void sendMessage(Message message, int idBoxMessage){
        messageRepo.addNewMessage(message, idBoxMessage);
    }

}
