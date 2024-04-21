import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Product product1 = new Product("hello", "hello", 12, "hello", 20.33);
        Product product2 = new Product("bye", "bye", 20, "bye", 19.8);
        ArrayList<Product> productList = new ArrayList<>();
        productList.add(product1);
        productList.add(product2);
        for (int i = 0; i < productList.size(); i++) {
            productList.get(i).display();
        }
        System.out.println("Input id of product:");
        // int index = Integer.parseInt(sc.nextLine());
        String id = sc.nextLine();
 
        // if (productList.get(index).amount < amount) {
        // System.out.println("Not enough!!!");
        // return;
        // }
        // productList.get(index).amount -= amount;
        // productList.get(index).setAmount(productList.get(index).amount - amount);
        // productList.get(index).display();
        // System.out.println("Total money: " + amount * productList.get(index).price);
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).productId.equals(id)) {
                System.out.println("Input amount of product want to buy:");
                int amount = Integer.parseInt(sc.nextLine());
                if (productList.get(i).amount < amount) {
                    System.out.println("Not enough!!!");
                    return;
                }
                productList.get(i).amount -= amount;
                productList.get(i).setAmount(productList.get(i).amount - amount);
                productList.get(i).display();
                System.out.println("Total money: " + amount * productList.get(i).price);
                return;
            }
        }
        System.out.println("Product dont exist");
    }
}
