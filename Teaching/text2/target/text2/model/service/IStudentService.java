package com.example.model.service;

import java.util.ArrayList;

import com.example.model.entity.Student;

public interface IStudentService {
    ArrayList<Student> findAllStudent();
    Student findStudentById(int idStudent);
    boolean addNewStudent(Student student);
    boolean deleteStudent(int idStudent);
    boolean updateStudent(Student student);

}
