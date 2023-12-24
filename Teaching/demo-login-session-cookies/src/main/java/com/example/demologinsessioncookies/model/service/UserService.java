package com.example.demologinsessioncookies.model.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demologinsessioncookies.model.entity.User;
import com.example.demologinsessioncookies.model.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository = new UserRepository();

    public ArrayList<User> getAllUsers(){
        return userRepository.getAllUsers();
    }

    public User getUserById(int id){
        return userRepository.getUserById(id);
    }

    public User doLogin(User user){
        User userChecked = userRepository.getUserByUsername(user.getUsername());
        if (userChecked != null) {
            if (userChecked.getPassword().equals(user.getPassword())) {
                return userChecked;
            }
        }
        return new User();
    }

    public User getUserByUsername(String username){
        return userRepository.getUserByUsername(username);
    }

}
