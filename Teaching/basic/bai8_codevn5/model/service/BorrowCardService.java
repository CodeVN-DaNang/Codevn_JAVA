package model.service;

import java.util.ArrayList;

import model.entity.BorrowCard;
import model.repository.BorrowCardRepo;

public class BorrowCardService {
    BorrowCardRepo borrowCardRepo = new BorrowCardRepo();

    public ArrayList<BorrowCard> getAllCards(){
        return borrowCardRepo.getAllCards();
    }

    public BorrowCard getBorrowCardById(int index){
        return borrowCardRepo.getBorrowCardById(index);
    }

    public void addNewCard(BorrowCard borrowCard){
        borrowCardRepo.addNewCard(borrowCard);
    }

    public void deleteCard(int index){
        borrowCardRepo.deleteCard(index);
    }

    public void editCard(int index, BorrowCard borrowCard){
        borrowCardRepo.editCard(index, borrowCard);
    }
}
