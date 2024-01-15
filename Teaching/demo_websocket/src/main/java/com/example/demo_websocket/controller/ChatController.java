package com.example.demo_websocket.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import com.example.demo_websocket.model.entities.ChatMessage;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class ChatController {

    @MessageMapping("/chat")
    @SendTo("/topic/messages")
    public ChatMessage send(ChatMessage message) throws Exception {
        String time = new SimpleDateFormat("HH:mm").format(new Date());
        return new ChatMessage(message.getFrom(), message.getText(), time);
    }
}

