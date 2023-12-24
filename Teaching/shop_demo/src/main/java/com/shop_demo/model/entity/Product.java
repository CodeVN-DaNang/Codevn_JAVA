package com.shop_demo.model.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Product")
public class Product {
    @Column(name = "idProduct")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int idProduct;

    @Column(name = "nameProduct")
    private String nameProduct;

    @Column(name = "price")
    private String price;
}
