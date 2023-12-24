package model.service;

import model.entities.Customer;
import model.entities.Employee;

public class MainService {
    CustomerService customerService = new CustomerService();
    EmployeeService employeeService = new EmployeeService();

    public String login(String username, String password){
        for (Customer customer : customerService.getAllCustomers()) {
            if (username.equals(customer.getUsername())) {
                if (password.equals(customer.getPassword())) {
                    return customer.toString();
                }
            }
        }
        for (Employee employee : employeeService.getAllEmployees()) {
            if (username.equals(employee.getUsername())) {
                if (password.equals(employee.getPassword())) {
                    return employee.toString();
                }
            }
        }
        return null;
    }

}
