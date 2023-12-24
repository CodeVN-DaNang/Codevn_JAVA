import java.util.ArrayList;
import java.util.Scanner;

public class ProductManagement {
    static Scanner sc = new Scanner(System.in);
    static ArrayList<Product> productList = new ArrayList<>();

    public static void main(String[] args) {
        productList.add(new Product(1, "Nuoc ngot", "COCACOLA", "12/12/2022", "12/12/2022", 120, 10000));
        productList.add(new Product(2, "Nuoc loc", "AQUAFINA", "12/12/2022", "12/12/2022", 100, 6000));
        while (true) {
            System.out.println("======STORE======\n"
                    + "1. Buy product\n"
                    + "2. Display product\n"
                    + "3. Exit");
            int key = Integer.parseInt(sc.nextLine());
            switch (key) {
                case 1:
                    buyProduct();
                    break;
                case 2:
                    displayAllProduct();
                    break;
                case 3:
                    System.exit(0);
                default:
                    break;
            }
        }
        

    }

    private static void displayAllProduct() {
        for (Product product : productList) {
            product.display();
        }
    }

    private static void buyProduct() {
        displayAllProduct();
        System.out.println("Input index of product");
        int indexInput = Integer.parseInt(sc.nextLine());
        System.out.println("Input amount of product to buy");
        int amount = Integer.parseInt(sc.nextLine());
        Product product = productList.get(indexInput);
        product.buyProduct(amount);
        productList.set(indexInput, product);
    }
}
