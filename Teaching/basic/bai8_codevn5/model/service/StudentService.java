package model.service;

import java.util.ArrayList;

import model.entity.Student;
import model.repository.StudentRepo;

public class StudentService {
    StudentRepo studentRepo = new StudentRepo();

     public ArrayList<Student> getAllStudents(){
        return studentRepo.getAllStudents();
    }

    public Student getStudentById(int index){
        return studentRepo.getStudentById(index);
    }

    public void addNewStudent(Student student){
        studentRepo.addNewStudent(student);
    }

    public void deleteStudent(int index){
        studentRepo.deleteStudent(index);
    }

    public void editStudent(int index, Student student){
        studentRepo.editStudent(index, student);
    }
}
