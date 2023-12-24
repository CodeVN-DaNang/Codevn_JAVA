package main.model.entity;

public class Subject {
    private int subId;
    private String subName;
    private int credit;
    private boolean status;
    public Subject(int subId, String subName, int credit, boolean status) {
        this.subId = subId;
        this.subName = subName;
        this.credit = credit;
        this.status = status;
    }
    public Subject(String subName, int credit, boolean status) {
        this.subName = subName;
        this.credit = credit;
        this.status = status;
    }
    public int getSubId() {
        return subId;
    }
    public void setSubId(int subId) {
        this.subId = subId;
    }
    public String getSubName() {
        return subName;
    }
    public void setSubName(String subName) {
        this.subName = subName;
    }
    public int getCredit() {
        return credit;
    }
    public void setCredit(int credit) {
        this.credit = credit;
    }
    public boolean isStatus() {
        return status;
    }
    public void setStatus(boolean status) {
        this.status = status;
    }
    @Override
    public String toString() {
        return subName + " [ credit=" + credit + ", status=" + status + "]";
    }
    
}
