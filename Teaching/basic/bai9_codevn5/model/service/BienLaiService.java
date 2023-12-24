package model.service;

import java.util.ArrayList;

import model.entity.BienLai;
import model.repository.BienLaiRepository;

public class BienLaiService {
    BienLaiRepository bienLaiRepository = new BienLaiRepository();
    // crud
    public ArrayList<BienLai> getAllBienLai(){
        return bienLaiRepository.getAllBienLai();
    }
    public void addBienLai(BienLai bienLai){
        bienLaiRepository.addNewBienLai(bienLai);
    }
}
