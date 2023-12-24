package model.service;

import java.util.ArrayList;

import model.entity.Student;
import model.repository.StudentRepository;

public class StudentService {
    StudentRepository studentRepository = new StudentRepository();

    public ArrayList<Student> getAllStudents() {
        return studentRepository.getAllStudent();
    }

    public ArrayList<Student> findStudentByName(String name) {
        ArrayList<Student> students = studentRepository.getAllStudent();
        ArrayList<Student> findStudents = new ArrayList<>();
        for (Student student : students) {
            if (student.getName().contains(name)) {
                findStudents.add(student);
            }
        }
        return findStudents;
    }

    public void addStudent(Student student) {
        studentRepository.addStudent(student);
    }

    public void deleteStudentByIndex(int index) {
        studentRepository.deleteStudent(index);
    }

    public void editStudent(int index, Student student) {
        studentRepository.editStudent(index, student);
    }

}
