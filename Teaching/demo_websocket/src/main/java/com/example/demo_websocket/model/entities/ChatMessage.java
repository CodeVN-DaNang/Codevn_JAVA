package com.example.demo_websocket.model.entities;

public class ChatMessage {
    private String from;
    private String text;
    private String time;

    public ChatMessage() {
    }

    public ChatMessage(String from, String text, String time) {
        this.from = from;
        this.text = text;
        this.time = time;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "ChatMessage [from=" + from + ", text=" + text + ", time=" + time + "]";
    }

}
