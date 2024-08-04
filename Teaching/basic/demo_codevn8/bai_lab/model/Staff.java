package model;

// import java.time.LocalDate;
import java.util.Date;

/**
 * Staff
 */
public class Staff implements Comparable<Staff> {

    // Id nhân viên, họ, tên, tuổi, ngày sinh, số ngày làm việc trong tháng, lương.
    private int staff_id;
    private String staff_name;
    private int age;
    private Date dob;
    private int workingDay;
    private double salary;

    public Staff() {
    }

    public Staff(int staff_id, String staff_name, int age, Date dob, int workingDay, double salary) {
        this.staff_id = staff_id;
        this.staff_name = staff_name;
        this.age = age;
        this.dob = dob;
        this.workingDay = workingDay;
        this.salary = salary;
    }

    public int getStaff_id() {
        return staff_id;
    }

    public void setStaff_id(int staff_id) {
        this.staff_id = staff_id;
    }

    public String getStaff_name() {
        return staff_name;
    }

    public void setStaff_name(String staff_name) {
        this.staff_name = staff_name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public int getWorkingDay() {
        return workingDay;
    }

    public void setWorkingDay(int workingDay) {
        this.workingDay = workingDay;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void calculateSalary(){}

    @Override
    public String toString() {
        return "Staff [staff_id=" + staff_id + ", staff_name=" + staff_name + ", age=" + age + ", dob=" + dob
                + ", workingDay=" + workingDay + ", salary=" + salary + "]";
    }

    @Override
    public int compareTo(Staff o) {
        return (int) (this.salary - o.getSalary());
    }

}