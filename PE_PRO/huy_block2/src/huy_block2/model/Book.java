/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package huy_block2.model;

/**
 *
 * @author vannhat
 */
public class Book {
    private String title;
    private String author;
    private String publishedYear;
    // gia de double
    private double unitPrice;
    private int quantity;

    public Book() {
    }

    public Book(String title, String author, String publishedYear, double unitPrice, int quantity) {
        this.title = title;
        this.author = author;
        this.publishedYear = publishedYear;
        this.unitPrice = unitPrice;
        this.quantity = quantity;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublishedYear() {
        return publishedYear;
    }

    public void setPublishedYear(String publishedYear) {
        this.publishedYear = publishedYear;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    public double calculateTotal(int buyQuantity){
        return buyQuantity * this.unitPrice;
    }
    
    public double calculateTransport(int buyQuantity){
        if (buyQuantity <= 50) {
            return 0;
        } else if (buyQuantity > 50 && buyQuantity <= 500) {
            return buyQuantity * unitPrice * 0.02;
        }
        return buyQuantity * unitPrice * 0.05;
    }
    @Override
    public String toString() {
        return "Book{" + "title=" + title + ", author=" + author + ", publishedYear=" + publishedYear + ", unitPrice=" + unitPrice + ", quantity=" + quantity + '}';
    }
    
}
