package model.service;

import java.util.ArrayList;

import model.entities.Employee;
import model.repo.EmployeeRepo;

public class EmployeeService {
    EmployeeRepo employeeRepo = new EmployeeRepo();

    public ArrayList<Employee> getAllEmployees() {
        return this.employeeRepo.getAllEmployees();
    }

    public Employee getEmployeeByUsername(String username) {
        return employeeRepo.getEmployeeByUsername(username);
    }

    public void addEmployee(Employee employee) {
        employeeRepo.addEmployee(employee);
    }

    public boolean deleteEmployee(String username) {
        for (Employee employee : employeeRepo.getAllEmployees()) {
            if (employee.getUsername().equals(username)) {
                employeeRepo.deleteEmployee(employee);
                return true;
            }
        }
        return false;
    }

    public boolean updateEmployee(Employee newEmployee) {
        int count = 0;
        for (Employee employee : employeeRepo.getAllEmployees()) {
            if (employee.getUsername().equals(newEmployee.getUsername())) {
                employeeRepo.updateemployee(count, employee);
                return true;
            }
            count++;
        }
        return false;
    }

    public ArrayList<Employee> searchEmployeeByPhone(String phone) {
        ArrayList<Employee> employeeList = new ArrayList<>();
        for (Employee employee : employeeRepo.getAllEmployees()) {
            if (employee.getPhone().equals(phone)) {
                employeeList.add(employee);
            }
        }
        return employeeList;
    }

    public boolean checkUniqueUsername(String username){
        for (Employee employee : employeeRepo.getAllEmployees()) {
            if (employee.getUsername().equals(username)) {
                return false;
            }
        }
        return true;
    }

}
