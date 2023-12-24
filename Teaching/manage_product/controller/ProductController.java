package manage_product.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

import manage_product.model.Product;

public class ProductController {
    static ArrayList<Product> productList = new ArrayList<>();
    public static void main(String[] args) {
        System.out.println("----MENU----\n"
            + "1. add product."
        );
        for (int i = 0; i < 5; i++) {
            addProduct();
        }
        displayAllProduct();
    }

    public static void addProduct(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("nhap Id:");
        String id = scanner.nextLine();
        System.out.println("nhap name:");
        String name = scanner.nextLine();
        System.out.println("nhap loai:");
        String type = scanner.nextLine();
        System.out.println("nhap noi san xuat:");
        String from = scanner.nextLine();
        LocalDate localDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd LLLL yyyy");
        String importDate = localDate.format(formatter);
        System.out.println("nhap gia tien:");
        long cost = Long.parseLong(scanner.nextLine());
        Product newProduct = new Product(id, name, type, from, importDate, cost);
        productList.add(newProduct);
    }

    public static void displayAllProduct(){
        for (int i = 0; i < productList.size(); i++) {
            productList.get(i).displayInfor();
        }
    }
}
