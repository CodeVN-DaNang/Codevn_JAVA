public class Worker extends Employee{
    private int level;

    public Worker(String name, int age, String gender, String address, int level) {
        super(name, age, gender, address);
        this.level = level;
    }

    public Worker() {
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String displayInfor() {
        return "Worker [" + super.displayInfor() + " ,level=" + level + "]";
    }
}
