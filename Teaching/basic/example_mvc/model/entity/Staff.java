package model.entity;

public class Staff extends Employee {
    private String job;

    

    public Staff(int id, String name, int age, String gender, String address, String job) {
        super(id, name, age, gender, address);
        this.job = job;
    }

    public Staff() {
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    @Override
    public String toString() {
        return "Staff ["+ super.toString() + "job=" + job + "]";
    }
}
