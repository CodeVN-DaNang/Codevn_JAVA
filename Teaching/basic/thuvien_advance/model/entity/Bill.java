package model.entity;

public class Bill {
    private int billId;
    private Customer borrowCustomer;
    private Document borrowDocument;
    private String dateBorrow;
    private String dateReturn;
    private double fees;
    private boolean status;

    public Bill(int billId, Customer borrowCustomer, Document borrowDocument, String dateBorrow, String dateReturn,
            double fees, boolean status) {
        this.billId = billId;
        this.borrowCustomer = borrowCustomer;
        this.borrowDocument = borrowDocument;
        this.dateBorrow = dateBorrow;
        this.dateReturn = dateReturn;
        this.fees = fees;
        this.status = status;
    }

    public Bill() {
    }

    public int getBillId() {
        return billId;
    }

    public void setBillId(int billId) {
        this.billId = billId;
    }

    public Customer getBorrowCustomer() {
        return borrowCustomer;
    }

    public void setBorrowCustomer(Customer borrowCustomer) {
        this.borrowCustomer = borrowCustomer;
    }

    public Document getBorrowDocument() {
        return borrowDocument;
    }

    public void setBorrowDocument(Document borrowDocument) {
        this.borrowDocument = borrowDocument;
    }

    public String getDateBorrow() {
        return dateBorrow;
    }

    public void setDateBorrow(String dateBorrow) {
        this.dateBorrow = dateBorrow;
    }

    public String getDateReturn() {
        return dateReturn;
    }

    public void setDateReturn(String dateReturn) {
        this.dateReturn = dateReturn;
    }

    public double getFees() {
        return fees;
    }

    public void setFees(double fees) {
        this.fees = fees;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Bill [billId=" + billId + ", borrowCustomer=" + borrowCustomer + ", borrowDocument=" + borrowDocument
                + ", dateBorrow=" + dateBorrow + ", dateReturn=" + dateReturn + ", fees=" + fees + ", status=" + status
                + "]";
    }
}
