public class Staff extends Employee {
    private String job;

    public Staff() {
    }

    public Staff(String name, int age, String gender, String address, String job) {
        super(name, age, gender, address);
        this.job = job;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    @Override
    public String toString() {
        return "Staff [job=" + job + super.toString() + "]";
    }

    
}
