package model.entity;

public class Paper extends Document {
    private String issueDate;

    public Paper(String documentId, String publisher, int numberPublish, String issueDate) {
        super(documentId, publisher, numberPublish);
        this.issueDate = issueDate;
    }

    public Paper(String issueDate) {
        this.issueDate = issueDate;
    }

    public String getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(String issueDate) {
        this.issueDate = issueDate;
    }

    @Override
    public String toString() {
        return "Paper [issueDate=" + issueDate + "]";
    }
}
