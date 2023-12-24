package com.example.demo_login.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo_login.model.entity.User;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping(value = "/home")
public class HelloController {

    @GetMapping(value = { "/", "" })
    public String showHello(Model model, HttpSession httpSession) {
        User user = (User) httpSession.getAttribute("activeUser");
        model.addAttribute("user", user);
        return "hello";
    }

    @GetMapping(value = "/logout")
    public String toLogout(Model model, HttpSession httpSession) {
        httpSession.setAttribute("activeUser", new User());
        model.addAttribute("user", httpSession.getAttribute("activeUser"));
        return "redirect:/";
    }

}
