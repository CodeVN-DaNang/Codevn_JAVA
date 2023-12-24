package model.entities;

public class MiddleBank extends NorthBank {
    private int numOfC;

    public MiddleBank(String idNB, String nameNB, String dateIssue, String address, int numOfS, int numOfJr,
            int estimate, int realCost, int numOfC) {
        super(idNB, nameNB, dateIssue, address, numOfS, numOfJr, estimate, realCost);
        this.numOfC = numOfC;
        this.setEstimate();
        this.setRealCost();
    }

    public MiddleBank() {
    }

    public int getNumOfC() {
        return numOfC;
    }

    public void setNumOfC(int numOfC) {
        this.numOfC = numOfC;
    }

    @Override
    public void setEstimate() {
        this.estimate = this.getNumOfS() * 5000 * 1.5 + this.getNumOfJr() * 2000 * 1.5;
    }

    @Override
    public void setRealCost() {
        this.realCost = this.estimate + this.numOfC * 1000;
    }

    @Override
    public String toString() {
        return "MiddleBank [ "+ super.toString() + "numOfC=" + numOfC + "]";
    }

    

}
