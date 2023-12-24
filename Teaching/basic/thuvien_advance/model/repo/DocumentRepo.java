package model.repo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

import model.entity.Book;
import model.entity.Document;
import model.entity.Magazine;
import model.entity.Paper;

public class DocumentRepo {
    ArrayList<Book> bookList = new ArrayList<>();
    ArrayList<Magazine> magazineList = new ArrayList<>();
    ArrayList<Paper> paperList = new ArrayList<>();

    public void readDocument() {
        bookList.clear();
        magazineList.clear();
        paperList.clear();
        try {
            FileReader fr = new FileReader("/data/Document.txt");
            BufferedReader br = new BufferedReader(fr);
            String line = "";
            while ((line = br.readLine()) != null) {
                String documentId = line.split(",")[0];
                String publisher = line.split(",")[1];
                int numberPublish = Integer.parseInt(line.split(",")[2]);
                if (documentId.contains("B")) {
                    String author = line.split(",")[3];
                    int numberPage = Integer.parseInt(line.split(",")[4]);
                    Book book = new Book(documentId, publisher, numberPublish, author, numberPage);
                    bookList.add(book);
                } else if (documentId.contains("M")) {
                    int issueNumber = Integer.parseInt(line.split(",")[3]);
                    String issueDate = line.split(",")[4];
                    Magazine magazine = new Magazine(documentId, publisher, numberPublish, issueNumber, issueDate);
                    magazineList.add(magazine);
                } else if (documentId.contains("P")) {
                    String issueDate = line.split(",")[3];
                    Paper paper = new Paper(documentId, publisher, numberPublish, issueDate);
                    paperList.add(paper);
                }
            }
            br.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void writeBook() {
        try {
            FileWriter fw = new FileWriter("/data/Document.txt");
            String line = "";
            for (Book book : bookList) {
                line = line + book.getDocumentId() + "," + book.getPublisher() + "," + book.getNumberPublish() + ","
                        + book.getAuthor() + "," + book.getNumberPage() + "\n";
            }
            for (Magazine magazine : magazineList) {
                line = line + magazine.getDocumentId() + "," + magazine.getPublisher() + ","
                        + magazine.getNumberPublish() + ","
                        + magazine.getIssueNumber() + "," + magazine.getIssueDate() + "\n";
            }
            for (Paper paper : paperList) {
                line = line + paper.getDocumentId() + "," + paper.getPublisher() + "," + paper.getNumberPublish() + ","
                        + paper.getIssueDate() + "\n";
            }
            fw.write(line);
            fw.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public ArrayList<Book> getAllBooks() {
        return bookList;
    }

    public ArrayList<Magazine> getAllMagazines() {
        return magazineList;
    }

    public ArrayList<Paper> getAllPaper() {
        return paperList;
    }

    public Document getDocumentById(String documentId){
        Document document;
        if ((document = getBookById(documentId)) == null) {
            if ((document = getMagazineById(documentId)) == null) {
                if ((document = getPaperById(documentId)) == null) {
                    return null;
                }
            }
        }
        return document;
    }

    public Book getBookById(String documentId) {
        for (Book book : bookList) {
            if (book.getDocumentId().equals(documentId)) {
                return book;
            }
        }
        return null;
    }

    public Magazine getMagazineById(String documentId) {
        for (Magazine magazine : magazineList) {
            if (magazine.getDocumentId().equals(documentId)) {
                return magazine;
            }
        }
        return null;
    }

    public Paper getPaperById(String documentId) {
        for (Paper paper : paperList) {
            if (paper.getDocumentId().equals(documentId)) {
                return paper;
            }
        }
        return null;
    }

    public void addDocument(Document document) {
        if (document.getDocumentId().contains("B")) {
            bookList.add((Book) document);
        }
        if (document.getDocumentId().contains("M")) {
            magazineList.add((Magazine) document);
        }
        if (document.getDocumentId().contains("P")) {
            paperList.add((Paper) document);
        }
    }

    public void deleteDocument(int index) {
        if (index >= 0 && index < bookList.size()) {
            bookList.remove(index);
        } else if (index >= bookList.size() && index < bookList.size() + magazineList.size()) {
            magazineList.remove(index);
        } else if (index >= bookList.size() + magazineList.size()
                && index < bookList.size() + magazineList.size() + paperList.size()) {
            paperList.remove(index);
        }
    }

    public void editDocument(int index, Document document){
        if (index >= 0 && index < bookList.size()) {
            bookList.set(index, (Book) document);
        } else if (index >= bookList.size() && index < bookList.size() + magazineList.size()) {
            magazineList.set(index, (Magazine) document);
        } else if (index >= bookList.size() + magazineList.size()
                && index < bookList.size() + magazineList.size() + paperList.size()) {
            paperList.set(index, (Paper) document);
        }
    }

}
