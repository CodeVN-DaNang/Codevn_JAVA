package model.service;

import java.util.ArrayList;

import model.entities.Customer;
import model.repo.CustomerRepo;

public class CustomerService {
    CustomerRepo customerRepo = new CustomerRepo();

    public ArrayList<Customer> getAll() {
        return customerRepo.getAll();
    }

    public Customer getById(int id) {
        return customerRepo.getById(id);
    }

    public void add(Customer customer) {
        customerRepo.add(customer);
    }

    public void delete(int id) {
        customerRepo.delete(id);
    }

    public void update(Customer customer) {
        customerRepo.update(customer);
    }
}
