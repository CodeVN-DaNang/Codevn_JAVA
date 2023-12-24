package model.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import model.entity.Student;

public class StudentRepository {
    ArrayList<Student> studentList = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        StudentRepository studentRepository = new StudentRepository();
        studentRepository.deleteStudent(4);
        for (Student student : studentRepository.getAllStudents()) {
            System.out.println(student.toString());
        }
    }

    public ArrayList<Student> getAllStudents() throws Exception {
        Class.forName(BaseConnection.className);
        Connection con = DriverManager.getConnection(BaseConnection.url, BaseConnection.username,
                BaseConnection.password);
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("select * from test.student;");
        while (rs.next()) {
            int id = rs.getInt("id");
            String name = rs.getString("name");
            Student student = new Student(id, name);
            studentList.add(student);
        }
        return studentList;
    }

    public Student getStudentById(int id) throws Exception {
        Class.forName(BaseConnection.className);
        Connection con = DriverManager.getConnection(BaseConnection.url, BaseConnection.username,
                BaseConnection.password);
        PreparedStatement st = con.prepareStatement("select * from test.student where id =  ?;");
        st.setInt(1, id);
        ResultSet rs = st.executeQuery();
        rs.next();
        String name = rs.getString("name");
        Student student = new Student(id, name);
        return student;
    }

    public void addStudent(Student student) throws Exception {
        Class.forName(BaseConnection.className);
        Connection con = DriverManager.getConnection(BaseConnection.url, BaseConnection.username,
                BaseConnection.password);
        PreparedStatement ps = con.prepareStatement("insert into test.student(name) values (?);");
        ps.setString(1, student.getName());
        ps.executeUpdate();
    }

    public void updateStudent(Student student) throws Exception {
        Class.forName(BaseConnection.className);
        Connection con = DriverManager.getConnection(BaseConnection.url, BaseConnection.username,
                BaseConnection.password);
        PreparedStatement ps = con.prepareStatement("update test.student set student.name = ? where student.id = ?;");
        ps.setString(1, student.getName());
        ps.setInt(2, student.getId());
        ps.executeUpdate();
    }

    public void deleteStudent(int id) throws Exception {
        Class.forName(BaseConnection.className);
        Connection con = DriverManager.getConnection(BaseConnection.url, BaseConnection.username,
                BaseConnection.password);
        PreparedStatement ps = con.prepareStatement("delete from test.student where student.id = ?;");
        ps.setInt(1, id);
        ps.executeUpdate();
    }

}
