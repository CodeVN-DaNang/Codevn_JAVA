package controller;

import model.entity.Bill;
import model.service.BillService;
import view.BillMenu;

public class BillController {
    BillMenu billMenu = new BillMenu();
    BillService billService = new BillService();
    public void billController() {
        int key = billMenu.displayBillMenu();
        switch (key) {
            case 1:
                addNewBill();
                break;
        
            default:
                break;
        }
    }
    private void addNewBill() {
        Bill bill = billMenu.addBillView();
        billService.addNew(bill);
    }
}
