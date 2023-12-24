package controller;

import java.util.List;
import java.util.Scanner;

import model.entity.BienLai;
import model.entity.KhachHang;

import model.service.BienLaiService;
import model.service.KhachHangService;

public class Controller {
    static KhachHangService khachHangService = new KhachHangService();
    static BienLaiService bienLaiService = new BienLaiService();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("MENU\n"
                    + "1. add\n"
                    + "2. get\n"
                    + "3. update\n"
                    + "4. delete");
            int key = Integer.parseInt(sc.nextLine());
            switch (key) {
                case 1:
                    addNewKhachHang();
                    break;
                case 2:
                    getAllKhachHang();
                    break;
                case 3:
                    updateKhachHang();
                    break;
                case 4:
                    deleteKhachHang();
                    break;
                default:

                    break;
            }
        }
    }

    private static void deleteKhachHang() {
        System.out.print("Enter code you want remove :  ");
        String maSoCongToDienXoa = sc.nextLine();
        KhachHang khachHangXoa = khachHangService.timKhachHangTheoMa(maSoCongToDienXoa);

        if (khachHangXoa == null) {
            System.out.println("Not found : ");
        }

        khachHangService.deleteKhachHang(khachHangXoa);
        System.out.println("Success");
    }

    private static void updateKhachHang() {
        System.out.print("Enter the electricity meter code of the customer to be repaired: ");// Nhập mã số công tơ điện
                                                                                              // của khách hàng cần sửa
        String houseNumber = sc.nextLine();
        KhachHang khachHangSua = khachHangService.timKhachHangTheoMa(houseNumber);

        if (khachHangSua == null) {
            System.out.println("not found");

        }

        System.out.print("Enter new name : ");
        String names = sc.nextLine();
        System.out.print("Enter new house Number  ");
        String houseNumbers = sc.nextLine();
        System.out.print("Enter new code  ");
        double codes = sc.nextDouble();

        KhachHang khachHang = new KhachHang(names, houseNumbers, codes);
        khachHangService.updateKhachHang(khachHang);
        System.out.println("success ");

    }

    private static void getAllKhachHang() {
        System.out.println("List Khach Hang va bien lai :");
        List<BienLai> danhSachBienLai = bienLaiService.getAllBienLai();
        for (BienLai bienLai : danhSachBienLai) {
            System.out.println("name : " + bienLai.getKhachHang().getName());
            System.out.println("houser number : " + bienLai.getKhachHang().getHouseNumber());
            System.out.println("code : " + bienLai.getKhachHang().getCode());
            System.out.println("--------------------");
            System.out.println("Chi so dien cu : " + bienLai.getChiSoDienCu());
            System.out.println("Chi so dien moi :  " + bienLai.getChiSoDienMoi());
            System.out.println("So tien phai tra :  " + bienLai.getTien());
            System.out.println("--------------------");
        }
    }


    private static void addNewKhachHang() {
        System.out.println(" Enter the name of the householder : ");
        String name = sc.nextLine();
        System.out.println("Enter house number : ");
        String houseNumber = sc.nextLine();
        System.out.println("Enter code : ");
        double code = Double.parseDouble(sc.nextLine());

        KhachHang khachHang = new KhachHang(name, houseNumber, code);
        khachHangService.addNewKhachHang(khachHang);
        System.out.println(" success ");

    }
}
