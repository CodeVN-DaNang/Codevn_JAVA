/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.function.Predicate;
import model.Book;

public class Library {

    ArrayList<Book> bookList = new ArrayList<>();
    Scanner sc = new Scanner(System.in);

    //+ Read text file to load data for Library – lib.txt is provided (1 mark)
    public void readFile() {
        bookList.clear();
        try {
            FileReader fr = new FileReader("src/data/lib.txt");
            BufferedReader br = new BufferedReader(fr);
            String mainLine = null;
            while ((mainLine = br.readLine()) != null) {
                String arr[] = mainLine.split("-");
                br.readLine();
                String bookId = arr[0];
                
                String bookTitle = arr[1];
                
                String bookAuthor = arr[2];
                
                String bookYear = arr[3];
                
                Book book = new Book(bookId, bookTitle, bookAuthor, Integer.parseInt(bookYear));
                bookList.add(book);
            }
            fr.close();
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    // write file
    public void writeFile() {
        try {
            FileWriter fw = new FileWriter("src/data/lib.txt");
            String line = "";
            for (Book book : bookList) {
                line += book.getBookId() + "-" + book.getBookTitle() + "-" + book.getAuthor() + "-" + book.getYearPublished() + "\n\n";
            }
            fw.write(line);
            fw.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    //    List of Book
    public void getAllBooks() {
        if (bookList.isEmpty()) {
            readFile();
        }
        printList(bookList);
    }

    // Print any List of Book (1 mark)
    public void printList(ArrayList<Book> bList) {
        System.out.println("List of books:");
        System.out.println("-----------------------------------------------------------");
        for (Book book : bList) {
            System.out.println("Book{" + book.getBookId() + " - " + book.getBookTitle() + " - " + book.getAuthor() + " - " + book.getYearPublished() + "}");
        }
        System.out.println("-----------------------------------------------------------");
        System.out.println("Total: " + bList.size());
    }

    //+ Add new Book from console (1 mark)
    public void addNewBook() {
        String bookId = "";
        while (!Validator.checkValid(Validator.patternId, bookId)) {
            System.out.println("Input book id like 'B0000':");
            bookId = sc.nextLine();
        }
        String bookTitle = "";
        while (!Validator.checkValid(Validator.patternName, bookTitle)) {
            System.out.println("Input book name like 'Java Pro':");
            bookTitle = sc.nextLine();
        }
        String author = "";
        while (!Validator.checkValid(Validator.patternAuthorName, author)) {
            System.out.println("Input book author id like 'James Gosling':");
            author = sc.nextLine();
        }
        String yearInput = "";
        while (!Validator.checkValid(Validator.patternYear, yearInput)) {
            System.out.println("Input year publish like '1980':");
            yearInput = sc.nextLine();
        }
        int yearPublish = Integer.parseInt(yearInput);
        Book book = new Book(bookId, bookTitle, author, yearPublish);
        bookList.add(book);
    }

    //+ Search book by different criteria (1 mark)
    public void searchBook(Predicate<Book> p) {
        ArrayList<Book> findBooks = new ArrayList<>();
        for (Book book : bookList) {
            if (p.test(book)) {
                findBooks.add(book);
            }
        }
        printList(findBooks);
    }

}
