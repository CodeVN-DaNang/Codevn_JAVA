package model.entities;

public class Employee {
    int id;
    String name;
    String gender;
    TypeEmployee[[]] typeEmployee;

    public Employee(int id, String name, String gender, TypeEmployee typeEmployee) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.typeEmployee = typeEmployee;
    }

    public Employee() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public TypeEmployee getTypeEmployee() {
        return typeEmployee;
    }

    public void setTypeEmployee(TypeEmployee typeEmployee) {
        this.typeEmployee = typeEmployee;
    }

    @Override
    public String toString() {
        return "Employee [id=" + id + ", name=" + name + ", gender=" + gender + ", typeEmployee=" + typeEmployee + "]";
    }
}
