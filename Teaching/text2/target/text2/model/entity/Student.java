package com.example.model.entity;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Student {
    private int idStudent;
    private String nameStudent;
    private String email;
    private String phone;
    private double mark;
}
