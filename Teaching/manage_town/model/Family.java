package manage_town.model;

import java.util.ArrayList;

public class Family {
    // Số thành viên trong gia đình, Số nhà, thông tin mỗi cá nhân trong gia đình.
    private String address;
    private int numFam;
    private ArrayList<People> memFams = new ArrayList<>();

    public Family(String address, ArrayList<People> memFams) {
        this.address = address;
        this.numFam = memFams.size();
        this.memFams = memFams;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public int getNumFam() {
        return this.numFam;
    }
    public ArrayList<People> getMemFams() {
        return memFams;
    }
    public void setMemFams(ArrayList<People> memFams) {
        this.memFams = memFams;
    }
    @Override
    public String toString() {
        String allMem = "";
        for (int i = 0; i < memFams.size(); i++) {
            allMem += i + ". " + memFams.get(i).toString() + "\n";
        }
        return "Family [address=" + address + ", numFam=" + numFam + ", \n" + 
            allMem +
        "]";
    }

}
