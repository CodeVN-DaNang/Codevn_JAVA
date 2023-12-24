package model.service;

import java.util.ArrayList;

import model.entity.Employee;
import model.repository.EmployeeRepository;

public class EmployeeService {
    EmployeeRepository employeeRepository = new EmployeeRepository();

    public ArrayList<Employee> getAllEmployee(){
        if (employeeRepository.getAllEmployee().isEmpty()) {
            return null;
        }
        return employeeRepository.getAllEmployee();
    }

    public Employee getEmployeeById(int id){
        return employeeRepository.getEmployeeById(id);
    }

    public void addEmployee(Employee employee){
        if (checkEmailUnique(employee)) {
            employeeRepository.addEmployee(employee);
        }
    }

    public void deleteEmployee(int id){
        employeeRepository.deleteEmployee(id);
    }

    public void updateEmployee(Employee employee){
        employeeRepository.updateEmployee(employee);
    }

    private boolean checkEmailUnique(Employee employee){
        for (Employee employee2 : employeeRepository.getAllEmployee()) {
            if (employee.getEmail().equals(employee2.getEmail())) {
                return false;
            }
        }
        return true;
    }

    public ArrayList<Employee> searchEmployees(String name){
        ArrayList<Employee> findEmployees = new ArrayList<>();
        for (Employee employee : employeeRepository.getAllEmployee()) {
            if (employee.getName().contains(name)) {
                findEmployees.add(employee);
            }
        }
        return findEmployees;
    }

}
