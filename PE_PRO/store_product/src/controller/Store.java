/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.function.Predicate;
import model.Product;

/**
 *
 * @author vannhat
 */
public class Store {
    Scanner sc = new Scanner(System.in);
    ArrayList<Product> productList = new ArrayList<>();
        
    // List of Product
    public void listAllProducts(){
        if (productList.isEmpty()) {
            loadFile();
        }
        printList(productList);
    }
    
    //+ Print any List of Product(1 mark)
    public void printList(ArrayList<Product> pList){
        for (Product product : pList) {
            System.out.println(product.toString());
        }
        System.out.println("Total of List: " + pList.size());
    }
    
    //+ Read text file to load data for Store– store.txt is provided (1 mark)
    public void loadFile(){
        productList.clear();
        try{
            FileReader fr = new FileReader("src/data/product.txt"); // cop lai dung file dung duong link tuong 
            BufferedReader br = new BufferedReader(fr);
            String line = null;
            while((line = br.readLine()) != null){
                String arr[] = line.split(",");
                String productId = arr[0];
                String name = arr[1];
                String rate = arr[2];
                String idCategory = arr[3];
                Product newProduct = new Product(productId, name, rate, idCategory);
                productList.add(newProduct);
            }
            fr.close();
        } catch (Exception e){
            System.out.println(e);
        }
        
    }
    
    // write to file
    public void writeFile(){
        try{
            FileWriter fw = new FileWriter("src/data/product.txt"); // cop lai dung file
            String line = "";
            for (Product product : productList) {
                line += product.getProductId() + "," + product.getName()+ "," + product.getRate() + "," + product.getIdCategory() +"\n";
            }
            fw.write(line);
            fw.close();
        } catch (Exception e){
            System.out.println(e);
        }
    }
    
    // add new product
    public void addNewProduct(){
        System.out.println("Input id product:");
        String productId = sc.nextLine();
        System.out.println("Input name product:");
        String name = sc.nextLine();
        System.out.println("Input rate product:");
        String rate = sc.nextLine();
        System.out.println("Input id category:");
        String IdCategory = sc.nextLine();
        Product newProduct = new Product(productId, name, rate, IdCategory);
        productList.add(newProduct);
    }
    
    // search predicate
    public ArrayList<Product> search(Predicate<Product> p){
        ArrayList<Product> findProduct = new ArrayList<>();
        for (Product product : productList) {
            if (p.test(product)) {
                findProduct.add(product);
            }
        }
        return findProduct;
    }
    
    public void searchByProductId(String criteria){ // chu nhap vao de tim kiem
        ArrayList<Product> findProduct = search((Product p) -> p.getProductId().equalsIgnoreCase(criteria)); // trong (dieu kien de tim kiem)
        printList(findProduct);
    }
    
    public void searchByName(String criteria){
        ArrayList<Product> findProduct = search((Product p) -> p.getName().equalsIgnoreCase(criteria));
        printList(findProduct);
    }
    
    public void searchByRate(String criteria){
        ArrayList<Product> findProduct = search((Product p) -> p.getRate().equalsIgnoreCase(criteria));
        printList(findProduct);
    }
    
    public void searchByIdCategory(String criteria){
        ArrayList<Product> findProduct = search((Product p) -> p.getIdCategory().equalsIgnoreCase(criteria));
        printList(findProduct);
    }

}
