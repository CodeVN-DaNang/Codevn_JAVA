package model.repository;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

import model.entity.BorrowCard;
import model.entity.Student;

public class BorrowCardRepo {

    StudentRepo studentRepo = new StudentRepo();

    ArrayList<BorrowCard> borrowCardList = new ArrayList<>();

    // tuong tac voi txt
    // doc du lieu tu file txt
    public void readTxt() {
        borrowCardList.clear();
        try {
            FileReader fr = new FileReader("data/BorrowCard.txt");
            BufferedReader br = new BufferedReader(fr);
            String line = "";
            while ((line = br.readLine()) != null) {
                String id = line.split(",")[0]; // line = 1,2023-08-10,14,SP23,1
                String borrowDate = line.split(",")[1];
                String dateExp = line.split(",")[2];
                String bookId = line.split(",")[3];
                // student
                Student student = studentRepo.getStudentByName(line.split(",")[4]);
                BorrowCard borrowCard = new BorrowCard(id, borrowDate, dateExp, bookId, student);
                borrowCardList.add(borrowCard);
            }
            br.close();
            fr.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    // viet vao file txt
    public void writeTxt() {
        try {
            FileWriter fw = new FileWriter("data/BorrowCard.txt");
            String dataToTxt = "";
            for (BorrowCard borrowCard : borrowCardList) {
                dataToTxt = dataToTxt + borrowCard.getId() + "," + borrowCard.getBorrowDate() + ","
                        + borrowCard.getDateExp() + "," + borrowCard.getBookId() + ","
                        + borrowCard.getStudent().getName() + "\n";
            }
            fw.write(dataToTxt);
            fw.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public ArrayList<BorrowCard> getAllCards() {
       readTxt();
        return borrowCardList;
    }

    public BorrowCard getBorrowCardById(int index) {
        if (borrowCardList.isEmpty()) {
            readTxt();
        }
        return borrowCardList.get(index);
    }

    public void addNewCard(BorrowCard borrowCard) {
        borrowCardList.add(borrowCard);
        writeTxt();
    }

    public void deleteCard(int index) {
        borrowCardList.remove(index);
        writeTxt();
    }

    public void editCard(int index, BorrowCard borrowCard) {
        borrowCardList.set(index, borrowCard);
        writeTxt();
    }
}
