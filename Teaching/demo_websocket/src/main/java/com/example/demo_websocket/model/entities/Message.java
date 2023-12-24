package com.example.demo_websocket.model.entities;

public class Message {
    private int messageId;
    private String messageContent;
    private User userSend;

    public Message() {
    }

    public Message(int messageId, String messageContent, User userSend) {
        this.messageId = messageId;
        this.messageContent = messageContent;
        this.userSend = userSend;
    }

    public int getMessageId() {
        return messageId;
    }

    public void setMessageId(int messageId) {
        this.messageId = messageId;
    }

    public String getMessageContent() {
        return messageContent;
    }

    public void setMessageContent(String messageContent) {
        this.messageContent = messageContent;
    }

    public User getUserSend() {
        return userSend;
    }

    public void setUserSend(User userSend) {
        this.userSend = userSend;
    }

    @Override
    public String toString() {
        return "Message [messageId=" + messageId + ", messageContent=" + messageContent + ", userSend=" + userSend
                + "]";
    }

}
