/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.function.Predicate;
import model.Product;

/**
 *
 * @author vannhat
 */
public class Producer {
//    + List of Product




//    private int unitPrice;
//    private int quantity;
//    private String version;
//    private LocalDate  productManufactureDate;
    ArrayList<Product> productList = new ArrayList<>();
    Scanner sc = new Scanner(System.in);

    //+ Read text file to load data for List of Product – product.txt is provided (1 mark) 
    public void readFile() {
        try {
            FileReader fr = new FileReader("src/data/product.txt");
            BufferedReader br = new BufferedReader(fr);
            String line = "";
            while ((line = br.readLine()) != null) {
                String arr[] = line.split(",");
                String productId = arr[0];
                String productName = arr[1];
                int unitPrice = Integer.parseInt(arr[2]);
                int quantity = Integer.parseInt(arr[3]);
                String version = arr[4];
                DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                LocalDate productManufactureDate = LocalDate.parse(arr[5], dateFormat);
                Product product = new Product(productId, productName, unitPrice, quantity, version, productManufactureDate);
                productList.add(product);
            }
            fr.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    // write to file
    public void writeFile() {
        try {
            FileWriter fw = new FileWriter("src/data/product.txt");
            String line = "";
            for (Product product : productList) {
                line += product.getProductId() + "," + product.getProductName() + "," + product.getUnitPrice() + "," + product.getQuantity() + "," + product.getVersion() + "," + product.getProductManufactureDate().format(DateTimeFormatter.ofPattern("dd/MM/YYYY")) + "\n";
            }
            fw.write(line);
            fw.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    //+ Print any List of Product (1 mark)
    public void printList(ArrayList<Product> pList){
        for (Product product : pList) {
            System.out.println(product.toString());
        }
    }
    
    // list all product
    public void getAllProducts(){
        if (productList.isEmpty()) {
            readFile();
        }
        printList(productList);
    }
    
    //+ Add new Product from console (1 mark)
    public void addNewProduct(){
        System.out.println("Input product id:");
        String productId = sc.nextLine();
        System.out.println("Input product name:");
        String productName = sc.nextLine();
        System.out.println("Input product unit price:");
        int unitPrice = Integer.parseInt(sc.nextLine());
        System.out.println("Input product quantity:");
        int quantity = Integer.parseInt(sc.nextLine());
        System.out.println("Input product version:");
        String version = sc.nextLine();
        System.out.println("Input product manufacture date:");
        String dateInput = sc.nextLine();
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate productManufactureDate = LocalDate.parse(dateInput, dateFormat);
        Product product = new Product(productId, productName, unitPrice, quantity, version, productManufactureDate);
        productList.add(product);
    }
    
    //+ Search Product by different criteria  (1 mark)
    public void searchProduct(Predicate<Product> p){
        ArrayList<Product> findProduct = new ArrayList<>();
        for (Product product : productList) {
            if (p.test(product)) {
                findProduct.add(product);
            }
        }
        printList(findProduct);
    }

}
