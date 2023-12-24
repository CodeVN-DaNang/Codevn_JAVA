package com.shop_demo.model.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "OrderBill")
public class OrderBill {
    @Column(name = "idOrder")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int idOrder;

    @Column(name = "idProduct")
    @ManyToMany()
}
