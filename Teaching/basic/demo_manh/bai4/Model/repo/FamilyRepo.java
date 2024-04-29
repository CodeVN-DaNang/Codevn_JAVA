package bai4.Model.repo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

import bai4.Model.entities.Family;
import bai4.Model.entities.FamilyMember;

public class FamilyRepo {
    List<Family> families = new ArrayList<>();
    

   

    public void read(){
        families.clear();
        try {
            FileReader fr = new FileReader("/Users/vannhat/Documents/Codevn_JAVA/Teaching/basic/demo_manh/bai4/data/family.txt");
            BufferedReader br = new BufferedReader(fr);
            String line = "";
            while ((line = br.readLine()) != null) {
                String[] arr = line.split(","); // ["3","334 hoang dieu"]
                int memberAmount = Integer.parseInt(arr[0]);
                String address = arr[1];
                Family family = new Family(memberAmount, address);
                families.add(family);
            }
            fr.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void write(){
        try {
            FileWriter fw = new FileWriter("/Users/vannhat/Documents/Codevn_JAVA/Teaching/basic/demo_manh/bai4/data/family.txt");
            String line = "";
            for (Family family : families) {
                line += family.getMemberAmount() + "," + family.getAddress() + "\n";
            }
            fw.write(line);
            fw.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public List<Family> getFamilies(){
        read();
        return this.families;
    }

    public Family getByAddress(String address){
        read();
        for (Family family : families) {
            if (family.getAddress().equals(address)) {
                return family;
            }
        }
        return null;
    }

    public void add(Family family){
        read();
        families.add(family);
        write();
    }

}
