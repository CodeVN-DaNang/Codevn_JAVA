package main.model.service.StudentService;

import java.util.ArrayList;

import main.model.entity.Student;

public interface IStudentService {
    public ArrayList<Student> findAllStudents();
    public Student findStudentById(int idStudent);
    public boolean addNewStudent(Student student);
    public boolean deleteStudent(int idStudent);
    public boolean updateStudent(Student student);
}
