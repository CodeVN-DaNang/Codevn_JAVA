package model.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import model.entity.Student;

public class StudentRepo {
    ArrayList<Student> studentList = new ArrayList<>();

    public ArrayList<Student> getAllStudent() {
        try {
            Connection conn = BaseConnection.getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from student");
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                Student student = new Student(id, name);
                studentList.add(student);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return studentList;
    }

    public ArrayList<Student> getAllStudentbyid(String id) {
        try {
            Connection conn = BaseConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement("select * from student where name = ?");
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id1 = rs.getInt("id");

                Student student = new Student(id1, id);
                studentList.add(student);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return studentList;
    }

}
