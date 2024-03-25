import java.util.Scanner;

public class CRUD_baitap {

    static Scanner sc = new Scanner(System.in);
    static String[] products = { "electronic,E-123", "car,C-456", "latop,L-147" };

    public static void main(String[] args) {
        while (true) {
            System.out.println("----MENU----\n"
                    + "1. Add new product\n"
                    + "2. Delete product\n"
                    + "3. Edit product\n"
                    + "4. Seach product\n"
                    + "5. Display all\n"
                    + "6. Exit\n"
                    + "------------");
            int key = Integer.parseInt(sc.nextLine());
            switch (key) {
                case 1:
                    addProduct();
                    break;
                case 2:
                    deleteProduct();
                    break;
                case 3:
                    editProduct();
                    break;
                case 4:
                    searchProduct();
                    break;
                case 5:
                    displayAll();
                    break;
                case 6:
                    System.exit(0);

                default:
                    break;
            }
        }

    }

    public static void displayAll() {
        for (int i = 0; i < products.length; i++) {
            System.out.println(products[i]);
        }
    }

    public static void addProduct() {
        System.out.println("Input type of product: ");
        String type = sc.nextLine();
        System.out.println("Input code of product:");
        String code = sc.nextLine();
        String product = type + "," + code;
        String[] b = new String[products.length + 1];
        for (int i = 0; i < b.length; i++) {
            if (i == b.length - 1) {
                b[i] = product;
                break;
            }
            b[i] = products[i];
        }
        products = b;
    }

    public static void deleteProduct() {
        System.out.println("Input code of product to delete:");
        String code = sc.nextLine();
        for (int i = 0; i < products.length; i++) {
            String[] a = products[i].split(",");
            if (a[1].equals(code)) {
                System.out.println(products[i]);
                System.out.println("Do you want to delete? Y || N");
                String choice = sc.nextLine();
                if (choice.equalsIgnoreCase("Y") || choice.equalsIgnoreCase("Yes")) {
                    String[] b = new String[products.length - 1];
                    for (int j = 0; j < b.length; j++) {
                        if (j < i) {
                            b[j] = products[j];
                        } else {
                            b[j] = products[j + 1];
                        }
                    }
                    products = b;
                    break;
                }
            }
        }
    }

    public static void editProduct() {
        System.out.println("Input code of product to edit:");
        String code = sc.nextLine();
        for (int i = 0; i < products.length; i++) {
            String[] a = products[i].split(",");
            if (a[1].equals(code)) {
                System.out.println(products[i]);
                System.out.println("Input type of product: ");
                String type = sc.nextLine();
                if (type.equals("")) {
                    type = a[0];
                }
                System.out.println("Input code of product:");
                code = sc.nextLine();
                if (code.equals("")) {
                    code = a[1];
                }
                String product = type + "," + code;
                products[i] = product;
            }
        }
    }

    public static void searchProduct() {
        System.out.println("Input to search product:");
        String searchInput = sc.nextLine();
        for (int i = 0; i < products.length; i++) {
            if (products[i].contains(searchInput)) {
                System.out.println(products[i]);
            }
        }
    }

}
