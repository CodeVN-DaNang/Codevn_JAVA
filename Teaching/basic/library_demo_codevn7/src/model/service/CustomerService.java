package model.service;

import java.util.ArrayList;

import model.entities.Customer;
import model.entities.TypeCustomer;
import model.repo.CustomerRepo;
import model.repo.TypeCustomerRepo;

public class CustomerService {
    CustomerRepo customerRepo = new CustomerRepo();
    TypeCustomerRepo typeCustomerRepo = new TypeCustomerRepo();

    public ArrayList<Customer> getAllCustomers(){
        return this.customerRepo.getAllCustomers();
    }

    public ArrayList<TypeCustomer> getAllTypeCustomer(){
        return this.typeCustomerRepo.getAllCustomers();
    }

    public Customer getCustomerByUsername(String username){
        return this.customerRepo.getCustomerByUsername(username);
    }

    public ArrayList<Customer> searchCustomerByPhone(String phone){
        ArrayList<Customer> findCustomers = new ArrayList<>();
        for (Customer customer : customerRepo.getAllCustomers()) {
            if (customer.getPhone().contains(phone)) {
                findCustomers.add(customer);
            }
        }
        return findCustomers;
    }

    public void addCustomer(Customer customer){
        customerRepo.addCustomer(customer);
    }

    public boolean deleteCustomer(String username){
        for (Customer customer : customerRepo.getAllCustomers()) {
            if (customer.getUsername().equals(username)) {
                customerRepo.deleteCustomer(customer);
                return true;
            }
        }
        return false;
    }

    public boolean updateCustomer(Customer customer){
        int count = 0;
        for (Customer customer2 : customerRepo.getAllCustomers()) {
            if (customer2.getUsername().equals(customer.getUsername())) {
                customerRepo.updateCustomer(count, customer);
                return true;
            }
            count++;
        }
        return false;
    }

    public boolean checkUniqueUsername(String username){
        for (Customer customer : customerRepo.getAllCustomers()) {
            if (customer.getUsername().equals(username)) {
                return false;
            }
        }
        return true;
    }

    // public static void main(String[] args) {
    //     CustomerService customerService = new CustomerService();
    //     customerService.updateCustomer(new Customer("Anh", "anh123@gmail.com", "123456789", "trung123","trung123", new TypeCustomer("3", "cu")));
    //     for (Customer customer : customerService.getAllCustomers()) {
    //         System.out.println(customer.toString());
    //     }
    // }

}
