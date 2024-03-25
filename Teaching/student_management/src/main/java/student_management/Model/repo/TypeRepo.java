package student_management.Model.repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import student_management.Model.entities.TypeStudent;

public class TypeRepo {
    BaseConnection baseConnection = new BaseConnection();

    public ArrayList<TypeStudent> getAllTypeStudents() {
        ArrayList<TypeStudent> typeStudents = new ArrayList<>();
        try {
            Connection conn = baseConnection.getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from type_student;");
            while (rs.next()) {
                int typeId = rs.getInt("type_id");
                String typeName = rs.getString("type_name");
                TypeStudent typeStudent = new TypeStudent(typeId, typeName);
                typeStudents.add(typeStudent);
            }
            st.close();

        } catch (Exception e) {
            System.out.println(e);
        }
        return typeStudents;
    }

    public TypeStudent getTypeStudentById(int typeId) {
        try {
            Connection conn = baseConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement("select * from type_student where type_id = ?");
            ps.setInt(1, typeId);
            ResultSet rs = ps.executeQuery();
            rs.next();
            String typeName = rs.getString("type_name");
            TypeStudent typeStudent = new TypeStudent(typeId, typeName);
            ps.close();
            return typeStudent;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

}
