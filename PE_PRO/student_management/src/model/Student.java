/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.time.LocalDate;
import java.util.Date;

/**
 *
 * @author vannhat
 */
public class Student implements Comparable<Student> {
    // StudentID, First name, Last Name, Date of birth, Gender  
    private String studentId;
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private String gender;

    public Student(String studentId, String firstName, String lastName, LocalDate dateOfBirth, String gender) {
        this.studentId = studentId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
    }

    public Student() {
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Student{" + "studentId=" + studentId + ", firstName=" + firstName + ", lastName=" + lastName + ", dateOfBirth=" + dateOfBirth.toString() + ", gender=" + gender + '}';
    }
    
    @Override
    public int compareTo(Student student){
        // sort student's name by ASC
        return this.getFirstName().compareTo(student.getFirstName());
    }
    
}
