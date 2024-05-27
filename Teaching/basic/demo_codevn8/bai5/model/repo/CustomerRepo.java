package model.repo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

import model.entities.Customer;

public class CustomerRepo {
    ArrayList<Customer> customers = new ArrayList<>();

    public void read() {
        customers.clear();
        try {
            FileReader fr = new FileReader(
                    "/Users/vannhat/Documents/Codevn_JAVA/Teaching/basic/demo_codevn8/bai5/data/Customer.txt");
            BufferedReader br = new BufferedReader(fr);
            String line = "";
            while ((line = br.readLine()) != null) {
                String[] arr = line.split(",");
                int id = Integer.parseInt(arr[0]);
                String name = arr[1];
                int age = Integer.parseInt(arr[2]);
                Customer customer = new Customer(id, name, age);
                customers.add(customer);
            }
            br.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void write() {
        try {
            FileWriter fw = new FileWriter(
                    "/Users/vannhat/Documents/Codevn_JAVA/Teaching/basic/demo_codevn8/bai5/data/Customer.txt");
            String line = "";
            for (Customer customer : customers) {
                line += customer.getId() + "," + customer.getName() + "," + customer.getAge() + "/n";
            }
            fw.write(line);
            fw.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public ArrayList<Customer> getAll() {
        read();
        return customers;
    }

    public Customer getById(int id) {
        read();
        for (Customer customer : customers) {
            if (customer.getId() == id) {
                return customer;
            }
        }
        return null;
    }

    public void add(Customer customer) {
        customers.add(customer);
        write();
    }

    public void delete(int id) {
        for (Customer customer : customers) {
            if (customer.getId() == id) {
                customers.remove(customer);
            }
        }
        write();
    }

    public void update(Customer newCustomer) {
        int count = 0;
        for (Customer customer : customers) {
            if (customer.getId() == newCustomer.getId()) {
                customers.set(count, newCustomer);
            }
            count++;
        }
        write();
    }
}
