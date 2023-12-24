package model.repo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

import model.entities.Customer;

public class CustomerRepo {
    ArrayList<Customer> customerList = new ArrayList<>();

    void read() {
        customerList.clear();
        try {
            FileReader fr = new FileReader(
                    "/Users/vannhat/Documents/NHATTV_JAVA/teaching/basic/bai9_codevn7/src/data/Customer.txt");
            BufferedReader br = new BufferedReader(fr);
            String line = "";
            while ((line = br.readLine()) != null) {
                String[] arr = line.split(",");
                String customerName = arr[0];
                String customerNum = arr[1];
                String customerCode = arr[2];
                Customer customer = new Customer(customerName, customerNum, customerCode);
                customerList.add(customer);
            }
            br.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    void write() {
        try {
            FileWriter fw = new FileWriter(
                    "/Users/vannhat/Documents/NHATTV_JAVA/teaching/basic/bai9_codevn7/src/data/Customer.txt");
            String line = "";
            for (Customer customer : customerList) {
                line = line + customer.getCustomerName() + "," + customer.getCustomerNum() + ","
                        + customer.getCustomerCode() + "\n";
            }
            fw.write(line);
            fw.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public ArrayList<Customer> getAllCustomers(){
        read();
        return customerList;
    }

    public Customer getCustomerByCode(String code){
        read();
        for (Customer customer : customerList) {
            if (customer.getCustomerCode().equalsIgnoreCase(code)) {
                return customer;
            }
        }
        return null;
    }

}
