package bai4.Model.repo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

import bai4.Model.entities.Family;
import bai4.Model.entities.FamilyMember;

public class FamilyMemberRepo {
    FamilyRepo familyRepo = new FamilyRepo();
    List<FamilyMember> familyMembers = new ArrayList<>();

    

    public void read() {
        familyMembers.clear();
        try {
            FileReader fr = new FileReader(
                    "/Users/vannhat/Documents/Codevn_JAVA/Teaching/basic/demo_manh/bai4/data/familymember.txt");
            BufferedReader br = new BufferedReader(fr);
            String line = "";
            while ((line = br.readLine()) != null) {
                String[] arr = line.split(",");
                // ["Manh","20","IT engineer","202088019","74 Huynh Van Nghe"]
                String name = arr[0];
                int age = Integer.parseInt(arr[1]);
                String job = arr[2];
                String id = arr[3];
                Family family = familyRepo.getByAddress(arr[4]);
                FamilyMember familyMember = new FamilyMember(name, age, job, id, family);
                familyMembers.add(familyMember);
            }
            fr.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void write() {
        try {
            FileWriter fw = new FileWriter(
                    "/Users/vannhat/Documents/Codevn_JAVA/Teaching/basic/demo_manh/bai4/data/familymember.txt");
            String line = "";
            for (FamilyMember familyMember : familyMembers) {
                line += familyMember.getName() + "," + familyMember.getAge() + "," + familyMember.getJob() + ","
                        + familyMember.getId() + "," + familyMember.getFamily().getAddress() + "\n";
            }
            fw.write(line);
            fw.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public List<FamilyMember> getAll(){
        read();
        return this.familyMembers;
    }

    public void add(FamilyMember familyMember){
        read();
        familyMembers.add(familyMember);
        write();
    }

}
