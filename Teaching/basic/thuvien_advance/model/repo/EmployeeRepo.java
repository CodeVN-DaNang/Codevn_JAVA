package model.repo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

import model.entity.Employee;

public class EmployeeRepo {
    ArrayList<Employee> employeeList = new ArrayList<>();

        public void readTxt() {
        try {
            FileReader fr = new FileReader("/data/Employee.txt");
            BufferedReader br = new BufferedReader(fr);
            String line = "";
            while ((line = br.readLine()) != null) {
                int employeeId = Integer.parseInt(line.split(",")[0]);
                String name = line.split(",")[1];
                String email = line.split(",")[2];
                String phone = line.split(",")[3];
                String username = line.split(",")[4];
                String password = line.split(",")[5];
                Employee employee = new Employee(employeeId, name, email, phone, username, password);
                employeeList.add(employee);
            }
            br.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void writeTxt() {
        try {
            FileWriter fw = new FileWriter("/data/Employee.txt");
            String line = "";
            for (Employee employee : employeeList) {
                line = line + employee.getEmployeeId() + "," + employee.getEmployeeName() + "," + employee.getEmail() + ","
                        + employee.getPhoneNumber() + "," + employee.getUsername() + "," + employee.getPassword() + ","
                        +"\n";
            }
            fw.write(line);
            fw.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public ArrayList<Employee> getAllemployee(){
        readTxt();
        return employeeList;
    }

    public Employee getemployeeById(int id) {
        readTxt();
        for (Employee employee : employeeList) {
            if (employee.getEmployeeId() == id) {
                return employee;
            }
        }
        return null;
    }

    public void addemployee(Employee employee){
        employeeList.add(employee);
    }

    public void deleteemployee(int id){
        for (Employee employee : employeeList) {
            if (employee.getEmployeeId() == id) {
                employeeList.remove(employee);
            }
        }
    }

    public void editemployee(int index, Employee employee){
        employeeList.set(index, employee);
    }
}
