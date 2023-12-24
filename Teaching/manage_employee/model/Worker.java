public class Worker extends Employee {
    private int level;

    // constructor
    public Worker(String nameEmployee, String age, String gender, String address, int level) {
        super(nameEmployee, age, gender, address);
        this.level = level;
    }

    // getter setter
    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    //display
    @Override
    public String toString() {
        return "Worker [level=" + level + super.toString() + "]";
    }

    

    
}
