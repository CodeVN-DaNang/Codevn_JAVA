package model;

public class Doctor extends Employee {
    private int level;
    private String major;
    private int position;

    public Doctor(int idEmployee, String nameEmployee, String phone, String email, float coefficientsSalary, int level, String major, int position) {
        super(idEmployee, nameEmployee, phone, email, coefficientsSalary);
        //TODO Auto-generated constructor stub
        this.level = level;
        this.major = major;
        this.position = position;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    @Override
    public float calculateSalary(){
        return (this.level + super.getCoefficientsSalary()) * 1650000 + this.position;
    }

    @Override
    public String toString() {
        return "Doctor [" + super.toString() + ", level=" + level + ", major=" + major + ", position=" + position + "]";
    }
    
}
