package model.repo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

import model.entity.Bill;
import model.entity.Customer;
import model.entity.Document;

public class BillRepo {

    DocumentRepo documentRepo = new DocumentRepo();
    CustomerRepo customerRepo = new CustomerRepo();
    ArrayList<Bill> billList = new ArrayList<>();

    public void readTxt() {
        try {
            FileReader fr = new FileReader("/data/Bill.txt");
            BufferedReader br = new BufferedReader(fr);
            String line = "";
            while ((line = br.readLine()) != null) {
                int billId = Integer.parseInt(line.split(",")[0]);
                Customer borrowCustomer = customerRepo.getCustomerById(Integer.parseInt(line.split(",")[1]));
                Document borrowDocument = documentRepo.getDocumentById(line.split(",")[2]);
                String dateBorrow = line.split(",")[3];
                String dateReturn = line.split(",")[4];
                double fees = Double.parseDouble(line.split(",")[5]);
                boolean status = Boolean.parseBoolean(line.split(",")[6]);
                Bill bill = new Bill(billId, borrowCustomer, borrowDocument, dateBorrow, dateReturn, fees, status);
                billList.add(bill);
            }
            br.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void writeTxt() {
        try {
            FileWriter fw = new FileWriter("/data/Bill.txt");
            String line = "";
            for (Bill bill : billList) {
                line = line + bill.getBillId() + "," + bill.getBorrowCustomer().getCustomerId() + ","
                        + bill.getBorrowDocument().getDocumentId() + "," + bill.getDateBorrow() + ","
                        + bill.getDateReturn() + "," + bill.getFees() + "," + bill.isStatus() + "\n";
            }
            fw.write(line);
            fw.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public ArrayList<Bill> getAllBill() {
        readTxt();
        return billList;
    }

    public Bill getBillById(int id) {
        readTxt();
        for (Bill bill : billList) {
            if (bill.getBillId() == id) {
                return bill;
            }
        }
        return null;
    }

    public void addBill(Bill bill) {
        billList.add(bill);
    }

    public void deleteBill(int id) {
        for (Bill bill : billList) {
            if (bill.getBillId() == id) {
                billList.remove(bill);
            }
        }
    }

    public void editBill(int index, Bill bill) {
        billList.set(index, bill);
    }

}
