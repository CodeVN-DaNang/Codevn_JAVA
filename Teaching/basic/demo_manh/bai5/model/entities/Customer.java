package model.entities;

/**
 * Customer
 */
public class Customer {

    // Họ tên, tuổi, số chứng minh nhân dân.
    private String name;
    private int age;
    private String id;

    public Customer(String name, int age, String id) {
        this.name = name;
        this.age = age;
        this.id = id;
    }

    public Customer() {
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Customer [name=" + name + ", age=" + age + ", id=" + id + "]";
    }

}