package com.example.demologinsessioncookies.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demologinsessioncookies.model.entity.User;
import com.example.demologinsessioncookies.model.service.UserService;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping(value = "/home")
public class HelloController {
    @Autowired
    UserService userService = new UserService();

    @GetMapping(value = { "/", "" })
    public String showHome(Model model, HttpSession session, HttpServletRequest request) {
        User user = (User) session.getAttribute("user");
        if (user == null) {
            Cookie[] cookies = request.getCookies();
            if (cookies != null) {
                for (Cookie cookie : cookies) {
                    if ("user".equals(cookie.getName())) {
                        String username = cookie.getValue();
                        // Xử lý logic với username
                        user = userService.getUserByUsername(username);
                        model.addAttribute("user", user);
                        return "home";
                    }
                }
            }
        }
        model.addAttribute("user", user);
        return "home";
    }
}
