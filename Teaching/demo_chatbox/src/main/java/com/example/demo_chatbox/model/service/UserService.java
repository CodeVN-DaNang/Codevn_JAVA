package com.example.demo_chatbox.model.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo_chatbox.model.entity.User;
import com.example.demo_chatbox.model.repo.UserRepo;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Service
public class UserService {
    @Autowired
    UserRepo userRepo = new UserRepo();

    public boolean doLogout(HttpServletRequest request, HttpServletResponse response) {
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("demo_chat_user")) {
                cookie.setMaxAge(0);
                response.addCookie(cookie);
                return true;
            }
        }
        return false;
    }

    public User checkCookies(HttpServletRequest request, HttpServletResponse response) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("demo_chat_user")) {
                    return getUserById(Integer.parseInt(cookie.getValue()));
                }
            }
        }
        return null;
    }

    public boolean doLogin(User user, HttpServletRequest request, HttpServletResponse response) {
        User newUser = checkLogin(user);
        if (newUser != null) {
            Cookie cookie = new Cookie("demo_chat_user", newUser.getId() + "");
            cookie.setMaxAge(2 * 60 * 60);
            cookie.setPath("/");
            response.addCookie(cookie);
            return true;
        }
        return false;
    }

    public User checkLogin(User user) {
        for (User checkUser : getAllUsers()) {
            if (user.getUsername().equals(checkUser.getUsername())) {
                if (user.getPassword().equals(checkUser.getPassword())) {
                    return checkUser;
                }
            }
        }
        return null;
    }

    public ArrayList<User> getAllUsers() {
        return userRepo.getAllUsers();
    }

    public User getUserById(int id) {
        return userRepo.getUserById(id);
    }

}
