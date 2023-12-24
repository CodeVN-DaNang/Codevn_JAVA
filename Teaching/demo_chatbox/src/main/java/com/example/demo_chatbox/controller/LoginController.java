package com.example.demo_chatbox.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo_chatbox.model.entity.User;
import com.example.demo_chatbox.model.service.UserService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
@RequestMapping(value = "/login")
public class LoginController {
    @Autowired
    UserService userService = new UserService();

    @GetMapping(value = {"", "/"})
    public String showLogin(Model model){
        model.addAttribute("user", new User());
        return "login";
    }

    @PostMapping(value = "/action")
    public String doLogin(@ModelAttribute("user") User user, HttpServletRequest request, HttpServletResponse response){
        if (userService.doLogin(user, request, response)) {
            return "redirect:/";
        }
        return "redirect:/login";

    }

}
