package model;

import java.util.Date;

public class OfficeStaff extends Staff {
    private int OTHours;

    public OfficeStaff() {
    }

    public OfficeStaff(int staff_id, String staff_name, int age, Date dob, int workingDay, double salary, int oTHours) {
        super(staff_id, staff_name, age, dob, workingDay, salary);
        OTHours = oTHours;
        calculateSalary();
    }

    public int getOTHours() {
        return OTHours;
    }

    public void setOTHours(int oTHours) {
        OTHours = oTHours;
    }

    @Override
    public void calculateSalary(){
        setSalary(super.getWorkingDay() * 1000000 + this.OTHours * 100000);
    }

    @Override
    public String toString() {
        return "OfficeStaff [OTHours=" + OTHours + "," + super.toString() + "]";
    }

    
}
