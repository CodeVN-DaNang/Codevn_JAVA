package demo_bai2.model.entities;

public class Person {
    private String name;
    private int age;
    private String job;
    private String id;

    public Person() {
    }

    public Person(String name, int age, String job, String id) {
        this.name = name;
        this.age = age;
        this.job = job;
        this.id = id;
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

    @Override
    public String toString() {
        return "Person [name=" + name + ", age=" + age + ", job=" + job + ", id=" + id + "]";
    }

}
