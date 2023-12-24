public class Employee {
    // Họ tên, tuổi, giới tính(name, nữ, khác), địa chỉ.
    private String nameEmployee;
    private String age;
    private String gender;
    private String address;


    // constructor
    public Employee(String nameEmployee, String age, String gender, String address) {
        this.nameEmployee = nameEmployee;
        this.age = age;
        this.gender = gender;
        this.address = address;
    }

    // getter setter
    public String getNameEmployee() {
        return nameEmployee;
    }

    public void setNameEmployee(String nameEmployee) {
        this.nameEmployee = nameEmployee;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    // method to display
    @Override
    public String toString() {
        return "Employee [nameEmployee=" + nameEmployee + ", age=" + age + ", gender=" + gender + ", address=" + address
                + "]";
    }

    
    
}
