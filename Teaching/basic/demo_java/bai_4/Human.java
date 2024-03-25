package bai_4;

public class Human {
    private String name;
    private int age;
    private String job;
    private String id;
    private Home home;

    public Human(String name, int age, String job, String id, Home home) {
        this.name = name;
        this.age = age;
        this.job = job;
        this.id = id;
        this.home = home;
    }

    public Human() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Home getHome() {
        return home;
    }

    public void setHome(Home home) {
        this.home = home;
    }

    @Override
    public String toString() {
        return "Human [name=" + name + ", age=" + age + ", job=" + job + ", id=" + id + ", home=" + home.toString()
                + "]";
    }

}
