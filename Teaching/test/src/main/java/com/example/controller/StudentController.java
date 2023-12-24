package com.example.controller;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.method.support.ModelAndViewContainer;

import com.example.model.entity.Student;
import com.example.model.service.StudentService;

public class StudentController{
    StudentService studentService = new StudentService();
    @GetMapping(value = "/index")
    public ModelAndViewContainer doGet() {
        ArrayList<Student> students = studentService.findAllStudent();
        ModelAndViewContainer mContainer = new ModelAndViewContainer();
        mContainer.addAttribute("students", students);
        return mContainer;
    }
}
