package demo;

public class Main {
    public static void main(String[] args) {
        Student student1 = new Student("Khanh",20,"HoaXuan","Unknown",4.8,9.0,3.0);
        Student student2 = new Student("Huy",20,"CamLe","Man",5.0,8.0,7.5);
        System.out.println(student1.calculateAvg());

        student2.display();
        
    }
}
