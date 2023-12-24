package com.example.demo_login_codevn4.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.example.demo_login_codevn4.model.entity.User;
import com.example.demo_login_codevn4.model.service.UserService;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping(value = "/login")
public class UserController {
    @Autowired
    UserService userService = new UserService();

    @GetMapping(value = { "/", "" })
    public String showLogin(Model model) {
        model.addAttribute("user", new User());
        return "login";
    }

    // @PostMapping(value = "/action")
    // public String toLogin(@ModelAttribute("user") User user, HttpSession session)
    // {
    // if (userService.doLogin(user) != null) {
    // session.setAttribute("hello_user", user);
    // return "redirect:/";
    // }
    // return showLogin(null);

    // }

    @PostMapping(value = "/action")
    public String toLogin(@ModelAttribute("user") User user, HttpServletResponse response, HttpServletRequest request) {
        User loginUser = userService.doLogin(user);
        if (loginUser != null) {
            Cookie cookie = new Cookie("testUser", loginUser.getId()+"");
            cookie.setMaxAge(20);
            cookie.setPath("/");
            response.addCookie(cookie);
            return "redirect:/";
        }
        return "redirect:/login";
    }
}
