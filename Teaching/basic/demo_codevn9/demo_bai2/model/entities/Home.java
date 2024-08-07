package model.entities;


import java.util.ArrayList;

public class Home {
    private int amountMembers;
    private String homeNumber;

    public Home() {
    }

    public Home(int amountMembers, String homeNumber) {
        this.amountMembers = amountMembers;
        this.homeNumber = homeNumber;
    }

    public int getAmountMembers() {
        return amountMembers;
    }

    public void setAmountMembers(int amountMembers) {
        this.amountMembers = amountMembers;
    }

    public String getHomeNumber() {
        return homeNumber;
    }

    public void setHomeNumber(String homeNumber) {
        this.homeNumber = homeNumber;
    }

    @Override
    public String toString() {
        return "Home [amountMembers=" + amountMembers + ", homeNumber=" + homeNumber + "]";
    }

}
