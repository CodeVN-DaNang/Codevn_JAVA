package model;

public class Nurse extends Employee{
    private int overtime;
    private String department;

    public Nurse(int idEmployee, String nameEmployee, String phone, String email, float coefficientsSalary, String department, int overtime) {
        super(idEmployee, nameEmployee, phone, email, coefficientsSalary);
        //TODO Auto-generated constructor stub
        this.overtime = overtime;
        this.department = department;
    }

    public int getOvertime() {
        return overtime;
    }

    public void setOvertime(int overtime) {
        this.overtime = overtime;
    }

    public String getDepartment() {
        return department;
    }


    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public float calculateSalary(){
        return (super.getCoefficientsSalary() * 1650000) + this.overtime * 200000;
    }

    @Override
    public String toString() {
        return "Nurse [" + super.toString() + ", department=" + this.department + ", overtime=" + this.overtime + "]";
    }

    
}
