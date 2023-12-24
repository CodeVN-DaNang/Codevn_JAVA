package model.repository;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

import model.entity.Doctor;

public class DoctorRepository {

    public static void main(String[] args) throws Exception {
        DoctorRepository doctorRepository = new DoctorRepository();
        // for (Doctor doctor : doctorRepository.findAllDoctors()) {
        //     System.out.println(doctor.toString());
        // }
        Scanner sc = new Scanner(System.in);
        while (true) {
            int key = Integer.parseInt(sc.nextLine());
            switch (key) {
                case 1:
                    System.out.println("nhap vao id");
                    int id = Integer.parseInt(sc.nextLine());
                    System.out.println("nhap vao ten");
                    String name = sc.nextLine();
                    System.out.println("Nhap vao position:");
                    String position = sc.nextLine();
                    Doctor newDoctor = new Doctor(id, name, position);
                    doctorRepository.addNewDoctor(newDoctor);
                    break;
                case 2:
                    for (Doctor doctor : doctorRepository.findAllDoctors()) {
                        System.out.println(doctor.toString());
                    }
                default:
                    break;
            }
        }
        
    }



    public ArrayList<Doctor> findAllDoctors() throws Exception {
        ArrayList<Doctor> doctors = new ArrayList<>();
        FileReader fr = new FileReader("/Users/vannhat/Documents/java/NHATTV_JAVA/teaching/lab_3_manage_doctor/database/doctor.txt");
        BufferedReader br = new BufferedReader(fr);
        String result;
        while ((result= br.readLine()) != null) {
            int idDoctor = Integer.parseInt(result.split(",")[0]);
            String name = result.split(",")[1];
            String position = result.split(",")[2];
            Doctor doctor = new Doctor(idDoctor, name, position);
            doctors.add(doctor);
        }
        br.close();
        fr.close();
        return doctors;
    }

    public boolean addNewDoctor(Doctor newDoctor) throws Exception {
        ArrayList<Doctor> doctors = findAllDoctors();
        doctors.add(newDoctor);
        try {
            FileWriter fw = new FileWriter("/Users/vannhat/Documents/java/NHATTV_JAVA/teaching/lab_3_manage_doctor/database/doctor.txt");
            String doctorStr = "";
            for (Doctor doctor : doctors) {
                doctorStr += doctor.getIdDoctor() + "," + doctor.getNameDoctor() + "," + doctor.getPosition() + "\n";
            }
            fw.write(doctorStr);
            fw.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return true;
    }
}
