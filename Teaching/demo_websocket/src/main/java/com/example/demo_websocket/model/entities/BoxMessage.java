package com.example.demo_websocket.model.entities;

import java.util.ArrayList;

public class BoxMessage {
    private int boxMessageId;
    private ArrayList<User> userList;
    private ArrayList<Message> messageList;

    public BoxMessage() {
    }

    public BoxMessage(int boxMessageId, ArrayList<User> userList, ArrayList<Message> messageList) {
        this.boxMessageId = boxMessageId;
        this.userList = userList;
        this.messageList = messageList;
    }

    public int getBoxMessageId() {
        return boxMessageId;
    }

    public void setBoxMessageId(int boxMessageId) {
        this.boxMessageId = boxMessageId;
    }

    public ArrayList<User> getUserList() {
        return userList;
    }

    public void setUserList(ArrayList<User> userList) {
        this.userList = userList;
    }

    public ArrayList<Message> getMessageList() {
        return messageList;
    }

    public void setMessageList(ArrayList<Message> messageList) {
        this.messageList = messageList;
    }

    @Override
    public String toString() {
        return "BoxMessage [boxMessageId=" + boxMessageId + ", userList=" + userList + ", messageList=" + messageList
                + "]";
    }

}
