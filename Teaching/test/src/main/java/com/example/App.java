package com.example;

import com.example.model.entity.Student;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Student student = new Student(1, "Vinh", "Vinh123@gmail.com", "0912345678", 9.0);
        System.out.println(student.toString());
    }
}
