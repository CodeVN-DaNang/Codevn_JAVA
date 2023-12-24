package model.repo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

import model.entities.Customer;
import model.entities.TypeCustomer;

public class CustomerRepo {
    ArrayList<Customer> customerList = new ArrayList<>();
    TypeCustomerRepo typeCustomerRepo = new TypeCustomerRepo();

    public void read() {
        customerList.clear();
        try {
            FileReader fr = new FileReader("/Users/vannhat/Documents/NHATTV_JAVA/teaching/basic/library_demo_codevn7/src/data/Customer.txt");
            BufferedReader br = new BufferedReader(fr);
            String line;
            while ((line = br.readLine()) != null) {
                String arr[] = line.split(",");
                String name = arr[0].trim();
                String email = arr[1].trim();
                String phone = arr[2].trim();
                String userName = arr[3].trim();
                String passWorld = arr[4].trim();
                TypeCustomer typeCustomer = typeCustomerRepo.getTypeCustomerById(arr[5].trim());
                Customer customer = new Customer(name, email, phone, userName, passWorld, typeCustomer);
                customerList.add(customer);
            }
            fr.close();
            br.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void write() {
        try {
            FileWriter fw = new FileWriter("/Users/vannhat/Documents/NHATTV_JAVA/teaching/basic/library_demo_codevn7/src/data/Customer.txt");
            String line = "";
            for (Customer customer : customerList) {
                line += customer.getName() + "," + customer.getEmail() + "," + customer.getPhone() + ","
                        + customer.getUsername() + "," + customer.getPassword() + "," + customer.getTypeCustomer().getTypeCustomerId() + "\n";
            }
            fw.write(line);
            fw.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public ArrayList<Customer> getAllCustomers(){
        read();
        return this.customerList;
    }

    public Customer getCustomerByUsername(String username){
        read();
        for (Customer customer : customerList) {
            if (customer.getUsername().equals(username)) {
                return customer;
            }
        }
        return null;
    }

    public void addCustomer(Customer customer){
        customerList.add(customer);
        write();
    }

    public void deleteCustomer(Customer customer){
        customerList.remove(customer);
        write();
    }

    public void updateCustomer(int index, Customer customer){
        customerList.set(index, customer);
        write();
    }

}
