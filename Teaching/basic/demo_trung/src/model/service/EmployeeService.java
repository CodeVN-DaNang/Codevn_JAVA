package model.service;

import java.util.ArrayList;

import model.entity.Employee;
import model.repository.EmployeeRepo;

public class EmployeeService {
    EmployeeRepo employeeRepo = new EmployeeRepo();

    public ArrayList<Employee> getEmployees(){
        return employeeRepo.getAllEmployees();
    }

    public Employee getEmployeeByName(String name){
        return employeeRepo.getEmployeeById(name);
    }

    public void addEmployee(Employee employee){
        employeeRepo.addEmployee(employee);
    }

    public void editEmployee(int index, Employee employee){
        employeeRepo.editEmployee(index, employee);
    }

    public void deleteEmployee(String name){
        ArrayList<Employee> employeeList = employeeRepo.getAllEmployees();
        for (int i = 0; i < employeeList.size(); i++) {
            if (employeeList.get(i).getName().equalsIgnoreCase(name)) {
                employeeRepo.deleteEmployee(i);
                i--;
            }
        }
    }
}
