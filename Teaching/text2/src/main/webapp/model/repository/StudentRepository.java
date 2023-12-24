package com.example.model.repository;

import java.sql.*;
import java.util.ArrayList;

import com.example.model.entity.Student;

public class StudentRepository {
    ArrayList<Student> students = new ArrayList<>();

    public ArrayList<Student> findAllStudent() {
        students.clear();
        try {
            Class.forName(BaseConnection.nameClass);
            Connection con = DriverManager.getConnection(BaseConnection.url, BaseConnection.username,
                    BaseConnection.password);
            Statement stsm = con.createStatement();
            ResultSet rs = stsm.executeQuery("select * from test.student");
            while (rs.next()) {
                int idStudent = rs.getInt("idStudent");
                String nameStudent = rs.getString("nameStudent");
                String email = rs.getString("email");
                String phone = rs.getString("phone");
                double mark = rs.getDouble("mark");
                Student student = new Student(idStudent, nameStudent, email, phone, mark);
                students.add(student);
            }
            con.close();
            return students;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public Student findStudentById(int idStudent) {
        try {
            Class.forName(BaseConnection.nameClass);
            Connection con = DriverManager.getConnection(BaseConnection.url, BaseConnection.username,
                    BaseConnection.password);
            PreparedStatement prsm = con.prepareStatement("SELECT * FROM test.student where idStudent = ?;");
            prsm.setInt(1, idStudent);
            ResultSet rs = prsm.executeQuery();
            String nameStudent = rs.getString("nameStudent");
            String email = rs.getString("email");
            String phone = rs.getString("phone");
            double mark = rs.getDouble("mark");
            Student student = new Student(idStudent, nameStudent, email, phone, mark);
            con.close();
            return student;
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e);
        }
        return null;
    }

    public int addNewStudent(Student student) {
        int i = 0;
        try {
            Class.forName(BaseConnection.nameClass);
            Connection con = DriverManager.getConnection(BaseConnection.url, BaseConnection.username,
                    BaseConnection.password);
            PreparedStatement prst = con.prepareStatement("insert into test.Student(nameStudent ,email, phone, mark) values (?, ?, ?, ?);");
            prst.setString(1, student.getNameStudent());
            prst.setString(2, student.getEmail());
            prst.setString(3, student.getPhone());
            prst.setDouble(4, student.getMark());
            i = prst.executeUpdate();
            con.close();
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e);
        }
        return i;
    }

    public int deleteStudent(int idStudent) {
        int i = 0;
        try {
            Class.forName(BaseConnection.nameClass);
            Connection con = DriverManager.getConnection(BaseConnection.url, BaseConnection.username,
                    BaseConnection.password);
            PreparedStatement prst = con.prepareStatement("delete from test.Student where idStudent=?");
            prst.setInt(1, idStudent);
            i = prst.executeUpdate();
            con.close();
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e);
        }
        return i;
    }

    public int updateStudent(Student student) {
        int i = 0;
        try {
            Class.forName(BaseConnection.nameClass);
            Connection con = DriverManager.getConnection(BaseConnection.url, BaseConnection.username,
                    BaseConnection.password);
            PreparedStatement prst = con.prepareStatement("update test.student set nameStudent = ?, email = ?, phone = ?, mark = ? where idStudent = ?;");
            prst.setString(1, student.getNameStudent());
            prst.setString(2, student.getEmail());
            prst.setString(3, student.getPhone());
            prst.setDouble(4, student.getMark());
            prst.setInt(5, student.getIdStudent());
            i = prst.executeUpdate();
            con.close();
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e);
        }
        return i;
    }
}
