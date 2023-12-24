public class Engineer extends Employee {
    private String majorTraining;

    public Engineer(String name, int age, String gender, String address, String majorTraining) {
        super(name, age, gender, address);
        this.majorTraining = majorTraining;
    }

    public Engineer() {
    }

    public String getMajorTraining() {
        return majorTraining;
    }

    public void setMajorTraining(String majorTraining) {
        this.majorTraining = majorTraining;
    }

    public String displayInfor() {
        return "Engineer [" + super.displayInfor() + " ,majorTraining=" + this.majorTraining + "]";
    }
}
