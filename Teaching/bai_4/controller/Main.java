package bai_4.controller;

import java.util.ArrayList;
import java.util.Scanner;

import bai_4.model.HoGiaDinh;
import bai_4.model.KhuPho;
import bai_4.model.Nguoi;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static ArrayList<HoGiaDinh> hoGiaDinhList = new ArrayList<>();

    public static void main(String[] args) {
        while (true) {
            System.out.println("----MENU----\n"
                    + "1. them moi ho dan\n"
                    + "2. in ra ho dan\n"
                    + "3. thoat");
            int key = Integer.parseInt(scanner.nextLine());
            switch (key) {
                case 1:
                    themMoiHoDan();
                    break;
                case 2:
                    inHoDan();
                    break;
                case 3:
                    return;
                default:
                    break;
            }
        }

    }

    private static void inHoDan() {
        for (int i = 0; i < hoGiaDinhList.size(); i++) {
            System.out.println(hoGiaDinhList.get(i).toString());
        }
    }

    private static void themMoiHoDan() {
        // String idHoGiaDinh, String soNha, int soThanhVien, ArrayList<Nguoi>
        // thanhVienGiaDinhList, KhuPho khuPho
        System.out.println("Nhap id ho gia dinh");
        String idHoGiaDinh = scanner.nextLine();
        System.out.println("Nhap so nha ho gia dinh");
        String soNha = scanner.nextLine();
        System.out.println("Nhap so thanh vien ho gia dinh");
        int soThanhVien = Integer.parseInt(scanner.nextLine());
        ArrayList<Nguoi> nguoiList = new ArrayList<>();
        for (int i = 0; i < soThanhVien; i++) {
            System.out.println("Them moi thanh vien thu " + (i + 1));
            Nguoi newNguoi = themThanhVien();
            nguoiList.add(newNguoi);
        }
        System.out.println("Chon khu pho:\n"
                + "1. khu pho 1\n"
                + "2. khu pho 2\n");
        KhuPho khuPho = new KhuPho();
        int key = Integer.parseInt(scanner.nextLine());
        switch (key) {
            case 1:
                khuPho = new KhuPho("1", "Khu pho 1");
                break;
            case 2:
                khuPho = new KhuPho("2", "Khu pho 2");
                break;
            default:
                break;
        }
        HoGiaDinh hoGiaDinh = new HoGiaDinh(idHoGiaDinh, soNha, soThanhVien, nguoiList, khuPho);
        hoGiaDinhList.add(hoGiaDinh);
    }

    private static Nguoi themThanhVien() {
        // String idNguoi, String tenNguoi, String tuoiNguoi, String ngheNghiep, String
        // cmnd
        System.out.println("Nhap id nguoi");
        String idNguoi = scanner.nextLine();
        System.out.println("Nhap ten nguoi");
        String tenNguoi = scanner.nextLine();
        System.out.println("Nhap tuoi nguoi");
        String tuoiNguoi = scanner.nextLine();
        System.out.println("Nhap nghe nghiep nguoi");
        String ngheNgiep = scanner.nextLine();
        System.out.println("Nhap cmnd nguoi");
        String cmnd = scanner.nextLine();
        Nguoi nguoiMoi = new Nguoi(idNguoi, tenNguoi, tuoiNguoi, ngheNgiep, cmnd);
        return nguoiMoi;
    }

    


}



