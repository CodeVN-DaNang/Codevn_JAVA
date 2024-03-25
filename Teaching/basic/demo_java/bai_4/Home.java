package bai_4;

public class Home {
    private String homeNumber;
    private int amountPeople;
    public Home(String homeNumber, int amountPeople) {
        this.homeNumber = homeNumber;
        this.amountPeople = amountPeople;
    }
    public Home() {
    }
    public String getHomeNumber() {
        return homeNumber;
    }
    public void setHomeNumber(String homeNumber) {
        this.homeNumber = homeNumber;
    }
    public int getAmountPeople() {
        return amountPeople;
    }
    public void setAmountPeople(int amountPeople) {
        this.amountPeople = amountPeople;
    }
    @Override
    public String toString() {
        return "Home [homeNumber=" + homeNumber + ", amountPeople=" + amountPeople + "]";
    }

    

}
