package model.entities;

public class MidSoftBank extends NorthSoftBank {
    private int amountCrt;

    public MidSoftBank(int id, String name, String dateOfBirth, String address, int amountSr, int amountJr,
            int amountCrt) {
        super(id, name, dateOfBirth, address, amountSr, amountJr);
        this.amountCrt = amountCrt;
        this.calculateSalary();
    }

    @Override
    public void calculateSalary(){
        super.setSugPackage(this.getAmountSr() * 5000 * 1.5 + this.getAmountJr() * 2000 * 1.5);
        super.setRealPackage(this.getAmountSr() * 5000 * 1.5 + this.getAmountJr() * 2000 * 1.5 + this.amountCrt * 1000);
    }

    public MidSoftBank() {
    }

    public int getAmountCrt() {
        return amountCrt;
    }

    public void setAmountCrt(int amountCrt) {
        this.amountCrt = amountCrt;
    }

    @Override
    public String toString() {
        return "MidSoftBank [" + super.toString() + "amountCrt=" + amountCrt + "]";
    }

}
