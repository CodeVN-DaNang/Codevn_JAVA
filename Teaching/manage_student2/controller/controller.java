package manage_student2.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import manage_student2.model.Student;

public class controller {
    public static void main(String[] args) {
        LocalDate localDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd LLLL yyyy");
        String importDate = localDate.format(formatter);
        System.out.println(importDate);
    }
}
