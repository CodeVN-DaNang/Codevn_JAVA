package main.model.entity;

public class Motor {
    private int idMotor;
    private String nameMotor;
    public Motor(int idMotor, String nameMotor) {
        this.idMotor = idMotor;
        this.nameMotor = nameMotor;
    }
    public int getIdMotor() {
        return idMotor;
    }
    public void setIdMotor(int idMotor) {
        this.idMotor = idMotor;
    }
    public String getNameMotor() {
        return nameMotor;
    }
    public void setNameMotor(String nameMotor) {
        this.nameMotor = nameMotor;
    }
    @Override
    public String toString() {
        return idMotor + ", " + nameMotor;
    }
}
