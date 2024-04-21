package demo;

public class Student {
    String name;
    int age;
    String address;
    String gender;
    double markMath;
    double markPhysics;
    double markChemical;

    public Student(String name, int age, String address, String gender, double markMath, double markPhysics,
            double markChemical) {
        this.name = name;
        this.age = age;
        this.address = address;
        this.gender = gender;
        this.markMath = markMath;
        this.markPhysics = markPhysics;
        this.markChemical = markChemical;
    }

    public Student() {
    }

    public double calculateAvg(){
        return (this.markMath + this.markPhysics + this.markChemical)/3;
    }

    public void display() {
        System.out.println( "Student [name=" + name + ", age=" + age + ", address=" + address + ", gender=" + gender + ", markMath="
                + markMath + ", markPhysics=" + markPhysics + ", markChemical=" + markChemical + "]");
    }

    

}
