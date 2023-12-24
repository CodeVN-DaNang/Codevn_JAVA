package com.example.demo_login.model.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo_login.model.entity.User;
import com.example.demo_login.model.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository = new UserRepository();

    public ArrayList<User> getAllUsers() {
        return userRepository.getAllUsers();
    }

    public User getUserById(int id) {
        return userRepository.getUserById(id);
    }

    public User getUserByUsername(String username){
        return userRepository.getUserByUsername(username);
    }

    public boolean toLogin(User user) {
        try {
            User userCheck = userRepository.getUserByUsername(user.getUsername());
            if (userCheck.getPassword().equals(user.getPassword())) {
                return true;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }

}
