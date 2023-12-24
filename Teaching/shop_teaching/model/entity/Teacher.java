package model.entity;

public class Teacher {
    private String name;
    private String subject;
    private String dateOfBirth;
    private String gender;
    private String phonenumber;
    private String email;
    private String address;
    public Teacher(String name, String subject, String dateOfBirth, String gender, String phonenumber, String email,
            String address) {
        this.name = name;
        this.subject = subject;
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
    public String getSubject() {
        return subject;
    }
    public void setSubject(String subject) {
        this.subject = subject;
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
        return "Teacher [name=" + name + ", subject=" + subject + ", dateOfBirth=" + dateOfBirth + ", gender=" + gender
                + ", phonenumber=" + phonenumber + ", email=" + email + ", address=" + address + "]";
    }
    
}
