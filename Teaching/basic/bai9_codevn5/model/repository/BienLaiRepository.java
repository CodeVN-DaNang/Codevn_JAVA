package model.repository;

import java.util.ArrayList;

import model.entity.BienLai;

public class BienLaiRepository {
    ArrayList<BienLai> bienLaiList = new ArrayList<>();

    // lay tat ca
    public ArrayList<BienLai> getAllBienLai(){
        return this.bienLaiList;
    }

    public BienLai getBienLaiById(int index){
        return this.bienLaiList.get(index);
    }

    public void addNewBienLai(BienLai bienLai){
        this.bienLaiList.add(bienLai);
    }

    public void updateBienLai(int index, BienLai bienLai){
        this.bienLaiList.set(index, bienLai);
    }

    public void deleteBienLai(int index){
        this.bienLaiList.remove(index);
    }
}
