package model.entities;

public class TypeEmployee {
    int idType;
    String nameType;
    int salary;

    public TypeEmployee(int idType, String nameType, int salary) {
        this.idType = idType;
        this.nameType = nameType;
        this.salary = salary;
    }

    public TypeEmployee() {
    }

    public int getIdType() {
        return idType;
    }

    public void setIdType(int idType) {
        this.idType = idType;
    }

    public String getNameType() {
        return nameType;
    }

    public void setNameType(String nameType) {
        this.nameType = nameType;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "TypeEmployee [idType=" + idType + ", nameType=" + nameType + ", salary=" + salary + "]";
    }
}
