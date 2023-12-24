/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import java.time.LocalDate;
import java.util.Date;

// ComparableExample
public class Student implements Comparable<Student> {
    
//    ****************************************
    @Override
    public int compareTo(Student student){
        // sort student's name by ASC
        return this.getName().compareTo(student.getName());
    }
    
}
