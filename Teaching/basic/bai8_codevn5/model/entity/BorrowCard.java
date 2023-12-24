package model.entity;

public class BorrowCard {
    private String id;
    private String borrowDate;
    private String dateExp;
    private String bookId;
    private Student student;
    // 1,2,3,4,5,7,

    public BorrowCard(String id, String borrowDate, String dateExp, String bookId, Student student) {
        this.id = id;
        this.borrowDate = borrowDate;
        this.dateExp = dateExp;
        this.bookId = bookId;
        this.student = student;
    }

    public BorrowCard() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(String borrowDate) {
        this.borrowDate = borrowDate;
    }

    public String getDateExp() {
        return dateExp;
    }

    public void setDateExp(String dateExp) {
        this.dateExp = dateExp;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "BorrowCard [id=" + id + ", borrowDate=" + borrowDate + ", dateExp=" + dateExp + ", bookId=" + bookId
                + ", student=" + student + "]";
    }

}
