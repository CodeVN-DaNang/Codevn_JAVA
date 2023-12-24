package model.repository;

import java.util.ArrayList;

import model.entity.Student;

public class StudentRepository {
    ArrayList<Student> students = new ArrayList<>();
    
    public ArrayList<Student> getAllStudent() {
        return this.students;
    }

    public Student getStudentByIndex(int index) {
        return this.students.get(index);
    }

    public void addStudent(Student student) {
        this.students.add(student);
    }

    public void deleteStudent(int index) {
        this.students.remove(index);
    }

    public void editStudent(int index, Student student) {
        this.students.remove(index);
        this.students.add(index,student);
    }

}
