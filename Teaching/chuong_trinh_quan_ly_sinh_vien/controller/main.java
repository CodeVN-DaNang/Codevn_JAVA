package chuong_trinh_quan_ly_sinh_vien.controller;

import java.util.Scanner;

import chuong_trinh_quan_ly_sinh_vien.model.Major;
import chuong_trinh_quan_ly_sinh_vien.model.Student;

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Major businessMajor = new Major(1, "business");
        Major softwareMajor = new Major(2, "it");

        // nhap sinh vien
        while (true) {
            System.out.println("Nhap thong tin sv 1");
            System.out.println("Nhap vao ten");
            String nameStudent = scanner.nextLine();
            System.out.println("Chon nganh ma ban muon hoc:\n"
                    + "1. " + businessMajor.getNameMajor() + "\n"
                    + "2. " + softwareMajor.getNameMajor());
            int choice = Integer.parseInt(scanner.nextLine());
            Major newMajor = new Major();
            switch (choice) {
                case 1:
                    newMajor = businessMajor;
                    break;
                case 2:
                    newMajor = softwareMajor;
                    break;
                default:
                    break;
            }
            Student newStudent = new Student(nameStudent, newMajor);
            System.out.println(newStudent.displayStudent());
        }
    }

    // khởi tạo 1 class User có các thuộc tính là :
    //
}
