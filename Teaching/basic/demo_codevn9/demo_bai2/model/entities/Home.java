package demo_bai2.model.entities;

import java.util.ArrayList;

public class Home {
    private int amountMembers;
    private int homeNumber;
    private ArrayList<Person> people;

    public Home() {
    }

    public Home(int amountMembers, int homeNumber, ArrayList<Person> people) {
        this.amountMembers = amountMembers;
        this.homeNumber = homeNumber;
        this.people = people;
    }

    public int getAmountMembers() {
        return amountMembers;
    }

    public void setAmountMembers(int amountMembers) {
        this.amountMembers = amountMembers;
    }

    public int getHomeNumber() {
        return homeNumber;
    }

    public void setHomeNumber(int homeNumber) {
        this.homeNumber = homeNumber;
    }

    public ArrayList<Person> getPeople() {
        return people;
    }

    public void setPeople(ArrayList<Person> people) {
        this.people = people;
    }

    @Override
    public String toString() {
        return "Home [amountMembers=" + amountMembers + ", homeNumber=" + homeNumber + ", people=" + people + "]";
    }

}
