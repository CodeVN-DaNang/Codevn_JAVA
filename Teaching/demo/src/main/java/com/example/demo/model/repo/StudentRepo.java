package com.example.student_management_test.model.repo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.example.student_management_test.model.entity.Student;

@Repository
public class StudentRepo {
    ArrayList<Student> studentList = new ArrayList<>();

    public ArrayList<Student> getAllStudent() {
        studentList.clear();
        try {
            Class.forName(BaseConnection.className);
            Connection con = DriverManager.getConnection(BaseConnection.url, BaseConnection.username,
                    BaseConnection.password);
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from student_management_test.student;");
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int age = rs.getInt("age");
                String phone = rs.getString("phone");
                Student student = new Student(id, name, age, phone);
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
            Class.forName(BaseConnection.className);
            Connection con = DriverManager.getConnection(BaseConnection.url, BaseConnection.username,
                    BaseConnection.password);
            PreparedStatement st = con.prepareStatement("select * from student_management_test.student where student.id = ?;");
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            rs.next();
            id = rs.getInt("studentId");
            String name = rs.getString("studentName");
            String email = rs.getString("email");
            String phone = rs.getString("phone");
            Student student = new Student(id, name, age, phone);
            st.close();
            return student;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public int createPeople(Student p) {
        int result = 0;
        try {
            Class.forName(BaseConnection.className);
            Connection con = DriverManager.getConnection(BaseConnection.url, BaseConnection.username,
                    BaseConnection.password);
            PreparedStatement prsm = con.prepareStatement("INSERT INTO student_management_test.Student(name, age, phone) VALUES (?,?,?);");
            prsm.setString(1, p.getName());
            prsm.setInt(2, p.getAge());
            prsm.setString(3, p.getPhone());
            result = prsm.executeUpdate();
            con.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public int updatePeople(Student p) {
        int result = 0;
        try {
            Class.forName(BaseConnection.className);
            Connection con = DriverManager.getConnection(BaseConnection.url, BaseConnection.username,
                    BaseConnection.password);
            PreparedStatement prsm = con
                    .prepareStatement("update student_management_test.student set name=?, age=?, phone=? where id=?;");
            prsm.setString(1, p.getName());
            prsm.setInt(2, p.getAge());
            prsm.setString(3, p.getPhone());
            prsm.setInt(4, p.getId());
            result = prsm.executeUpdate();
            con.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public int deletePeople(int id) {
        int result = 0;
        try {
            Class.forName(BaseConnection.className);
            Connection con = DriverManager.getConnection(BaseConnection.url, BaseConnection.username,
                    BaseConnection.password);
            PreparedStatement prsm = con.prepareStatement("DELETE FROM student_management_test.student where id=?;");
            prsm.setInt(1, id);
            result = prsm.executeUpdate();
            con.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

}
