package com.example.demologinsessioncookies.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demologinsessioncookies.model.entity.User;
import com.example.demologinsessioncookies.model.service.UserService;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/")
public class TestController {
    @Autowired
    UserService userService = new UserService();

    @GetMapping(value = { "/", "" })
    public String showLogin(Model model, HttpSession session, HttpServletRequest request) {
        // check session
        User user = (User) session.getAttribute("user");
        if (user != null) {
            model.addAttribute("user", user);
            return "redirect:/home";
        }
        // check cookies
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if ("user".equals(cookie.getName())) {
                    String username = cookie.getValue();
                    // Xử lý logic với username
                    user = userService.getUserByUsername(username);
                    model.addAttribute("user", user);
                    return "redirect:/home";
                }
            }
        }
        model.addAttribute("user", new User());
        return "login";
    }

    @PostMapping(value = "/login/action")
    public String doLogin(@ModelAttribute("user") User user, HttpSession session, Model model,
            HttpServletResponse response, HttpServletRequest request) {
        user.setId(0);
        User userLogin = userService.doLogin(user);
        //session
        session.setAttribute("user", userLogin);
        // cookies
        Cookie cookie = new Cookie("user", userLogin.getUsername());
        cookie.setMaxAge(30);
        response.addCookie(cookie);
        checkCookies(model, request);
        return showLogin(model, session, request);
    }

    // check cookies
    public void checkCookies(Model model, HttpServletRequest request){
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if ("user".equals(cookie.getName())) {
                    String username = cookie.getValue();
                    // Xử lý logic với username
                    User user = userService.getUserByUsername(username);
                    model.addAttribute("user", user);
                    System.out.println(user.toString());
                }
            }
        }
    }

}
