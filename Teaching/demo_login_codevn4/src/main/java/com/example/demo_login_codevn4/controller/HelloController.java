package com.example.demo_login_codevn4.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo_login_codevn4.model.entity.User;
import com.example.demo_login_codevn4.model.service.UserService;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/")
public class HelloController {
    @Autowired
    UserService userService = new UserService();

    
    // public String showHello(Model model, HttpSession session){
    // User user = (User) session.getAttribute("hello_user");
    // if (user != null) {
    // model.addAttribute("user", user);
    // return "home";
    // }
    // return "redirect:/login";
    // }
    @GetMapping(value = { "/", "" })
    public String showHello(Model model, HttpServletRequest request, HttpServletResponse response) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                System.out.println(cookie.getValue());
                if ("testUser".equals(cookie.getName())) {
                    int userId = Integer.parseInt(cookie.getValue());
                    User user = userService.getUserById(userId);
                    model.addAttribute("user", user);
                    return "home";
                }
            }
        }
        return "redirect:/login";
    }

    @GetMapping(value = "/logout")
    public String doLogout(HttpServletRequest request, HttpServletResponse response) throws ServletException{
        Cookie[] cookies = request.getCookies();
        
        if (cookies != null) {
            for (int i = 0; i < cookies.length; i++) {
                if(cookies[i].getName().equals("testUser")){
                    cookies[i].setMaxAge(0);
                    response.addCookie(cookies[i]);
                    System.out.println(cookies[i].getValue());
                    return "redirect:/login";
                }

            }
        }
        return "redirect:/login";
    }
}
