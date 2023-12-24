package student_management.Model.repository;

import java.sql.*;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import student_management.Model.Entity.TypeStudent;

@Repository
public class TypeStudentRepository {
    public ArrayList<TypeStudent> findAllTypeStudents() {
        ArrayList<TypeStudent> typeStudentList = new ArrayList<>();
        try {
            Class.forName(BaseConnection.nameClass);
            Connection con = DriverManager.getConnection(BaseConnection.url, BaseConnection.username,
                    BaseConnection.password);
            Statement stsm = con.createStatement();
            ResultSet rs = stsm.executeQuery("select * from student_management_test.TypeStudent");
            while (rs.next()) {
                int idTypeStudent = rs.getInt("typeStudentId");
                String nameTypeStudent = rs.getString("typeStudentName");
                TypeStudent typeStudent = new TypeStudent(idTypeStudent+"", nameTypeStudent);
                typeStudentList.add(typeStudent);
            }
            con.close();
            return typeStudentList;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public TypeStudent findTypeStudentById(int idTypeStudent) {
        try {
            Class.forName(BaseConnection.nameClass);
            Connection con = DriverManager.getConnection(BaseConnection.url, BaseConnection.username,
                    BaseConnection.password);
            PreparedStatement stsm = con.prepareStatement("select * from student_management_test.TypeStudent where typeStudentId = ?;");
            stsm.setInt(1, idTypeStudent);
            ResultSet rs = stsm.executeQuery();
            rs.next();
            String nameTypeStudent = rs.getString("typeStudentName");
            TypeStudent typeStudent = new TypeStudent(idTypeStudent+"", nameTypeStudent);
            con.close();
            return typeStudent;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
}
