package model.repo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

import model.entities.MiddleBank;
import model.entities.NorthBank;

public class BankRepo {
    ArrayList<NorthBank> bankList = new ArrayList<>();

    public static void main(String[] args) {
        BankRepo bankRepo = new BankRepo();
        bankRepo.read();
        for (NorthBank northBank : bankRepo.bankList) {
            System.out.println(northBank.toString());
        }
    }

    public void read() {
        try {
            FileReader fr = new FileReader("/Users/vannhat/Documents/NHATTV_JAVA/teaching/basic/demo_softbank_codevn7/src/data/SoftBank.txt");
            BufferedReader br = new BufferedReader(fr);
            String line = "";
            while ((line = br.readLine()) != null) {
                String arr[] = line.split(",");// 
                String idNB = arr[0];
                String nameNB = arr[1];
                String dateIssue = arr[2];
                String address = arr[3];
                int numOfS = Integer.parseInt(arr[4]);
                int numOfJr = Integer.parseInt(arr[5]);
                double estimate = Double.parseDouble(arr[6]);
                double realCost = Double.parseDouble(arr[7]);
                NorthBank bank;
                if (arr.length != 9) {
                    bank = new NorthBank(idNB, nameNB, dateIssue, address, numOfS, numOfJr, (int) estimate, (int) realCost);
                } else {
                    int numOfC = Integer.parseInt(arr[8]);
                    bank = new MiddleBank(idNB, nameNB, dateIssue, address, numOfS, numOfJr, (int) estimate, (int) realCost, numOfC);
                }
                bankList.add(bank);
            }
            br.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
