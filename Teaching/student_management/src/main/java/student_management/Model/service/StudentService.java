package student_management.Model.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import student_management.Model.entities.Student;
import student_management.Model.entities.TypeStudent;
import student_management.Model.repo.StudentRepo;
import student_management.Model.repo.TypeRepo;

public class StudentService {
    StudentRepo studentRepo = new StudentRepo();

    TypeRepo typeRepo = new TypeRepo();

    public ArrayList<Student> getAllStudents(){
        System.out.println("hello");
        return studentRepo.getAllStudents();
    }

    public ArrayList<TypeStudent> getAllTypeStudents(){
        return typeRepo.getAllTypeStudents();
    }

    public Student getStudentById(int studentId){
        return studentRepo.getStudentById(studentId);
    }

    public TypeStudent getTypeStudentById(int typeId){
        return typeRepo.getTypeStudentById(typeId);
    }

    public void addStudent(Student student){
        studentRepo.addStudent(student);
    }

    public void deleteStudent(int studentId){
        studentRepo.deleteStudent(studentId);
    }

    public void updateStudent(Student student){
        studentRepo.updateStudent(student);
    }

}
