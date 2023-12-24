package model.entities;

public class NorthBank {
    private String idNB;
    private String nameNB;
    private String dateIssue;
    private String address;
    private int numOfS;
    private int numOfJr;
    protected double estimate;
    protected double realCost;

    public NorthBank(String idNB, String nameNB, String dateIssue, String address, int numOfS, int numOfJr,
            int estimate, int realCost) {
        this.idNB = idNB;
        this.nameNB = nameNB;
        this.dateIssue = dateIssue;
        this.address = address;
        this.numOfS = numOfS;
        this.numOfJr = numOfJr;
        this.estimate = estimate;
        this.realCost = realCost;
        setEstimate();
        setRealCost();
    }

    public NorthBank() {
    }

    public String getIdNB() {
        return idNB;
    }

    public void setIdNB(String idNB) {
        this.idNB = idNB;
    }

    public String getNameNB() {
        return nameNB;
    }

    public void setNameNB(String nameNB) {
        this.nameNB = nameNB;
    }

    public String getDateIssue() {
        return dateIssue;
    }

    public void setDateIssue(String dateIssue) {
        this.dateIssue = dateIssue;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getNumOfS() {
        return numOfS;
    }

    public void setNumOfS(int numOfS) {
        this.numOfS = numOfS;
    }

    public int getNumOfJr() {
        return numOfJr;
    }

    public void setNumOfJr(int numOfJr) {
        this.numOfJr = numOfJr;
    }

    public double getEstimate() {
        return estimate;
    }

    public void setEstimate() {
        this.estimate = this.numOfS * 5000 * 2 + this.numOfJr * 2000 * 2;
    }

    public double getRealCost() {
        return realCost;
    }

    public void setRealCost() {
        this.realCost = this.estimate;
    }

    @Override
    public String toString() {
        return "NorthBank [idNB=" + idNB + ", nameNB=" + nameNB + ", dateIssue=" + dateIssue + ", address=" + address
                + ", numOfS=" + numOfS + ", numOfJr=" + numOfJr + ", estimate=" + estimate + ", realCost=" + realCost
                + "]";
    }
}