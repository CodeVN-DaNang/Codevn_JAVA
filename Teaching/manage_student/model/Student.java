package manage_student.model;

public class Student {
    // Số báo danh, họ tên, địa chỉ, mức ưu tiên.
    private String idStudent;
    private String nameStudent;
    private String address;
    private int priority;
    private Major major;

    public Student(){}

    
    public Student(String idStudent, String nameStudent, String address, int priority, Major major) {
        this.idStudent = idStudent;
        this.nameStudent = nameStudent;
        this.address = address;
        this.priority = priority;
        this.major = major;
    }


    public String getIdStudent() {
        return idStudent;
    }


    public void setIdStudent(String idStudent) {
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


    public int getPriority() {
        return priority;
    }


    public void setPriority(int priority) {
        this.priority = priority;
    }


    public Major getMajor() {
        return major;
    }


    public void setMajor(Major major) {
        this.major = major;
    }


    @Override
    public String toString() {
        return "Student [idStudent=" + idStudent + ", nameStudent=" + nameStudent + ", address=" + address
                + ", priority=" + priority + ", major=" + major.toString() + "]";
    }

    

}
