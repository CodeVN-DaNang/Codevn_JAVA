package model.repository;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

import model.entity.Employee;

public class EmployeeRepository {
    ArrayList<Employee> employeeList = new ArrayList<>();

    public void read(){
        employeeList.clear();
        try {
            FileReader fr = new FileReader("/Users/vannhat/Documents/NHATTV_JAVA/teaching/basic/demo_codevn7/src/data/employee.txt");
            BufferedReader br = new BufferedReader(fr);
            String line;
            while ((line = br.readLine()) != null) {
                String arr[] = line.split(",");
                int id = Integer.parseInt(arr[0].trim());
                String name = arr[1].trim();
                String email = arr[2].trim();
                String phone = arr[3].trim();
                Employee employee = new Employee(id, name, email, phone);
                employeeList.add(employee);
            }
            br.close();
            fr.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void write(){
        try {
            FileWriter fw = new FileWriter("/Users/vannhat/Documents/NHATTV_JAVA/teaching/basic/demo_codevn7/src/data/employee.txt");
            String line = "";
            for (Employee employee : employeeList) {
                line += employee.getId() + "," + employee.getName() + "," + employee.getEmail() + "," + employee.getPhone() +"\n";
            }
            fw.write(line);
            fw.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public ArrayList<Employee> getAllEmployee(){
        read();
        return employeeList;
    }

    public Employee getEmployeeById(int id){
        read();
        for (Employee employee : employeeList) {
            if (employee.getId() == id) {
                return employee;
            }
        }
        return null;
    }

    public void addEmployee(Employee employee){
        employeeList.add(employee);
        write();
    }

    public void deleteEmployee(int id){
        for (Employee employee : employeeList) {
            if (employee.getId() == id) {
                employeeList.remove(employee);
            }
        }
        write();
    }

    public void updateEmployee(Employee employee){
        int count = 0;
        for (Employee employee1 : employeeList) {
            if (employee.getId() == employee1.getId()) {
                employeeList.set(count, employee);
            }
            count++;
        }
        write();
    }

}
