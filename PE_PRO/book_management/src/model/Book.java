/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

public class Book implements Comparable<Book>{
    private String bookId;
    private String bookTitle;
    private String author;
    private int yearPublished;

    public Book(String bookId, String bookTitle, String author, int yearPublished) {
        this.bookId = bookId;
        this.bookTitle = bookTitle;
        this.author = author;
        this.yearPublished = yearPublished;
    }

    public Book() {
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYearPublished() {
        return yearPublished;
    }

    public void setYearPublished(int yearPublished) {
        this.yearPublished = yearPublished;
    }

    @Override
    public String toString() {
        return "Book{" + "bookId=" + bookId + ", bookTitle=" + bookTitle + ", author=" + author + ", yearPublished=" + yearPublished + '}';
    }

    @Override
    public int compareTo(Book book) {
        return book.getYearPublished() - this.getYearPublished();
    }
    
}
