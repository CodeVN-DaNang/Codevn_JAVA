package com.shop_demo.model.entity;


import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "User")
public class User {
    @Column(name = "idUser")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int idUser;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;
}
