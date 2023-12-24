/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.function.Predicate;
import model.Employee;

/**
 *
 * @author vannhat
 */
public class EmployeeManagement {
    
    ArrayList<Employee> employeeList = new ArrayList<>();
    
    public void readFile(){
        try{
            FileReader fr = new FileReader("src/data/employee.txt");
            BufferedReader br = new BufferedReader(fr);
            String line = "";
            while((line = br.readLine()) != null){
                String arr[] = line.split(",");
                String emId = arr[0];
                String account = arr[1];
                DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                LocalDate workStartingDate = LocalDate.parse(arr[2], format);
                float productivityScore = Float.parseFloat(arr[3]);
                int allowance = Integer.parseInt(arr[4]);
                Employee employee = new Employee(emId, account, workStartingDate, productivityScore, allowance);
                employeeList.add(employee);
            }
            fr.close();
        } catch (Exception e){
            System.out.println(e);
        }
    }
    
    public void writeFile(){
        try{
            FileWriter fw = new FileWriter("src/data/employee.txt");
            String line = "";
            for (Employee employee : employeeList) {
                line += employee.getEmId()+","+employee.getAccount()+employee.getWorkStartingDate().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) + ","+","+employee.getProductivityScore()+"," +employee.getAllowance()+"\n";
            }
            fw.write(line);
            fw.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public void printList(ArrayList<Employee> eList){
        for (Employee employee : eList) {
            System.out.println(employee.toString());
        }
    }
    
    public void getAllEmployee(){
        if (employeeList.isEmpty()) {
            readFile();
        }
        printList(employeeList);
    }
    
    public void search(Predicate<Employee> p){
        ArrayList<Employee> findEmployee = new ArrayList<>();
        for (Employee employee : employeeList) {
            if (p.test(employee)) {
                findEmployee.add(employee);
            }
        }
        printList(findEmployee);
    }
    
    public void sortEmployee(){
       Collections.sort(employeeList);
       printList(employeeList);
    }
    
    public void calculateMoney(){
        for (Employee employee : employeeList) {
            employee.calMonthlyIncome();
        }
        printList(employeeList);
    }
    
}
