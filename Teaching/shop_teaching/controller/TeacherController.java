package controller;

import java.io.IOException;
import java.util.ArrayList;

import model.entity.Teacher;
import model.service.TeacherService;

public class TeacherController {
    public static void main(String[] args) throws IOException {
        TeacherService teacherService = new TeacherService();
        teacherService.getAllTeacher();
        Teacher teacher = new Teacher("Tung", "PRF", "23/2/2003", "Male", "123123", "tungprf@gmail.com", "QuangBinh");
        teacherService.addNewTeacher(teacher);
        ArrayList<Teacher> teachers = teacherService.getAllTeacher();
        for (Teacher vinh : teachers) {
            System.out.println(vinh);
        }
    }
}
