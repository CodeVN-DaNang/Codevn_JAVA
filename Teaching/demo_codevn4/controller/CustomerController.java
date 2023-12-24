package controller;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import model.entity.Customer;
import model.entity.TypeCustomer;
import model.service.CustomerService;
import utils.EmployeeValidate;

public class CustomerController {
    static Scanner sc = new Scanner(System.in);
    static CustomerService customerService = new CustomerService();

    public static void main(String[] args) throws IOException {
        // while (true) {
        //     System.out.println("----CUSTOMER MENU----\n"
        //             + "1. Add new Customer\n"
        //             + "2. dislay all\n"
        //             + "3. exit");
        //     int key = Integer.parseInt(sc.nextLine());
        //     switch (key) {
        //         case 1:
        //             addNewCustomer();
        //             break;
        //         case 2:
        //             displayAll();
        //             break;
        //         case 3:
        //             return;
        //         default:
        //             break;
        //     }
        // }
        String localDate = "";
        while (true) {
            localDate = sc.nextLine();
            if (EmployeeValidate.checkDay(localDate)) {
                break;
            }
            System.out.println("enter day like: 'dd/mm/yyyy'");
        }
        LocalDate day = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/mm/yyyy");
        String importDate = day.format(formatter);
        System.out.println(importDate);

    }

    private static void displayAll() throws IOException {
        int i = 0;
        for (Customer customer : customerService.getAllCustomer()) {
            System.out.println("|" + ++i + "\t|\t" + customer.getNameCustomer() + "\t|\t"
                    + customer.getTypeCustomer().getNameTypeCustomer() + "\t|");
        }
    }

    private static void addNewCustomer() throws IOException {
        System.out.println("Input id customer:");
        int idCustomer = Integer.parseInt(sc.nextLine());
        System.out.println("Input name customer:");
        String name = sc.nextLine();
        System.out.println("Input salary ");
        long price = Long.parseLong(sc.nextLine());
        System.out.println("Choose type customer");
        for (TypeCustomer typeCustomer : customerService.getAllTypeCustomers()) {
            System.out.println(typeCustomer.getIdTypeCustomer() + ", " + typeCustomer.getNameTypeCustomer());
        }
        int idTypeCustomer = Integer.parseInt(sc.nextLine());
        TypeCustomer typeCustomer = customerService.getTypeCustomerById(idTypeCustomer);
        Customer customer = new Customer(idCustomer, name, price, typeCustomer);
        customerService.addCustomer(customer);
    }
}
