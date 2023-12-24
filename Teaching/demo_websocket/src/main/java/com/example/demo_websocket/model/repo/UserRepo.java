package com.example.demo_websocket.model.repo;

import java.util.ArrayList;

import com.example.demo_websocket.model.entities.User;

public class UserRepo {
    ArrayList<User> userList = new ArrayList<>();

    public UserRepo() {
        this.userList.add(new User(1, "user1", "user1"));
        this.userList.add(new User(2, "user2", "user2"));
        this.userList.add(new User(3, "user3", "user3"));
    }

    public ArrayList<User> getAllUsers(){
        return this.userList;
    }

    public User getUserById(int userId){
        for (User user : userList) {
            if (user.getUserId() == userId) {
                return user;
            }
        }
        return null;
    }

    public void addUser(User user){
        userList.add(user);
    }

}
