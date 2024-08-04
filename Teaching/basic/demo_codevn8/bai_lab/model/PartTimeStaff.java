package model;

import java.util.Date;

public class PartTimeStaff extends Staff {
    private double discount;

    public PartTimeStaff() {
    }

    public PartTimeStaff(int staff_id, String staff_name, int age, Date dob, int workingDay, double salary,
            double discount) {
        super(staff_id, staff_name, age, dob, workingDay, salary);
        this.discount = discount;
        calculateSalary();
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    @Override
    public void calculateSalary(){
        setSalary(super.getWorkingDay() * 1000000 * this.discount);
    }

    @Override
    public String toString() {
        return "PartTimeStaff [discount=" + discount + "," + super.toString() + "]";
    }

    

}
