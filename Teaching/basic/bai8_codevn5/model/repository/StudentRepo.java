package model.repository;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

import model.entity.Student;

public class StudentRepo {
    // CRUD voi 1 arraylist t3 a se cho thao tac voi file de moi nguoi tap lam quen
    // thao tac
    ArrayList<Student> studentList = new ArrayList<>();

    public void readTxt() {
        studentList.clear();
        try {
            FileReader fr = new FileReader("data/Student.txt");
            BufferedReader br = new BufferedReader(fr);
            String line = "";
            while ((line = br.readLine()) != null) {
                String name = line.split(",")[0];
                int age = Integer.parseInt(line.split(",")[1]);
                String classes = line.split(",")[2];
                Student student = new Student(name, age, classes);
                studentList.add(student);
            }
            br.close();
            fr.close();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    public void writeTxt() {
        try {
            FileWriter fw = new FileWriter("data/Student.txt");
            String dataToTxt = "";
            for (Student student : studentList) {
                dataToTxt = dataToTxt + student.getName() + "," + student.getAge() + "," + student.getClasses() + "\n";
            }
            fw.write(dataToTxt);
            fw.close();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    public ArrayList<Student> getAllStudents() {
        readTxt();
        return studentList;
    }

    public Student getStudentByName(String name){
        readTxt();
        for (Student student : studentList) {
            if (student.getName().equals(name)) {
                return student;
            }
        }
        return null;
    }

    public Student getStudentById(int index) {
        readTxt();
        return studentList.get(index);
    }

    public void addNewStudent(Student student) {
        studentList.add(student);
        writeTxt();
    }

    public void deleteStudent(int index) {
        studentList.remove(index);
        writeTxt();
    }

    public void editStudent(int index, Student student) {
        studentList.set(index, student);
        writeTxt();
    }
}
