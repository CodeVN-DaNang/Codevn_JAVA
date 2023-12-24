package main.model.entity;

public class Student {
    private int idStudent;
    private String nameStudent;
    private String address;
    private String phone;
    private boolean status;
    private ClasS classId;
    public Student(int idStudent, String nameStudent, String address, String phone, boolean status, ClasS classId) {
        this.idStudent = idStudent;
        this.nameStudent = nameStudent;
        this.address = address;
        this.phone = phone;
        this.status = status;
        this.classId = classId;
    }
    public Student(String nameStudent, String address, String phone, boolean status, ClasS classId) {
        this.nameStudent = nameStudent;
        this.address = address;
        this.phone = phone;
        this.status = status;
        this.classId = classId;
    }
    public int getIdStudent() {
        return idStudent;
    }
    public void setIdStudent(int idStudent) {
        this.idStudent = idStudent;
    }
    public String getNameStudent() {
        return nameStudent;
    }
    public void setNameStudent(String nameStudent) {
        this.nameStudent = nameStudent;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public boolean isStatus() {
        return status;
    }
    public void setStatus(boolean status) {
        this.status = status;
    }
    public ClasS getClassId() {
        return classId;
    }
    public void setClassId(ClasS classId) {
        this.classId = classId;
    }
    @Override
    public String toString() {
        return "Student [nameStudent=" + nameStudent + ", address=" + address + ", phone="
                + phone + ", status=" + status + ", classId=" + classId.toString() + "]";
    }
    
}
