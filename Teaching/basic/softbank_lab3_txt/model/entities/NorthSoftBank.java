package model.entities;

public class NorthSoftBank {
    // ID chi nhánh, tên chi nhanh, ngày thành lập, địa chỉ, số lượng nhân viên
    // senior, số lượng nhân viên junior, chi phí dự trù, chi phí thực tế
    private int id;
    private String name;
    private String dateOfBirth;
    private String address;
    private int amountSr;
    private int amountJr;
    private double sugPackage;
    private double realPackage;

    public NorthSoftBank(int id, String name, String dateOfBirth, String address, int amountSr, int amountJr) {
        this.id = id;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.amountSr = amountSr;
        this.amountJr = amountJr;
        // Số lượngn nhân viên senior * 5.000 * Hệ số lương theo vùng miền + Số lượng
        // nhân viên junior * 2.000 * Hệ số lương theo vùng miền
        calculateSalary();
    }

    public void calculateSalary(){
        this.sugPackage = this.amountSr * 5000 * 2.0 + this.amountJr * 2000 * 2.0;
        this.realPackage = this.sugPackage;
    }

    public NorthSoftBank() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAmountSr() {
        return amountSr;
    }

    public void setAmountSr(int amountSr) {
        this.amountSr = amountSr;
    }

    public int getAmountJr() {
        return amountJr;
    }

    public void setAmountJr(int amountJr) {
        this.amountJr = amountJr;
    }

    public double getSugPackage() {
        return sugPackage;
    }

    public void setSugPackage(double sugPackage) {
        this.sugPackage = sugPackage;
    }

    public double getRealPackage() {
        return realPackage;
    }

    public void setRealPackage(double realPackage) {
        this.realPackage = realPackage;
    }

    @Override
    public String toString() {
        return "NorthSoftBank [id=" + id + ", name=" + name + ", dateOfBirth=" + dateOfBirth + ", address=" + address
                + ", amountSr=" + amountSr + ", amountJr=" + amountJr + ", sugPackage=" + sugPackage + ", realPackage="
                + realPackage + "]";
    }

}