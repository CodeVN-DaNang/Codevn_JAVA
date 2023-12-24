package com.example.demo_websocket.model.repo;

import java.util.ArrayList;

import com.example.demo_websocket.model.entities.BoxMessage;
import com.example.demo_websocket.model.entities.User;

public class BoxMessageRepo {
    ArrayList<BoxMessage> boxMessageList = new ArrayList<>();

    public BoxMessageRepo() {
        boxMessageList.add(new BoxMessage(1, null, null));
    }
    public ArrayList<BoxMessage> getBoxMessageList(User user) {
        ArrayList<BoxMessage> boxMessages = new ArrayList<>();
        for (BoxMessage boxMessage : boxMessageList) {
            if (boxMessage.getUserList().contains(user)) {
                boxMessages.add(boxMessage);
            }
        }
        return boxMessages;
    }

    public BoxMessage getBoxMessageById(User user, int id){
        for (BoxMessage boxMessage : boxMessageList) {
            if (boxMessage.getUserList().contains(user) && boxMessage.getBoxMessageId() == id) {
                return boxMessage;
            }
        }
        return null;
    }

}
