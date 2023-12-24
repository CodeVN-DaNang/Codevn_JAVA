/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package huy_block2.controller;

import huy_block2.model.Book;
import huy_block2.model.BookArray;
import huy_block2.view.Menu;
import java.util.Scanner;

/**
 *
 * @author vannhat
 */
public class LibraryController extends Menu<Book> {
    BookArray bArr = new BookArray(10);
    Scanner sc = new Scanner(System.in);
    
    public LibraryController(String td, String[] mc) {
        super(td, mc);
    }
    
    public void getAll(){
        for (int i = 0; i < bArr.getAll().length; i++) {
            System.out.println(bArr.getAll()[i]);
        }
    }
    
    public void addBook(){
        System.out.println("Input title");
        String title = sc.nextLine();
        System.out.println("Input author");
        String author = sc.nextLine();
        System.out.println("Input published year");
        String publishedYear = sc.nextLine();
        System.out.println("Input unit price");
        double unitPrice = Double.parseDouble(sc.nextLine());
        System.out.println("Input quantity");
        int quantity = Integer.parseInt(sc.nextLine());
        Book book = new Book(title, author, publishedYear, unitPrice, quantity);
        bArr.addBook(book);
    }
    
    public void calculateTotalMoney(){
        System.out.println("Input title to buy:");
        String title = sc.nextLine();
        Book book = new Book();
        for (int i = 0; i < bArr.getAll().length; i++) {
            if (bArr.getAll()[i].getTitle().equals(title)) {
                book = bArr.getAll()[i];
                break;
            }
        }
        System.out.println("Input quantity to buy");
        int buyQuantity = Integer.parseInt(sc.nextLine());
        System.out.println("Total money: " + bArr.calculateTotalMoney(buyQuantity, book));
    }
    
    public void deleteBookByCode(){
        System.out.println("Input title to buy:");
        String title = sc.nextLine();
        bArr.deleteBookByCode(title);
    }
    
    public void findBookByCode(){
        System.out.println("Input title to buy:");
        String title = sc.nextLine();
        bArr.findBookByCode(title);
    }
    
    public void findBookLargestQuantity(){
        System.out.println(bArr.findBookLargestQuantity().toString());
    }
    
    public static void main(String[] args) {
        String mChon[] = {"list all books", "add new book", "buy book", "delete book", "find book by code", "find book largest quantity"};
        LibraryController lc = new LibraryController("MENU", mChon);
        lc.run();
    }
    
    @Override
    public void execute(int n){
        switch (n) {
            case 1:
                getAll();
                break;
            case 2:
                addBook();
                break;
            case 3:
                calculateTotalMoney();
                break;
            case 4:
                deleteBookByCode();
                break;
            case 5:
                findBookByCode();
                break;
            case 6:
                findBookLargestQuantity();
                break;
            case 7:
                System.exit(0);
            default:
                break;
        }
    }
    
}
