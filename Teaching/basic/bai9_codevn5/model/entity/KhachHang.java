package model.entity;

public class KhachHang {
    private String name;
    private String houseNumber;
    private double code;

    public KhachHang(String name, String houseNumber, double code) {
        this.name = name;
        this.houseNumber = houseNumber;
        this.code = code;
    }

    public KhachHang() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public double getCode() {
        return code;
    }

    public void setCode(double code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "KhachHang [name=" + name + ", houseNumber=" + houseNumber + ", code=" + code + "]";
    }
}
