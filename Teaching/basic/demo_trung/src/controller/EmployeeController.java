package controller;

import model.entity.Employee;
import model.entity.Staff;
import model.service.EmployeeService;

public class EmployeeController {
    public static void main(String[] args) {
        EmployeeService employeeService = new EmployeeService();
        employeeService.getEmployees();
        employeeService.deleteEmployee("Tai");
        for (Employee employee : employeeService.getEmployees()) {
            System.out.println(employee);
        }
    }
}
