package controller;

import java.util.ArrayList;
import java.util.Scanner;

import model.entities.Customer;
import model.entities.TypeCustomer;
import model.service.CustomerService;

public class CustomerController {
    CustomerService customerService = new CustomerService();
    Scanner sc = new Scanner(System.in);

    public void customerMenu() {
        while (true) {
            System.out.println("----MENU----\n"
                + "1. display all\n"
                + "2. add customer\n"
                + "3. delete customer\n"
                + "4. update customer\n"
                + "5. search customer\n"
                + "6. exit"
            );
            int key = Integer.parseInt(sc.nextLine());
            switch (key) {
                case 1:
                    displayCustomer(customerService.getAllCustomers());
                    break;
                case 2:
                    addCustomer();
                    break;
                case 3:
                    deleteCustomer();
                    break;
                case 4:
                    updateCustomer();
                    break;
                case 5:
                    searchCustomer();
                    break;
                case 6:
                    System.out.println("Thank you");
                    System.exit(0);
                default:
                    break;
            }
        }
    }

    void searchCustomer() {
        System.out.println("Input phone to search: ");
        String phone = sc.nextLine();

        displayCustomer(customerService.searchCustomerByPhone(phone));

    }

    void updateCustomer() {
        System.out.println("Input username to edit: ");
        String username = sc.nextLine();

        Customer customer = customerService.getCustomerByUsername(username);

        System.out.println("Input name:");
        String name = sc.nextLine();
        if (name.equals("")) {
            name = customer.getName();
        }

        System.out.println("Input email:");
        String email = sc.nextLine();
        if (email.equals("")) {
            email = customer.getName();
        }

        System.out.println("Input phone:");
        String phone = sc.nextLine();
        if (phone.equals("")) {
            phone = customer.getName();
        }

        System.out.println("Input password:");
        String password = sc.nextLine();
        if (password.equals("")) {
            password = customer.getName();
        }

        TypeCustomer typeCustomer = customer.getTypeCustomer();
        Customer customer2 = new Customer(name, email, phone, username, password, typeCustomer);
        if (customerService.updateCustomer(customer2)) {
            System.out.println("Edit success...");
            return;
        }
        System.out.println("Edit failed...");
    }

    void deleteCustomer() {
        System.out.println("Input username to delete: ");
        String username = sc.nextLine();
        if (customerService.deleteCustomer(username)) {
            System.out.println("Delete success...");
            return;
        }
        System.out.println("Delete failed...");
    }

    void addCustomer() {
        System.out.println("Input name:");
        String name = sc.nextLine();
        System.out.println("Input email:");
        String email = sc.nextLine();
        System.out.println("Input phone:");
        String phone = sc.nextLine();
        System.out.println("Input username:");
        String username = "";
        while (!customerService.checkUniqueUsername(username) || username.equals("")) {
            username = sc.nextLine();
        }
        System.out.println("Input password:");
        String password = sc.nextLine();
        TypeCustomer typeCustomer = new TypeCustomer("1", "");
        Customer customer = new Customer(name, email, phone, username, password, typeCustomer);
        customerService.addCustomer(customer);
    }

    void displayCustomer(ArrayList<Customer> allCustomers) {
        int count = 0;
        for (Customer customer : allCustomers) {
            System.out.println(++count + ", " + customer.toString());
        }
    }

}
