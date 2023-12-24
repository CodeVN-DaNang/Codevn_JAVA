package main.model.repository;

import java.sql.*;
import java.util.ArrayList;

import main.model.entity.ClasS;

public class ClassRepository {

    ArrayList<ClasS> classes = new ArrayList<>();

    public ArrayList<ClasS> findAllClass() {
        classes.clear();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/manage_student_project", "root",
                    "nhat2102");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM manage_student_project.Class;");
            while (rs.next()) {
                int idClass = rs.getInt("classId");
                String nameClass = rs.getString("className");
                String startDate = rs.getString("startDate");
                boolean status = rs.getBoolean("statusClass");
                ClasS newClass = new ClasS(idClass, nameClass, startDate, status);
                classes.add(newClass);
            }
            con.close();
            return classes;
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e);
        }
        return null;
    }

    public ClasS findClassById(int idClass) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/manage_student_project", "root",
                    "nhat2102");
            PreparedStatement prsm = con.prepareStatement("SELECT * FROM manage_student_project.Class where classId = ?;");
            prsm.setInt(1, idClass);
            ResultSet rs = prsm.executeQuery();
            String nameClass = rs.getString("className");
            String startDate = rs.getString("startDate");
            boolean status = rs.getBoolean("statusClass");
            ClasS newClass = new ClasS(idClass, nameClass, startDate, status);
            con.close();
            return newClass;
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e);
        }
        return null;
    }

    public int createClass(ClasS newClasS) {
        int i = 0;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/manage_student_project", "root",
                    "nhat2102");
            PreparedStatement prst = con
                    .prepareStatement("insert into Class(className ,startDate,statusClass) values (?, ?, ?);");
            prst.setString(1, newClasS.getNameClass());
            prst.setString(2, newClasS.getStartDate());
            prst.setBoolean(3, newClasS.isStatus());
            i = prst.executeUpdate();
            con.close();
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e);
        }
        return i;
    }

    public int deleteClass(int classId) {
        int i = 0;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/manage_student_project", "root",
                    "nhat2102");
            PreparedStatement prst = con.prepareStatement("delete from manage_student_project.Class where classId=?");
            prst.setInt(1, classId);
            i = prst.executeUpdate();
            con.close();
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e);
        }
        return i;
    }

    public int updateClass(ClasS newClasS) {
        int i = 0;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/manage_student_project", "root",
                    "nhat2102");
            PreparedStatement prst = con.prepareStatement(
                    "update Class set className = ?, startDate = ?, statusClass = ? where classId = ?;");
            prst.setString(1, newClasS.getNameClass());
            prst.setString(2, newClasS.getStartDate());
            prst.setBoolean(3, newClasS.isStatus());
            prst.setInt(4, newClasS.getIdClass());
            i = prst.executeUpdate();
            con.close();
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e);
        }
        return i;
    }

}
