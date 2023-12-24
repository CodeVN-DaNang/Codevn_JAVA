package model.repo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

import model.entity.Customer;
import model.entity.TypeCustomer;

public class CustomerRepo {

    TypeCustomerRepo typeCustomerRepo = new TypeCustomerRepo();

    ArrayList<Customer> customerList = new ArrayList<>();

    public void readTxt() {
        try {
            FileReader fr = new FileReader("/data/Customer.txt");
            BufferedReader br = new BufferedReader(fr);
            String line = "";
            while ((line = br.readLine()) != null) {
                int customerId = Integer.parseInt(line.split(",")[0]);
                String name = line.split(",")[1];
                String email = line.split(",")[2];
                String phone = line.split(",")[3];
                String username = line.split(",")[4];
                String password = line.split(",")[5];
                TypeCustomer typeCustomer = typeCustomerRepo.getTypeCustomerById(Integer.parseInt(line.split(",")[6]));
                Customer customer = new Customer(customerId, name, email, phone, username, password, typeCustomer);
                customerList.add(customer);
            }
            br.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void writeTxt() {
        try {
            FileWriter fw = new FileWriter("/data/Customer.txt");
            String line = "";
            for (Customer customer : customerList) {
                line = line + customer.getCustomerId() + "," + customer.getName() + "," + customer.getEmail() + ","
                        + customer.getPhone() + "," + customer.getUsername() + "," + customer.getPassword() + ","
                        + customer.getTypeCustomer().getTypeCustomerId() + "\n";
            }
            fw.write(line);
            fw.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public ArrayList<Customer> getAllCustomer(){
        readTxt();
        return customerList;
    }

    public Customer getCustomerById(int id) {
        readTxt();
        for (Customer customer : customerList) {
            if (customer.getCustomerId() == id) {
                return customer;
            }
        }
        return null;
    }

    public void addCustomer(Customer customer){
        customerList.add(customer);
    }

    public void deleteCustomer(int id){
        for (Customer customer : customerList) {
            if (customer.getCustomerId() == id) {
                customerList.remove(customer);
            }
        }
    }

    public void editCustomer(int index, Customer customer){
        customerList.set(index, customer);
    }

}
