package student_management.Model.repository;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.*;

import student_management.Model.Entity.Student;
import student_management.Model.Entity.TypeStudent;

@Repository
public class StudentRepository { 
    @Autowired
    TypeStudentRepository typeStudentRepository = new TypeStudentRepository();
    // JpaRepository hibernate nosql mongodb
    ArrayList<Student> students = new ArrayList<>();
    

    // public static void main(String[] args) {
    //     StudentRepository studentRepository = new StudentRepository();
    //     ArrayList<Student> studentList = studentRepository.findAllStudent();
    //     for (Student student : studentList) {
    //         System.out.println(student.toString());
    //     }
    // }

    public ArrayList<Student> findAllStudent() {
        students.clear();
        try {
            Class.forName(BaseConnection.nameClass);
            Connection con = DriverManager.getConnection(BaseConnection.url, BaseConnection.username,
                    BaseConnection.password);
            Statement stsm = con.createStatement();
            ResultSet rs = stsm.executeQuery("select * from student_management_test.student");
            while (rs.next()) {
                String idStudent = rs.getInt("idStudent") + "";
                System.out.println("1");
                String nameStudent = rs.getString("nameStudent");
                String email = rs.getString("email");
                String phone = rs.getString("phone");
                double mark = rs.getDouble("mark");
                int TypeStudentId = rs.getInt("typeStudentId");
                TypeStudent typeStudent = typeStudentRepository.findTypeStudentById(TypeStudentId);
                Student student = new Student(idStudent, nameStudent, email, phone, mark, typeStudent.getTypeStudentId());
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
        // Student studentNull = new Student();
        try {
            Class.forName(BaseConnection.nameClass);
            Connection con = DriverManager.getConnection(BaseConnection.url, BaseConnection.username,
                    BaseConnection.password);
            PreparedStatement prsm = con
                    .prepareStatement("SELECT * FROM student_management_test.student where student_management_test.student.idStudent = ?;");
            prsm.setInt(1, idStudent);
            ResultSet rs = prsm.executeQuery();
            if (!rs.next()) {
                throw new IllegalArgumentException("ID " + idStudent + " not found in database");
            }
            String nameStudent = rs.getString("nameStudent");
            String email = rs.getString("email");
            String phone = rs.getString("phone");
            double mark = rs.getDouble("mark");
            int TypeStudentId = rs.getInt("TypeStudentId");
            TypeStudent typeStudent = typeStudentRepository.findTypeStudentById(TypeStudentId);
            Student student = new Student(idStudent +"", nameStudent, email, phone, mark, typeStudent.getTypeStudentId());
            con.close();
            return student;
        } catch (SQLException e) {
            // TODO: handle exception
            e.printStackTrace();
            return null;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    public int addNewStudent(Student student) {
        int i = 0;
        try {
            Class.forName(BaseConnection.nameClass);
            Connection con = DriverManager.getConnection(BaseConnection.url, BaseConnection.username,
                    BaseConnection.password);
            PreparedStatement prst = con
                    .prepareStatement("insert into student_management_test.Student(nameStudent ,email, phone, mark, TypeStudentId) values (?, ?, ?, ?, ?);");
            prst.setString(1, student.getNameStudent());
            prst.setString(2, student.getEmail());
            prst.setString(3, student.getPhone());
            prst.setDouble(4, student.getMark());
            prst.setInt(5, Integer.parseInt(student.getTypeStudentId()));
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
            PreparedStatement prst = con.prepareStatement("delete from student_management_test.Student where idStudent=?");
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
            PreparedStatement prst = con.prepareStatement(
                    "update student_management_test.Student set nameStudent = ?, email = ?, phone = ?, mark = ?, TypeStudentId = ? where idStudent = ?;");
            prst.setString(1, student.getNameStudent());
            prst.setString(2, student.getEmail());
            prst.setString(3, student.getPhone());
            prst.setDouble(4, student.getMark());
            prst.setInt(5, Integer.parseInt(student.getTypeStudentId()));
            prst.setInt(6, Integer.parseInt(student.getIdStudent()));
            i = prst.executeUpdate();
            con.close();
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e);
        }
        return i;
    }
}
