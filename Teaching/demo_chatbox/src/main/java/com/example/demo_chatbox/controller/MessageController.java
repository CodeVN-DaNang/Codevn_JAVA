package com.example.demo_chatbox.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo_chatbox.model.entity.BoxMessage;
import com.example.demo_chatbox.model.entity.Message;
import com.example.demo_chatbox.model.entity.User;
import com.example.demo_chatbox.model.service.MessageService;
import com.example.demo_chatbox.model.service.UserService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.websocket.OnMessage;

@Controller
@RequestMapping(value = "/")
public class MessageController {
    @Autowired
    MessageService messageService = new MessageService();
    UserService userService = new UserService();

    @GetMapping(value = {"", "/"})
    public String showHome(Model model, HttpServletRequest request, HttpServletResponse response){
        User user = userService.checkCookies(request, response);
        if (user != null) {
            model.addAttribute("user", user);
            ArrayList<BoxMessage> boxMessageList = messageService.getAllBoxMessages(user);
            ArrayList<Message> messageList = new ArrayList<>();
            model.addAttribute("boxMessageList", boxMessageList);
            model.addAttribute("messageList", messageList);
            return "home";
        }
        return "redirect:/login";
    }

    @GetMapping(value = "/{idBoxMessage}")
    public String showMessage(@PathVariable("idBoxMessage") int idBoxMessage, Model model, HttpServletRequest request, HttpServletResponse response){
        User user = userService.checkCookies(request, response);
        if (user != null) {
            model.addAttribute("user", user);
            ArrayList<BoxMessage> boxMessageList = messageService.getAllBoxMessages(user);
            ArrayList<Message> messageList = messageService.getAllMessages(idBoxMessage);
            for (BoxMessage boxMessage : boxMessageList) {
                if (boxMessage.getIdBox() == idBoxMessage) {
                    model.addAttribute("idBox", idBoxMessage);
                }
            }
            model.addAttribute("boxMessageList", boxMessageList);
            model.addAttribute("messageList", messageList);
            return "home";
        }
        return "redirect:/login";
    }

    
    @PostMapping(value = "/{idBoxMessage}/send")
    public String doSendMessage(@PathVariable("idBoxMessage") int idBoxMessage, @RequestParam(name = "message") String content, HttpServletRequest request, HttpServletResponse response){
        User user = userService.checkCookies(request, response);
        if (user != null) {
            Message message = new Message(0, content, false, user);
            messageService.sendMessage(message, idBoxMessage);
        }
        return "redirect:/" + idBoxMessage;
    }

    @GetMapping(value = "/logout")
    public String doLogout(HttpServletRequest request, HttpServletResponse response){
        userService.doLogout(request, response);
        return "redirect:/login";
    }

}
