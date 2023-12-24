package com.example.model.service;

import java.util.ArrayList;

import com.example.model.entity.Student;
import com.example.model.repository.StudentRepository;

public class StudentService implements IStudentService{

    StudentRepository studentRepository = new StudentRepository();
    private ArrayList<Student> students = studentRepository.findAllStudent();

    @Override
    public ArrayList<Student> findAllStudent() {
        // TODO Auto-generated method stub
        if (!students.isEmpty()) {
            return students;
        }
        throw new UnsupportedOperationException("Unimplemented method 'findAllSStudent'");
    }

    @Override
    public Student findStudentById(int idStudent) {
        // TODO Auto-generated method stub
        for (Student student : students) {
            if (student.getIdStudent() == idStudent) {
                return studentRepository.findStudentById(idStudent);
            }
        }
        throw new UnsupportedOperationException("Unimplemented method 'findStudentById'");
    }

    @Override
    public boolean addNewStudent(Student student) {
        // TODO Auto-generated method stub
        int recordChange = studentRepository.addNewStudent(student);
        if (recordChange > 0) {
            return true;
        } 
        throw new UnsupportedOperationException("Unimplemented method 'addNewStudent'");
    }

    @Override
    public boolean deleteStudent(int idStudent) {
        // TODO Auto-generated method stub
        int recordChange = studentRepository.deleteStudent(idStudent);
        if (recordChange > 0) {
            return true;
        } 
        throw new UnsupportedOperationException("Unimplemented method 'deleteStudent'");
    }

    @Override
    public boolean updateStudent(Student student) {
        // TODO Auto-generated method stub
        int recordChange = studentRepository.updateStudent(student);
        if (recordChange > 0) {
            return true;
        } 
        throw new UnsupportedOperationException("Unimplemented method 'updateStudent'");
    }
    
}
