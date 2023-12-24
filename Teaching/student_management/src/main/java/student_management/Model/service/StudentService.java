package student_management.Model.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import student_management.Model.Entity.Student;
import student_management.Model.Entity.TypeStudent;
import student_management.Model.repository.StudentRepository;
import student_management.Model.repository.TypeStudentRepository;

@Service
public class StudentService implements IStudentService {

    @Autowired
    StudentRepository studentRepository = new StudentRepository();
    TypeStudentRepository typeStudentRepository = new TypeStudentRepository();
    private ArrayList<Student> students = new ArrayList<>();

    @Override
    public ArrayList<Student> findAllStudent() {
        // TODO Auto-generated method stub
        this.students = studentRepository.findAllStudent();
        if (!students.isEmpty()) {
            return students;
        }
        // return students;
        throw new UnsupportedOperationException("Unimplemented method 'findAllSStudent'");
    }

    @Override
    public Student findStudentById(int idStudent) {
        // TODO Auto-generated method stub
        findAllStudent();
        for (Student student : students) {
            if (student.getIdStudent().equals(idStudent+"")) {
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

    @Override
    public ArrayList<TypeStudent> findAllTypeStudents() {
        // TODO Auto-generated method stub
        ArrayList<TypeStudent> typeStudentList = typeStudentRepository.findAllTypeStudents();
        if (!typeStudentList.isEmpty()) {
            return typeStudentList;
        }
        throw new UnsupportedOperationException("Unimplemented method 'findAllTypeStudents'");
    }

    @Override
    public TypeStudent findTypeStudentById(int typeStudentId) {
        // TODO Auto-generated method stub
        TypeStudent typeStudent = typeStudentRepository.findTypeStudentById(typeStudentId);
        return typeStudent;
    }

    
    
}
