package model.repository;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

import model.entity.Employee;
import model.entity.Engineer;
import model.entity.Staff;
import model.entity.Worker;

public class EmployeeRepo {
    ArrayList<Employee> employeeList = new ArrayList<>();

    public void read(){
        employeeList.clear();
        try {
            FileReader fr = new FileReader("./src/data/Employee.txt");
            BufferedReader br = new BufferedReader(fr);
            String line = null;
            while ((line = br.readLine()) != null) {
                String arr[] = line.split(",");
                String name = arr[1];
                int age = Integer.parseInt(arr[2]);
                String gender = arr[3];
                String address = arr[4];
                Employee employee = new Employee();
                if (arr[0].equals("Staff")) {
                    String job = arr[5];
                    employee = new Staff(name, age, gender, address, job);
                } else if (arr[0].equals("Worker")) {
                    int level = Integer.parseInt(arr[5]);
                    employee = new Worker(name, age, gender, address, level);
                } else if (arr[0].equals("Engineer")) {
                    String major = arr[5];
                    employee = new Engineer(name, age, gender, address, major);
                }
                employeeList.add(employee);  
            }
            br.close();
        } catch (Exception e) {
            System.out.println("hello trung");
        }
    }

    public void write(){
        try {
            FileWriter fw = new FileWriter("/Users/vannhat/Documents/NHATTV_JAVA/teaching/basic/demo_trung/src/data/Employee.txt");
            String line = "";
            for (Employee employee : employeeList) {
                if (employee.toString().contains("Staff")) {
                    String job = employee.toString().split("]")[1].split("=")[1];
                    line += "Staff," + employee.getName() + "," + employee.getAge() + "," + employee.getGender() + "," + employee.getAddress() + "," + job + "\n";
                }else if (employee.toString().contains("Worker")) {
                    int level = Integer.parseInt(employee.toString().split("]")[1].split("=")[1]);
                    line += "Worker," + employee.getName() + "," + employee.getAge() + "," + employee.getGender() + "," + employee.getAddress() + "," + level + "\n";
                } else if (employee.toString().contains("Engineer")) {
                    String major = employee.toString().split("]")[1].split("=")[1];
                    line += "Engineer," + employee.getName() + "," + employee.getAge() + "," + employee.getGender() + "," + employee.getAddress() + "," + major + "\n";
                }
            }
            fw.write(line);
            fw.close();
        } catch (Exception e) {
            System.out.println("Hello Trung123");
        }
    }

    public ArrayList<Employee> getAllEmployees(){
        read();
        return employeeList;
    }

    public Employee getEmployeeById(String name){
        for (Employee employee : employeeList) {
            if (employee.getName().contains(name)) {
                return employee;
            }
        }
        return null;
    }

    public void addEmployee(Employee employee){
        employeeList.add(employee);
        write();
    }

    public void editEmployee(int index, Employee employee){
        employeeList.set(index, employee);
        write();
    }

    public void deleteEmployee(int index){
        employeeList.remove(index);
        write();
    }



}
