package com.example.demo_login_codevn4.model.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo_login_codevn4.model.entity.User;
import com.example.demo_login_codevn4.model.repo.UserRepo;

@Service
public class UserService {
    @Autowired
    UserRepo userRepository = new UserRepo();

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
