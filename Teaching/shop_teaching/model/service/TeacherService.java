package model.service;

import java.io.IOException;
import java.util.ArrayList;

import model.entity.Teacher;
import model.repository.TeacherRepository;

public class TeacherService {
    TeacherRepository teacherRepository = new TeacherRepository();
    ArrayList<Teacher> teachers = new ArrayList<>();

    public ArrayList<Teacher> getAllTeacher() throws IOException {
        this.teachers = teacherRepository.getAllTeacher();
        if (teachers.isEmpty()) {
            throw new UnknownError("Hello");
        }
        return teachers;
    }

    public ArrayList<Teacher> getTeacherById(String subject) throws IOException {
        ArrayList<Teacher> findTeachers = new ArrayList<>();
        getAllTeacher();
        for (int i = 0; i < teachers.size(); i++) {
            if (teachers.get(i).getSubject().equals(subject)) {
                findTeachers.add(teachers.get(i));
            }
        }
        return findTeachers;
    }

    public void addNewTeacher(Teacher teacher) {
        teacherRepository.addNewTeacher(teacher);
    }

    public void deleteTeacher(int index) {
        teacherRepository.deleteTeacher(index);
    }

    public void editTeacher(int index, Teacher teacher) {
        teacherRepository.editTeacher(index, teacher);
    }

}
