package model.entity;

public class Worker extends Employee {
    private int level;

    

    public Worker(int id, String name, int age, String gender, String address, int level) {
        super(id, name, age, gender, address);
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

    @Override
    public String toString() {
        return "Worker ["+ super.toString() + "level=" + level + "]";
    }
}
