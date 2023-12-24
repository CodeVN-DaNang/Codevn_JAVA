public class Student extends Person {
    private String clasS;
    private double avg;

    public Student() {
    }

    public Student(int id, String name, String age, String gender, String phone, String clasS, double avg) {
        super(id, name, age, gender, phone);
        this.clasS = clasS;
        this.avg = avg;
    }

    public String getClasS() {
        return clasS;
    }

    public void setClasS(String clasS) {
        this.clasS = clasS;
    }

    public double getAvg() {
        return avg;
    }

    public void setAvg(double avg) {
        this.avg = avg;
    }

}
