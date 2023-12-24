package model.entity;

public class Document {
    private String documentId;
    private String publisher;
    private int numberPublish;

    public Document(String documentId, String publisher, int numberPublish) {
        this.documentId = documentId;
        this.publisher = publisher;
        this.numberPublish = numberPublish;
    }

    public Document() {
    }

    public String getDocumentId() {
        return documentId;
    }

    public void setDocumentId(String documentId) {
        this.documentId = documentId;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getNumberPublish() {
        return numberPublish;
    }

    public void setNumberPublish(int numberPublish) {
        this.numberPublish = numberPublish;
    }

    @Override
    public String toString() {
        return "Document [documentId=" + documentId + ", publisher=" + publisher + ", numberPublish=" + numberPublish
                + "]";
    }
}
