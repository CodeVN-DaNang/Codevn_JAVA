package model.repository;

import java.util.ArrayList;

import model.entity.Bill;

public class BillRepository {
    private ArrayList<Bill> bills = new ArrayList<>();

    public ArrayList<Bill> getAllBill() {
        return this.bills;
    }

    public Bill getByIndex(int index) {
        return this.bills.get(index);
    }

    public boolean addNew(int index, Bill bill) {
        return this.bills.add(bill);
    }

    public void edit(int index, Bill bill) {
        this.bills.remove(index);
        this.bills.add(index, bill);
    }

    public void delete(int index) {
        this.bills.remove(index);
    }
}
