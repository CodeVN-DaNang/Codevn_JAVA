public class Engineer extends Employee {
    private String major;

    public Engineer() {
    }

    public Engineer(String name, int age, String gender, String address, String major) {
        super(name, age, gender, address);
        this.major = major;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    @Override
    public String toString() {
        return "Engineer [major=" + major + super.toString() + "]";
    }

    
}
