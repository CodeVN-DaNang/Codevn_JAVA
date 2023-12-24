package model.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.entity.Student;

public class StudentRepository {

    public static void main(String[] args) throws Exception {
        StudentRepository studentRepository = new StudentRepository();
        Student student1 = new Student(4, "Duc Anh");
        studentRepository.addStudent(student1);
        for (Student student : studentRepository.getAllStudents()) {
            System.out.println(student.toString());
        }
    }

    // query
    public ArrayList<Student> getAllStudents() throws Exception {
        ArrayList<Student> stdList = new ArrayList<>();
        Class.forName(BaseConnection.nameClass);
        Connection conn = DriverManager.getConnection(BaseConnection.url, BaseConnection.username, BaseConnection.password);
        PreparedStatement pt = conn.prepareStatement("select * from student");
        ResultSet rs = pt.executeQuery();
        while (rs.next()) {
            int id = rs.getInt("id");
            String name = rs.getString("name");
            Student student = new Student(id, name);
            stdList.add(student);
        }
        rs.close();
        conn.close();
        return stdList;
    }

    // update
    public void addStudent(Student student) throws Exception {
        ArrayList<Student> stdList = new ArrayList<>();
        Class.forName(BaseConnection.nameClass);
        Connection conn = DriverManager.getConnection(BaseConnection.url, BaseConnection.username, BaseConnection.password);
        PreparedStatement ps = conn.prepareStatement("insert into student(id, name) values (?, ?);");
        ps.setInt(1, student.getId());
        ps.setString(2, student.getName());
        ps.executeUpdate();
    }
}
