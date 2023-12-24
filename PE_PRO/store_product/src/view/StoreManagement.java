/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import controller.Store;
import java.util.Scanner;
import model.Product;

/**
 *
 * @author vannhat
 */
public class StoreManagement extends Menu<Product> {
    Scanner sc = new Scanner(System.in);
    Store store = new Store();
    String mChonSearch[] = {"search by product id.", "search by product name.", "search by product rate.", "search by id category.", "exit search"};

    public StoreManagement(String td, String[] mc) {
        super(td, mc);
    }

    public static void main(String[] args) {
        String mChon[] = {"list all", "add new product", "Search", "write to file"};
        StoreManagement storeManagement = new StoreManagement("MAIN MENU", mChon);

        storeManagement.run();
    }

    @Override
    public void execute(int n) {
        switch (n) {
            case 1:
                store.listAllProducts();
                break;
            case 2:
                store.addNewProduct();
                break;
            case 3:
                Menu searchMenu = new Menu("Menu search", mChonSearch) {
                    @Override
                    public void execute(int n) {
                        System.out.println("Input criteria to search:");
                        String criteria = sc.nextLine();
                        switch (n) {
                            case 1:
                                store.searchByProductId(criteria);
                                break;
                            case 2:
                                store.searchByName(criteria);
                                break;
                            case 3:
                                store.searchByRate(criteria);
                                break;
                            case 4:
                                store.searchByIdCategory(criteria);
                                break;
                            case 5:
                                System.exit(0);
                            default:
                                break;
                        }
                    }
                };
                searchMenu.run();
                break;
            case 4:
                store.writeFile();
                break;
            case 5:
                System.exit(1);
        }
    }

}
