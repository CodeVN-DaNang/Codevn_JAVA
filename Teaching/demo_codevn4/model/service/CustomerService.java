package model.service;

import java.io.IOException;
import java.util.ArrayList;

import model.entity.Customer;
import model.entity.TypeCustomer;
import model.repository.CustomerRepository;
import model.repository.TypeCustomerRepository;

public class CustomerService {
    CustomerRepository customerRepository = new CustomerRepository();
    TypeCustomerRepository typeCustomerRepository = new TypeCustomerRepository();

    public ArrayList<TypeCustomer> getAllTypeCustomers() throws IOException {
        return typeCustomerRepository.getAllTypeCustomer();
    }

    public TypeCustomer getTypeCustomerById(int idTypeCustomer) throws IOException {
        return typeCustomerRepository.getTypeCustomerById(idTypeCustomer);
    }

    public ArrayList<Customer> getAllCustomer() throws IOException {
        return customerRepository.getAllCustomer();
    }

    public Customer getCustomerById(int idCustomer) {
        return customerRepository.getCustomerById(idCustomer);
    }

    public void addCustomer(Customer customer) throws IOException {
        customerRepository.addCustomer(customer);
    }

    public void deleteCustomer(int idCustomer) throws IOException {
        customerRepository.deleteCustomer(idCustomer);
    }

    public void editCustomer(int idCustomer, Customer customer) throws IOException {
        customerRepository.editCustomer(idCustomer, customer);
    }
}
