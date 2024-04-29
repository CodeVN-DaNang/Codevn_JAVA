package bai4.Model.entities;

import java.util.List;

public class Family {
    // Số thành viên trong gia đình, Số nhà, thông tin mỗi cá nhân trong gia đình
    private int memberAmount;
    private String address;
    public Family(int memberAmount, String address) {
        this.memberAmount = memberAmount;
        this.address = address;
    }
    public Family() {
    }
    public int getMemberAmount() {
        return memberAmount;
    }
    public void setMemberAmount(int memberAmount) {
        this.memberAmount = memberAmount;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    @Override
    public String toString() {
        return "Family [memberAmount=" + memberAmount + ", address=" + address + "]";
    }

    
    

}
