package main.model.repository;

import java.util.ArrayList;
import java.sql.*;

import main.model.entity.ClasS;
import main.model.entity.Student;

public class StudentRepository {
    ArrayList<Student> students = new ArrayList<>();
    ClassRepository classRepository = new ClassRepository();
    public ArrayList<Student> findAllStudents() {
        
        students.clear();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/manage_student_project", "root",
                    "nhat2102");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM manage_student_project.Student;");
            while (rs.next()) {
                int studentId = rs.getInt("studentId");
                String nameStudent = rs.getString("nameStudent");
                String address = rs.getString("address");
                String phone = rs.getString("phone");
                boolean status = rs.getBoolean("status");
                int classId = rs.getInt("classId");
                ClasS class1 = classRepository.findClassById(classId);
                Student student = new Student(studentId, nameStudent, address, phone, status, class1);
                students.add(student);
            }
            con.close();
            return students;
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e);
        }
        return null;
    }

    public Student findStudentById(int idStudent) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/manage_student_project", "root",
                    "nhat2102");
            PreparedStatement prsm = con.prepareStatement("SELECT * FROM manage_student_project.Student where studentId = ?;");
            prsm.setInt(1, idStudent);
            ResultSet rs = prsm.executeQuery();
            int studentId = rs.getInt("studentId");
            String nameStudent = rs.getString("nameStudent");
            String address = rs.getString("address");
            String phone = rs.getString("phone");
            boolean status = rs.getBoolean("status");
            int classId = rs.getInt("classId");
            ClasS class1 = classRepository.findClassById(classId);
            Student student = new Student(studentId, nameStudent, address, phone, status, class1);
            con.close();
            return student;
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e);
        }
        return null;
    }

    public int creatStudent(Student student) {
        int i = 0;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/manage_student_project", "root",
                    "nhat2102");
            PreparedStatement prst = con.prepareStatement("insert into Student(studentName ,address, phone, status, classId) values (?, ?, ?, ?, ?);");
            prst.setString(1, student.getNameStudent());
            prst.setString(2, student.getAddress());
            prst.setString(3, student.getPhone());
            prst.setBoolean(4, student.isStatus());
            prst.setInt(5, student.getClassId().getIdClass());
            i = prst.executeUpdate();
            con.close();
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e);
        }
        return i;
    }

    public int deleteStudent(int studentId) {
        int i = 0;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/manage_student_project", "root",
                    "nhat2102");
            PreparedStatement prst = con.prepareStatement("delete from manage_student_project.Student where studentId=?");
            prst.setInt(1, studentId);
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
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/manage_student_project", "root",
                    "nhat2102");
                    //studentName ,address, phone, status, classId
            PreparedStatement prst = con.prepareStatement("update Class set studentName = ?, address = ?, phone = ?, status = ?, classId = ? where studentId = ?;");
            prst.setString(1, student.getNameStudent());
            prst.setString(2, student.getAddress());
            prst.setString(3, student.getPhone());
            prst.setBoolean(4, student.isStatus());
            prst.setInt(5, student.getClassId().getIdClass());
            prst.setInt(6, student.getIdStudent());
            i = prst.executeUpdate();
            con.close();
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e);
        }
        return i;
    }
}
