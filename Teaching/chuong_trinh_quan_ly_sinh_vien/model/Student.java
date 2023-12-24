package chuong_trinh_quan_ly_sinh_vien.model;


public class Student {
    private int idStudent;
    private String nameStudent;

    private Major major;

    public Student(String nameStudent, Major major) {
        this.nameStudent = nameStudent;
        this.major = major;
    }

    public String getNameStudent() {
        return nameStudent;
    }

    public void setNameStudent(String nameStudent) {
        this.nameStudent = nameStudent;
    }

    public Major getMajor() {
        return major;
    }

    public void setMajor(Major major) {
        this.major = major;
    }

    public String displayStudent() {
        return "Student [ " + nameStudent + " hoc nganh " + major.getNameMajor() + "]";
    }

    

}

// Khoi tao 2 lop: 

// 1. sinh vien voi cac thuoc tinh: id, ten, ngay thang nam sinh, gioi tinh, 
// diem 3 mon toan ly hoa, diem trung binh, phuong thuc xep loaij sinh vien, thuoc lop nao

// 2. giao vien voi cac thuoc tinh: id, ten, ngay thang nam sinh, gioi tinh, 
// vo dang hay chua, day nhung lop nao

