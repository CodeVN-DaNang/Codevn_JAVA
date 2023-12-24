public class Staff extends Employee {
    private String workJob;

    public Staff(String name, int age, String gender, String address, String workJob) {
        super(name, age, gender, address);
        this.workJob = workJob;
    }

    public Staff() {
    }

    public String getWorkJob() {
        return workJob;
    }

    public void setWorkJob(String workJob) {
        this.workJob = workJob;
    }

    public String displayInfor() {
        return "Staff [" + super.displayInfor() + " ,workJob=" + workJob + "]";
    }
}
