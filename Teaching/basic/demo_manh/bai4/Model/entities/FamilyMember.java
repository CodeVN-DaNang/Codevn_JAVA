package bai4.Model.entities;

public class FamilyMember {
    // Họ tên, Tuổi, Nghề nghiệp,
    // số chứng minh nhân dân(duy nhất cho mỗi người).
    private String name;
    private int age;
    private String job;
    private String id;
    private Family family;

    public FamilyMember(String name, int age, String job, String id, Family family) {
        this.name = name;
        this.age = age;
        this.job = job;
        this.id = id;
        this.family = family;
    }

    public FamilyMember() {
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

    public Family getFamily() {
        return family;
    }

    public void setFamily(Family family) {
        this.family = family;
    }

    @Override
    public String toString() {
        return "FamilyMember [name=" + name + ", age=" + age + ", job=" + job + ", id=" + id + ", family=" + family.toString()
                + "]";
    }

}
