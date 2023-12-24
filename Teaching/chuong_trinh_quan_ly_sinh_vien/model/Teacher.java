package chuong_trinh_quan_ly_sinh_vien.model;

public class Teacher {
    private int idTeacher;
    private String nameTeacher;
    private Major major;

    public Teacher(String nameTeacher, Major major) {
        this.nameTeacher = nameTeacher;
        this.major = major;
    }

    public String getNameTeacher() {
        return nameTeacher;
    }
    public void setNameTeacher(String nameTeacher) {
        this.nameTeacher = nameTeacher;
    }
    public Major getMajor() {
        return major;
    }
    public void setMajor(Major major) {
        this.major = major;
    }

    public String displayTeacher() {
        return "Teacher [nameTeacher=" + nameTeacher + ", major=" + major.toString() + "]";
    }

    
}
