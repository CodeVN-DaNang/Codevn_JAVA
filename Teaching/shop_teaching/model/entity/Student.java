package model.entity;

public class Student {
    private String name;
    private ClasS clasS;
    private String dateOfBirth;
    private String gender;
    private String phonenumber;
    private String email;
    private String address;
    public Student(String name, ClasS clasS, String dateOfBirth, String gender, String phonenumber, String email,
            String address) {
        this.name = name;
        this.clasS = clasS;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.phonenumber = phonenumber;
        this.email = email;
        this.address = address;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public ClasS getClasS() {
        return clasS;
    }
    public void setClasS(ClasS clasS) {
        this.clasS = clasS;
    }
    public String getDateOfBirth() {
        return dateOfBirth;
    }
    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public String getPhonenumber() {
        return phonenumber;
    }
    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    @Override
    public String toString() {
        return "Student [name=" + name + ", clasS=" + clasS.toString() + ", dateOfBirth=" + dateOfBirth + ", gender=" + gender
                + ", phonenumber=" + phonenumber + ", email=" + email + ", address=" + address + "]";
    }
}
