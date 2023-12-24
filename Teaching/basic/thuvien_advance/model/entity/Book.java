package model.entity;

public class Book extends Document {
    private String author;
    private int numberPage;

    public Book(String documentId, String publisher, int numberPublish, String author, int numberPage) {
        super(documentId, publisher, numberPublish);
        this.author = author;
        this.numberPage = numberPage;
    }

    public Book(String author, int numberPage) {
        this.author = author;
        this.numberPage = numberPage;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getNumberPage() {
        return numberPage;
    }

    public void setNumberPage(int numberPage) {
        this.numberPage = numberPage;
    }

    @Override
    public String toString() {
        return "Book [author=" + author + ", numberPage=" + numberPage + "]";
    }
}
