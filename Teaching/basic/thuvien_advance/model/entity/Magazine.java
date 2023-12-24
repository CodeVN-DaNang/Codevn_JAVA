package model.entity;

public class Magazine extends Document {
    private int issueNumber;
    private String issueDate;

    public Magazine(String documentId, String publisher, int numberPublish, int issueNumber, String issueDate) {
        super(documentId, publisher, numberPublish);
        this.issueNumber = issueNumber;
        this.issueDate = issueDate;
    }

    public Magazine(int issueNumber, String issueDate) {
        this.issueNumber = issueNumber;
        this.issueDate = issueDate;
    }

    public int getIssueNumber() {
        return issueNumber;
    }

    public void setIssueNumber(int issueNumber) {
        this.issueNumber = issueNumber;
    }

    public String getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(String issueDate) {
        this.issueDate = issueDate;
    }

    @Override
    public String toString() {
        return "Magazine [issueNumber=" + issueNumber + ", issueDate=" + issueDate + "]";
    }
}
