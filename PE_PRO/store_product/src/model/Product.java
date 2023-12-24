/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author vannhat
 */
public class Product {
    // ProductID, Name, Rate, IDcategory
    private String productId;
    private String name;
    private String rate;
    private String idCategory;

    public Product(String productId, String name, String rate, String idCategory) {
        this.productId = productId;
        this.name = name;
        this.rate = rate;
        this.idCategory = idCategory;
    }

    public Product() {
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public String getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(String idCategory) {
        this.idCategory = idCategory;
    }

    @Override
    public String toString() {
        return "Product{" + "productId=" + productId + ", name=" + name + ", rate=" + rate + ", idCategory=" + idCategory + '}';
    }
    
    
    
}
