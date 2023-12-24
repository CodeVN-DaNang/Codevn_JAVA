package com.example.demo_login.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo_login.model.entity.User;
import com.example.demo_login.model.service.UserService;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/")
public class LoginController {
    @Autowired
    UserService userService = new UserService();

    // login with session
    // @GetMapping(value = {"", "/"})
    // public String showLogin(Model model, HttpSession httpSession){
    // User user = (User) httpSession.getAttribute("activeUser");
    // if (user == null) {
    // model.addAttribute("user", new User());
    // return "login";
    // }
    // model.addAttribute("user", user);
    // return "hello";
    // }

    // @PostMapping(value = "/login")
    // public String toLogin(@ModelAttribute("user") User user, Model model,
    // HttpSession httpSession){
    // user.setId(0);
    // boolean flag = userService.toLogin(user);
    // if (flag) {
    // httpSession.setAttribute("activeUser",user);
    // return "hello";
    // } else {
    // return showLogin(model, httpSession);
    // }
    // }

    // login with cookie
    @GetMapping(value = { "", "/" })
    public String showLogin(Model model, HttpServletRequest request) {
        User user = new User();
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if ("userCookie".equals(cookie.getName())) {
                    String userStr = cookie.getValue();
                    // Xử lý logic với username
                    user = new User(0, userStr, userStr);
                    model.addAttribute("user", user);
                    return "hello";
                }
            }
        }
        model.addAttribute("user", user);
        return "login";
    }

    @PostMapping(value = "/login")
    public String toLogin(@ModelAttribute("user") User user, Model model, HttpServletResponse response,
            HttpServletRequest request) {
        user.setId(0);
        boolean flag = userService.toLogin(user);
        if (flag) {
            Cookie cookie = new Cookie("userCookie", user.getUsername());
            cookie.setMaxAge(30);
            response.addCookie(cookie);
            return "hello";
        } else {
            return showLogin(model, request);
        }
    }
}
