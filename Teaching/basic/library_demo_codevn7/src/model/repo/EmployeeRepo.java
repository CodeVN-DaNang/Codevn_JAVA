package model.repo;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

import model.entities.Employee;

public class EmployeeRepo {
    ArrayList<Employee> employeeList = new ArrayList<>();

    public void read() {
        employeeList.clear();
        try {
            FileReader fr = new FileReader("/Users/vannhat/Documents/NHATTV_JAVA/teaching/basic/library_demo_codevn7/src/data/Employee.txt");
            BufferedReader br = new BufferedReader(fr);
            String line;
            while ((line = br.readLine()) != null) {
                String arr[] = line.split(",");
                String name = arr[0].trim();
                String email = arr[1].trim();
                String phone = arr[2].trim();
                String userName = arr[3].trim();
                String passWorld = arr[4].trim();
                Employee employee = new Employee(name, email, phone, userName, passWorld);
                employeeList.add(employee);
            }
            fr.close();
            br.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void write() {
        try {
            FileWriter fw = new FileWriter("/Users/vannhat/Documents/NHATTV_JAVA/teaching/basic/library_demo_codevn7/src/data/Employee.txt");
            String line = "";
            for (Employee employee : employeeList) {
                line += employee.getName() + "," + employee.getEmail() + "," + employee.getPhone() + ","
                        + employee.getUsername() + "," + employee.getPassword() + "\n";
            }
            fw.write(line);
            fw.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public ArrayList<Employee> getAllEmployees(){
        read();
        return this.employeeList;
    }

    public Employee getEmployeeByUsername(String username){
        read();
        for (Employee employee : employeeList) {
            if (employee.getUsername().equals(username)) {
                return employee;
            }
        }
        return null;
    }

    public void addEmployee(Employee employee){
        employeeList.add(employee);
        write();
    }

    public void deleteEmployee(Employee employee){
        employeeList.remove(employee);
        write();
    }

    public void updateemployee(int index, Employee employee){
        employeeList.set(index, employee);
        write();
    }

}
