package model.service;

import java.util.ArrayList;

import model.entity.Bill;
import model.repository.BillRepository;

public class BillService {
    BillRepository billRepository = new BillRepository();

    public ArrayList<Bill> getAllBill() {
        return this.billRepository.getAllBill();
    }

    public ArrayList<Bill> findByName(String name) {
        ArrayList<Bill> bills = getAllBill();
        ArrayList<Bill> finds = new ArrayList<>();
        for (int i = 0; i < bills.size(); i++) {
            if (bills.get(i).getPerson().getName().contains(name)) {
                finds.add(bills.get(i));
            }
        }
        return finds;
    }

    public boolean addNew(Bill bill) {
        return this.billRepository.addNew(0, bill);
    }

    public void edit(int index, Bill bill) {
        this.billRepository.delete(index);
        this.billRepository.addNew(index, bill);
    }

    public void delete(int index) {
        this.billRepository.delete(index);
    }

    public int calculateMoney(int index){
        Bill bill = billRepository.getByIndex(index);
        return bill.getDateUse() * bill.getRoom().getPrice();
    }
}
