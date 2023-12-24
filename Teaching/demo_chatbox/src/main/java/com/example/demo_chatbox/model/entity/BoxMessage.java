package com.example.demo_chatbox.model.entity;

import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class BoxMessage {
    private int idBox;
    private ArrayList<User> listUsers;
    private ArrayList<Message> listMessages;
}
