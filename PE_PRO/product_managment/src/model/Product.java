/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.time.LocalDate;

/**
 *
 * @author vannhat
 */
public class Product {
//    Define class Product with following attributes and methods:  (2 marks)
//+ ProductID, Product Name, UnitPrice, Quantity, Version, ProductManufacturingDate
//+ Constructors, get/set(), toString(), equals()
//+ implement method for Comparable
    private String productId;
    private String productName;
    private int unitPrice;
    private int quantity;
    private String version;
    private LocalDate  productManufactureDate;

    public Product(String productId, String productName, int unitPrice, int quantity, String version, LocalDate productManufactureDate) {
        this.productId = productId;
        this.productName = productName;
        this.unitPrice = unitPrice;
        this.quantity = quantity;
        this.version = version;
        this.productManufactureDate = productManufactureDate;
    }

    public Product() {
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(int unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public LocalDate getProductManufactureDate() {
        return productManufactureDate;
    }

    public void setProductManufactureDate(LocalDate productManufactureDate) {
        this.productManufactureDate = productManufactureDate;
    }

    @Override
    public String toString() {
        return "Product{" + "productId=" + productId + ", productName=" + productName + ", unitPrice=" + unitPrice + ", quantity=" + quantity + ", version=" + version + ", productManufactureDate=" + productManufactureDate + '}';
    }
    
    

}
