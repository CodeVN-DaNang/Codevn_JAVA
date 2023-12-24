/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package huy_block2.model;

/**
 *
 * @author vannhat
 */
public class BookArray {
    int n;
    Book[] bookArr;

    public BookArray(int n) {
        this.n = n;
        this.bookArr = new Book[n];
    }
    
    public Book[] getAll(){
        return this.bookArr;
    }
    
    public boolean addBook(Book book){
        if (bookArr == null) {
            return false;
        }
        for (int i = 0; i < bookArr.length; i++) {
            if (bookArr[i] == null) {
                bookArr[i] = book; // [b1,b2,book,b4,b5]
                System.out.println("Add success...");
                return true;
            }
            
        }
        System.out.println("Add failed...");
        return false;
    }
    
    public double calculateTotalMoney(int buyQuantity, Book book){
        if (buyQuantity > book.getQuantity()) {
            System.out.println("Can not buy more quantity of book");
            return 0;
        }
        book.setQuantity(book.getQuantity() - buyQuantity);
        return book.calculateTotal(buyQuantity) + book.calculateTransport(buyQuantity);
    }
    
    public boolean deleteBookByCode(String title){
        Boolean flag = false;
        for (int i = 0; i < bookArr.length; i++) {
            if (bookArr[i].getTitle().equals(title)) {
                bookArr[i] = bookArr[i+1];
                flag = true; //[b1,b2,b3,b4,b5] -> [b1,b3,b4,b5,null]
                continue;
            }
            if (flag && i < bookArr.length-1) {
                bookArr[i] = bookArr[i+1];
            } 
            if (flag && i == bookArr.length-1) {
                bookArr[i] = null;
            }
        }
        return flag;
    }
    
    public void findBookByCode(String title){
        for (int i = 0; i < bookArr.length; i++) {
            if (bookArr[i].getTitle().contains(title)) {
                System.out.println(bookArr[i].toString());
            }
        }
    }
    
    public Book findBookLargestQuantity(){
        int max = bookArr[0].getQuantity();
        Book book = bookArr[0];
        for (int i = 0; i < bookArr.length; i++) {
            if (max < bookArr[i].getQuantity()) {
                book = bookArr[i];
            }
        }
        return book;
    }
    
}
