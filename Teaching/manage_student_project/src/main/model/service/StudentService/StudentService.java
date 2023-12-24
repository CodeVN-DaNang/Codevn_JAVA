package main.model.service.StudentService;

import java.util.ArrayList;

import main.model.entity.Student;
import main.model.repository.StudentRepository;

public class StudentService implements IStudentService {
    StudentRepository studentRepository = new StudentRepository();

    @Override
    public ArrayList<Student> findAllStudents() {
        // TODO Auto-generated method stub
        return studentRepository.findAllStudents();
    }

    @Override
    public Student findStudentById(int idStudent) {
        // TODO Auto-generated method stub
        return studentRepository.findStudentById(idStudent);
    }

    @Override
    public boolean addNewStudent(Student student) {
        // TODO Auto-generated method stub
        if (studentRepository.creatStudent(student) > 0) {
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteStudent(int idStudent) {
        // TODO Auto-generated method stub
        if (studentRepository.deleteStudent(idStudent) > 0) {
            return true;
        }
        return false;
    }

    @Override
    public boolean updateStudent(Student student) {
        // TODO Auto-generated method stub
        if (studentRepository.updateStudent(student) > 0) {
            return true;
        }
        return false;
    }
    
}
