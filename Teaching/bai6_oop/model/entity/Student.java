package model.entity;

public class Student {
    private String name;
    private String age;
    private String town;
    private ClasS clasS;
    public Student(String name, String age, String town, ClasS clasS) {
        this.name = name;
        this.age = age;
        this.town = town;
        this.clasS = clasS;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getAge() {
        return age;
    }
    public void setAge(String age) {
        this.age = age;
    }
    public String getTown() {
        return town;
    }
    public void setTown(String town) {
        this.town = town;
    }
    public ClasS getClasS() {
        return clasS;
    }
    public void setClasS(ClasS clasS) {
        this.clasS = clasS;
    }
    @Override
    public String toString() {
        return "Student [name=" + name + ", age=" + age + ", town=" + town + ", clasS=" + clasS.toString() + "]";
    }
}
