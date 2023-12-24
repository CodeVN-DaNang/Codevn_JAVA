/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import controller.Producer;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import model.Product;

/**
 *
 * @author vannhat
 */
public class ProductManagement extends Menu<Product> {

    Producer producer = new Producer();
    Scanner sc = new Scanner(System.in);

    public ProductManagement(String td, String[] mc) {
        super(td, mc);
    }

    @Override
    public void execute(int n) {
        switch (n) {
            case 1:
                producer.getAllProducts();
                break;
            case 2:
                producer.addNewProduct();
                break;
            case 3:
                String mChonSearch[] = {"search by id", "search by name", "search by unit price", "search by quantity", "search by version", "search by manufacture date"};
                Menu searchMenu = new Menu("Search Menu", mChonSearch) {
                    @Override
                    public void execute(int n) {
                        System.out.println("Input criteria to search:");
                        String criteria = sc.nextLine();
                        switch (n) {
                            case 1:
                                producer.searchProduct(p -> p.getProductId().equalsIgnoreCase(criteria));
                                break;
                            case 2:
                                producer.searchProduct(p -> p.getProductName().contains(criteria));
                                break;
                            case 3:
                                producer.searchProduct(p -> p.getUnitPrice() == Integer.parseInt(criteria));
                                break;
                            case 4:
                                producer.searchProduct(p -> p.getQuantity() == Integer.parseInt(criteria));
                                break;
                            case 5:
                                producer.searchProduct(p -> p.getVersion().equalsIgnoreCase(criteria));
                                break;
                            case 6:
                                DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                                LocalDate dateCriteria = LocalDate.parse(criteria, dateFormat);
                                producer.searchProduct(p -> p.getProductManufactureDate().equals(dateCriteria));
                                break;
                        }
                    }
                };
                searchMenu.run();
                break;
        }
    }

}
