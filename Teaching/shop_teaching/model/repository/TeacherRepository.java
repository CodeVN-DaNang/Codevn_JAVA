package model.repository;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import model.entity.Teacher;

public class TeacherRepository {
    ArrayList<Teacher> teachers = new ArrayList<>();

    public ArrayList<Teacher> getAllTeacher() throws IOException {
        teachers.clear();
        FileReader file = new FileReader(
                "/Users/vannhat/Documents/java/NHATTV_JAVA/teaching/shop_teaching/model/repository/database.txt");
        BufferedReader buffer = new BufferedReader(file);
        String result;
        while ((result= buffer.readLine()) != null) {
            String name = result.split(",")[0];
            String subject = result.split(",")[1];
            String dateOfBirth = result.split(",")[2];
            String gender = result.split(",")[3];
            String phonenumber = result.split(",")[4];
            String email = result.split(",")[5];
            String address = result.split(",")[6];
            Teacher teacher = new Teacher(name, subject, dateOfBirth, gender, phonenumber, email, address);
            teachers.add(teacher);
        }
        buffer.close();
        file.close();
        return this.teachers;
    }

    public void writeToDatabase() {
        try {
            FileWriter fw = new FileWriter("/Users/vannhat/Documents/java/NHATTV_JAVA/teaching/shop_teaching/model/repository/database.txt");
            String teacherStr = "";
            for (Teacher teacher : teachers) {
                teacherStr = teacherStr + teacher.getName()+","+teacher.getSubject()+","+teacher.getDateOfBirth()+","+teacher.getGender()+","+teacher.getPhonenumber()+","+teacher.getEmail()+","+teacher.getAddress()+"\n";
            }
            fw.write(teacherStr);
            fw.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println("Success...");
    }

    public void addNewTeacher(Teacher teacher) {
        this.teachers.add(teacher);
        writeToDatabase();
    }

    public Teacher getByIndex(int index) {
        return this.teachers.get(index);
    }

    public void deleteTeacher(int index) {
        this.teachers.remove(index);
        writeToDatabase();
    }

    public void editTeacher(int index, Teacher teacher) {
        this.teachers.remove(index);
        this.teachers.add(index, teacher);
        writeToDatabase();
    }

}
