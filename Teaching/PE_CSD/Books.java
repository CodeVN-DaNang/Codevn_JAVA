/**
 * Books
 */
public class Books implements Comparable<Books> {
    private String isbn;
    private String bookTitle;
    private String bookAuthor;
    private String yearOfPublication;
    private String publisher;
    private String imgUrlS;
    private String imgUrlM;
    private String imgUrlL;
    public Books(String isbn, String bookTitle, String bookAuthor, String yearOfPublication, String publisher,
            String imgUrlS, String imgUrlM, String imgUrlL) {
        this.isbn = isbn;
        this.bookTitle = bookTitle;
        this.bookAuthor = bookAuthor;
        this.yearOfPublication = yearOfPublication;
        this.publisher = publisher;
        this.imgUrlS = imgUrlS;
        this.imgUrlM = imgUrlM;
        this.imgUrlL = imgUrlL;
    }
    public Books() {
    }
    public String getIsbn() {
        return isbn;
    }
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    public String getBookTitle() {
        return bookTitle;
    }
    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }
    public String getBookAuthor() {
        return bookAuthor;
    }
    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }
    public String getYearOfPublication() {
        return yearOfPublication;
    }
    public void setYearOfPublication(String yearOfPublication) {
        this.yearOfPublication = yearOfPublication;
    }
    public String getPublisher() {
        return publisher;
    }
    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }
    public String getImgUrlS() {
        return imgUrlS;
    }
    public void setImgUrlS(String imgUrlS) {
        this.imgUrlS = imgUrlS;
    }
    public String getImgUrlM() {
        return imgUrlM;
    }
    public void setImgUrlM(String imgUrlM) {
        this.imgUrlM = imgUrlM;
    }
    public String getImgUrlL() {
        return imgUrlL;
    }
    public void setImgUrlL(String imgUrlL) {
        this.imgUrlL = imgUrlL;
    }
    @Override
    public String toString() {
        return "Books [isbn=" + isbn + ", bookTitle=" + bookTitle + ", bookAuthor=" + bookAuthor
                + ", yearOfPublication=" + yearOfPublication + ", publisher=" + publisher + ", imgUrlS=" + imgUrlS
                + ", imgUrlM=" + imgUrlM + ", imgUrlL=" + imgUrlL + "]";
    }
    @Override
    public int compareTo(Books o) {
        return this.isbn.compareTo(o.getIsbn());
    }

    

}