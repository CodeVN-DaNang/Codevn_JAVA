package model;

public class Employee {
    // id, name, phone, email, coefficients salary (float) and employee type
    private int idEmployee;
    private String nameEmployee;
    private String phone;
    private String email;
    private float coefficientsSalary;
    public Employee(int idEmployee, String nameEmployee, String phone, String email, float coefficientsSalary) {
        this.idEmployee = idEmployee;
        this.nameEmployee = nameEmployee;
        this.phone = phone;
        this.email = email;
        this.coefficientsSalary = coefficientsSalary;
    }
    public int getIdEmployee() {
        return idEmployee;
    }
    public void setIdEmployee(int idEmployee) {
        this.idEmployee = idEmployee;
    }
    public String getNameEmployee() {
        return nameEmployee;
    }
    public void setNameEmployee(String nameEmployee) {
        this.nameEmployee = nameEmployee;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public float getCoefficientsSalary() {
        return coefficientsSalary;
    }
    public void setCoefficientsSalary(float coefficientsSalary) {
        this.coefficientsSalary = coefficientsSalary;
    }
    public float calculateSalary(){
        return 0;
    }
    @Override
    public String toString() {
        return "Employee [idEmployee=" + idEmployee + ", nameEmployee=" + nameEmployee + ", phone=" + phone + ", email="
                + email + ", coefficientsSalary=" + coefficientsSalary + "]";
    }
}
