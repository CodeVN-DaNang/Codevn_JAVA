package com.example.demo.model.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.entity.Student;
import com.example.demo.model.repo.StudentRepo;

@Service
public class StudentService {
    @Autowired
    StudentRepo studentRepo = new StudentRepo();

    public ArrayList<Student> getAllStudents(){
        return studentRepo.getAllStudent();
    }

    public Student getStudentById(int id){
        return studentRepo.getStudentById(id);
    }

    public void addStudent(Student student){
        studentRepo.createPeople(student);
    }

    public void updateStudent(Student student){
        studentRepo.updatePeople(student);
    }

    public void deleteStudent(int id){
        studentRepo.deletePeople(id);    
    }
}
