/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

/**
 *
 * @author vannhat
 */
public class Main {
    public static void main(String[] args) {
        String mChon[] = {"get all product", "add new product", "search product"};
        ProductManagement produceManagement = new ProductManagement("Main Menu", mChon);
        produceManagement.run();
    }
}
