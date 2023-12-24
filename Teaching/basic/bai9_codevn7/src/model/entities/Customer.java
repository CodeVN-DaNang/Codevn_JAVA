package model.entities;

public class Customer {
    private String customerName;
    private String customerNum;
    private String customerCode;

    public Customer(String customerName, String customerNum, String customerCode) {
        this.customerName = customerName;
        this.customerNum = customerNum;
        this.customerCode = customerCode;
    }

    public Customer() {
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerNum() {
        return customerNum;
    }

    public void setCustomerNum(String customerNum) {
        this.customerNum = customerNum;
    }

    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    @Override
    public String toString() {
        return "Customer [customerName=" + customerName + ", customerNum=" + customerNum + ", customerCode="
                + customerCode + "]";
    }
}
