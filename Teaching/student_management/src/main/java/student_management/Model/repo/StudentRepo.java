package student_management.Model.repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import student_management.Model.entities.Student;
import student_management.Model.entities.TypeStudent;

public class StudentRepo {
    TypeRepo typeRepo = new TypeRepo();
    BaseConnection baseConnection = new BaseConnection();

    // public static void main(String[] args) {
    //     StudentRepo studentRepo = new StudentRepo();
    //     for (Student student : studentRepo.getAllStudents()) {
    //         System.out.println(student.toString());
    //     }
    // }

    public ArrayList<Student> getAllStudents() {
        ArrayList<Student> students = new ArrayList<>();
        try {
            Connection conn = baseConnection.getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from student");
            while (rs.next()) {
                int studentId = rs.getInt("student_id");
                String studentName = rs.getString("student_name");
                int typeId = rs.getInt("type_student");
                TypeStudent typeStudent = typeRepo.getTypeStudentById(typeId);
                Student student = new Student(studentId, studentName, typeStudent);
                students.add(student);
            }
            st.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return students;
    }

    public Student getStudentById(int studentId) {
        try {
            Connection conn = baseConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement("select * from student where student_id = ?");
            ps.setInt(1, studentId);
            ResultSet rs = ps.executeQuery();
            rs.next();
            String studentName = rs.getString("student_name");
            int typeId = rs.getInt("type_student");
            TypeStudent typeStudent = typeRepo.getTypeStudentById(typeId);
            Student student = new Student(studentId, studentName, typeStudent);
            ps.close();
            return student;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public void addStudent(Student student){
        try {
            Connection conn = baseConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement("insert into student(student_name, type_student) values (?,?)");
            ps.setString(1, student.getStudentName());
            ps.setInt(2, student.getTypeStudent().getTypeId());
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void updateStudent(Student student){
        try {
            Connection conn = baseConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement("update student set student_name = ?, type_student = ? where student_id = ?;");
            ps.setString(1, student.getStudentName());
            ps.setInt(2, student.getTypeStudent().getTypeId());
            ps.setInt(3, student.getStudentId());
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void deleteStudent(int studentId){
        try {
            Connection conn = baseConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement("delete from student where student_id = ?");
            ps.setInt(1, studentId);
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
