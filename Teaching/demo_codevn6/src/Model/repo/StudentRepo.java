package Model.repo;

import java.sql.*;
import java.util.ArrayList;

import Model.entities.Student;
import Model.entities.TypeStudent;

public class StudentRepo {

    TypeStudentRepo typeStudentRepo = new TypeStudentRepo();

    public static void main(String[] args) {
        StudentRepo studentRepo = new StudentRepo();
        System.out.println(studentRepo.getAllStudents().toString());
    }

    public ArrayList<Student> getAllStudents() {
        ArrayList<Student> studentList = new ArrayList<>();
        
        try {
            Connection conn = BaseConnection.getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from student");
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int age = rs.getInt("age");
                String phone = rs.getString("phone");
                int idTypeStudent = rs.getInt("idTypeStudent");
                TypeStudent typeStudent = typeStudentRepo.getTypeStudentById(idTypeStudent);
                Student student = new Student(id, name, age, phone, typeStudent);
                studentList.add(student);
            }
            st.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return studentList;
    }

    public Student getStudentById(int id) {
        try {
            Connection conn = BaseConnection.getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from student where id = " + id);
            rs.next();
            id = rs.getInt("id");
            String name = rs.getString("name");
            int age = rs.getInt("age");
            String phone = rs.getString("phone");
            Student student = new Student(id, name, age, phone);
            return student;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public void addStudent() {
        // executeUpdate();
    }

    public void updateStudent() {
        // executeUpdate();
    }

    public void deleteStudent() {
        // executeUpdate();
    }

}
