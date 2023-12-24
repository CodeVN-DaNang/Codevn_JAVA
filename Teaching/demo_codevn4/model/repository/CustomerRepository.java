package model.repository;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import model.entity.Customer;
import model.entity.TypeCustomer;

public class CustomerRepository {

    TypeCustomerRepository typeCustomerRepository = new TypeCustomerRepository();

    private ArrayList<Customer> customers = new ArrayList<>();

    public ArrayList<Customer> read() throws IOException {
        customers.clear();
        FileReader fr = new FileReader(
                "/Users/vannhat/Documents/java/NHATTV_JAVA/teaching/demo_codevn4/data/customer.txt");
        BufferedReader bf = new BufferedReader(fr);
        String st;
        while ((st = bf.readLine()) != null) {
            int idCustomer = Integer.parseInt(st.split(",")[0]);
            String nameCustomer = st.split(",")[1];
            long price = Long.parseLong(st.split(",")[2]);
            TypeCustomer typeCustomer = typeCustomerRepository.getTypeCustomerById(Integer.parseInt(st.split(",")[3]));
            Customer customer = new Customer(idCustomer, nameCustomer, price, typeCustomer);
            customers.add(customer);
        }
        bf.close();
        fr.close();
        return customers;
    }

    public void write() throws IOException {
        FileWriter fw = new FileWriter(
                "/Users/vannhat/Documents/java/NHATTV_JAVA/teaching/demo_codevn4/data/customer.txt");
        String customerData = "";
        for (Customer customer : customers) {
            customerData += customer.getIdCustomer() + "," + customer.getNameCustomer() + "," + customer.getPrice()
                    + "," + customer.getTypeCustomer().getIdTypeCustomer() + "\n";
        }
        fw.write(customerData);
        fw.close();
    }

    public ArrayList<Customer> getAllCustomer() throws IOException {
        read();
        return this.customers;
    }

    public Customer getCustomerById(int idCustomer) {
        for (Customer customer : customers) {
            if (customer.getIdCustomer() == idCustomer) {
                return customer;
            }
        }
        return null;
    }

    public void addCustomer(Customer customer) throws IOException {
        this.customers.add(customer);
        write();
    }

    public void deleteCustomer(int idCustomer) throws IOException {
        this.customers.remove(idCustomer);
        write();
    }

    public void editCustomer(int idCustomer, Customer customer) throws IOException {
        this.customers.set(idCustomer, customer);
        write();
    }

}
