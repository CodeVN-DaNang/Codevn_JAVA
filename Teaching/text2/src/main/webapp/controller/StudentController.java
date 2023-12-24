package com.example.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.method.support.ModelAndViewContainer;

import com.example.model.entity.Student;
import com.example.model.service.StudentService;

public class StudentController{
    StudentService studentService = new StudentService();
    @GetMapping(value = "/test2")
    public String doGet(HttpServletRequest request) {
        ArrayList<Student> students = studentService.findAllStudent();
        request.addAttribute("students", students);
        return "/test2";
    }
}
