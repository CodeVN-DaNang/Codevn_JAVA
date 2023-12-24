package model.service;

import java.util.ArrayList;

import model.entities.NorthSoftBank;
import model.repo.SoftBankRepo;

public class SoftBankService {
    SoftBankRepo softBankRepo = new SoftBankRepo();

    public ArrayList<NorthSoftBank> getAllSoftBanks(){
        return softBankRepo.getAllSoftBanks();
    }

    public ArrayList<NorthSoftBank> getSoftBankByName(String name){
        ArrayList<NorthSoftBank> findBanks = new ArrayList<>();
        for (NorthSoftBank softBank : softBankRepo.getAllSoftBanks()) {
            if (softBank.getName().contains(name)) {
                findBanks.add(softBank);
            }
        }
        return findBanks;
    }

    public void addSoftBank(NorthSoftBank softBank){
        softBankRepo.addSoftBank(softBank);
    }

    public void deleteSoftBank(int id){
        int count = -1;
        for (NorthSoftBank softBank2 : softBankRepo.getAllSoftBanks()) {
            count++;
            if (softBank2.getId() == id) {
                System.out.println(softBank2.toString());
                softBankRepo.deleteSoftBank(count);
            }
        }
    }

    public void updateSoftBank(int id, NorthSoftBank softBank){
        int count = -1;
        for (NorthSoftBank softBank2 : softBankRepo.getAllSoftBanks()) {
            count++;
            if (softBank2.getId() == id) {
                System.out.println(softBank2.toString());
                softBankRepo.updateSoftBank(count, softBank);
            }
            
        }
    }


}
