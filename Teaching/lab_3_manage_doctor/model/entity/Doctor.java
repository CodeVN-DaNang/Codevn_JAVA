package model.entity;

public class Doctor {
    private int idDoctor;
    private String nameDoctor;
    private String position;

    public Doctor(int idDoctor, String nameDoctor, String position) {
        this.idDoctor = idDoctor;
        this.nameDoctor = nameDoctor;
        this.position = position;
    }

    public int getIdDoctor() {
        return idDoctor;
    }

    public void setIdDoctor(int idDoctor) {
        this.idDoctor = idDoctor;
    }

    public String getNameDoctor() {
        return nameDoctor;
    }

    public void setNameDoctor(String nameDoctor) {
        this.nameDoctor = nameDoctor;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "Doctor [idDoctor=" + idDoctor + ", nameDoctor=" + nameDoctor + ", position=" + position + "]";
    }

}
