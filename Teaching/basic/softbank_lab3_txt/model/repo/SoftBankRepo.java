package model.repo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

import model.entities.MidSoftBank;
import model.entities.NorthSoftBank;

public class SoftBankRepo {
    ArrayList<NorthSoftBank> softBankList = new ArrayList<>();

    public void read() {
        softBankList.clear();
        try {
            FileReader fr = new FileReader(
                    "/Users/vannhat/Documents/NHATTV_JAVA/teaching/basic/softbank_lab3/data/SoftBank.txt");
            BufferedReader br = new BufferedReader(fr);
            String line;
            while ((line = br.readLine()) != null) {
                String[] arr = line.split(","); // ["1", "1", "1", "1", "1", "1"]
                int id = Integer.parseInt(arr[0]);
                String name = arr[1];
                String dateOfBirth = arr[2];
                String address = arr[3];
                int amountSr = Integer.parseInt(arr[4]);
                int amountJr = Integer.parseInt(arr[5]);
                NorthSoftBank softBank = new NorthSoftBank(id, name, dateOfBirth, address, amountSr, amountJr);
                if (arr.length == 7) {
                    int amountCrt = Integer.parseInt(arr[6]);
                    softBank = new MidSoftBank(id, name, dateOfBirth, address, amountSr, amountJr, amountCrt);
                }
                softBankList.add(softBank);
            }
            br.close();
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e);
        }
    }

    public void write() {
        try {
            FileWriter fw = new FileWriter(
                    "/Users/vannhat/Documents/NHATTV_JAVA/teaching/basic/softbank_lab3/data/SoftBank.txt");
            String line = "";
            for (NorthSoftBank northSoftBank : softBankList) {
                if (northSoftBank.toString().contains("MidSoftBank")) {
                    line = line + northSoftBank.getId() + "," + northSoftBank.getName() + ","
                            + northSoftBank.getDateOfBirth() + "," + northSoftBank.getAddress() + ","
                            + northSoftBank.getAmountSr() + "," + northSoftBank.getAmountJr() + ","
                            + ((MidSoftBank) northSoftBank).getAmountCrt() + "\n";
                    continue;
                }
                line = line + northSoftBank.getId() + "," + northSoftBank.getName() + ","
                        + northSoftBank.getDateOfBirth() + "," + northSoftBank.getAddress() + ","
                        + northSoftBank.getAmountSr() + "," + northSoftBank.getAmountJr() + "\n";
            }
            System.out.println(line);
            fw.write(line);
            fw.close();
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e);
        }
    }

    public ArrayList<NorthSoftBank> getAllSoftBanks() {
        read();
        return softBankList;
    }

    public void addSoftBank(NorthSoftBank softBank) {
        read();
        softBankList.add(softBank);
        write();
    }

    public void deleteSoftBank(int index) {
        read();
        softBankList.remove(index);
        write();
    }

    public void updateSoftBank(int count, NorthSoftBank softBank) {
        read();
        softBankList.set(count, softBank);
        write();
    }

}
