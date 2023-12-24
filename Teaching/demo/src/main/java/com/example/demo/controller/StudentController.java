package com.example.demo.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.entity.Student;
import com.example.demo.model.service.StudentService;

@Controller
@RequestMapping("/")
public class StudentController {
    @Autowired
    StudentService studentService = new StudentService();

    @GetMapping("/student")
    public String showList(Model model){
        ArrayList<Student> studentList = studentService.getAllStudents();
        model.addAttribute("studentList", studentList);
        return "index";
    }

    @GetMapping("/add")
    public String showAdd(Model model){
        model.addAttribute("student", new Student());
        return "add";
    }

    @PostMapping("/add/action")
    public String toAdd(@ModelAttribute("student") Student student, Model model){
        studentService.addStudent(student);
        return showAdd(model);
    }

    @GetMapping("/update/{id}")
    public String showDetail(@PathVariable("id") int id, Model model){
        Student student = studentService.getStudentById(id);
        model.addAttribute("student", student);
        return "view";
    }

    @PostMapping("/update/{id}/action")
    public String toEdit(@ModelAttribute("student") Student student, Model model){
        studentService.updateStudent(student);
        return showDetail(student.getId(), model);
    }

    @GetMapping("/delete/{id}")
    public String toDelte(@PathVariable("id") int id, Model model){
        studentService.deleteStudent(id);
        return showList(model);
    }

}
