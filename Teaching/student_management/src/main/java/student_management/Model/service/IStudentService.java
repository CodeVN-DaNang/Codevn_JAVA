package student_management.Model.service;

import java.util.*;

import student_management.Model.Entity.Student;
import student_management.Model.Entity.TypeStudent;

public interface IStudentService {
    ArrayList<Student> findAllStudent();
    Student findStudentById(int idStudent);
    boolean addNewStudent(Student student);
    boolean deleteStudent(int idStudent);
    boolean updateStudent(Student student);
    ArrayList<TypeStudent> findAllTypeStudents();
    TypeStudent findTypeStudentById(int typeStudentId);
}
