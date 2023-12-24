package model.entity;

public class Engineer extends Employee {
    private String major;

  

    public Engineer(int id, String name, int age, String gender, String address, String major) {
        super(id, name, age, gender, address);
        this.major = major;
    }

    public Engineer() {
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    @Override
    public String toString() {
        return "Engineer ["+ super.toString() + "major=" + major + "]";
    }
}
