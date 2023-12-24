package model.entity;

public class Customer {
    private int customerId;
    private String name;
    private String email;
    private String phone;
    private String username;
    private String password;
    private TypeCustomer typeCustomer;

    public Customer(int customerId, String name, String email, String phone, String username, String password,
            TypeCustomer typeCustomer) {
        this.customerId = customerId;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.username = username;
        this.password = password;
        this.typeCustomer = typeCustomer;
    }

    public Customer() {
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public TypeCustomer getTypeCustomer() {
        return typeCustomer;
    }

    public void setTypeCustomer(TypeCustomer typeCustomer) {
        this.typeCustomer = typeCustomer;
    }

    @Override
    public String toString() {
        return "Customer [customerId=" + customerId + ", name=" + name + ", email=" + email + ", phone=" + phone
                + ", username=" + username + ", password=" + password + ", typeCustomer=" + typeCustomer + "]";
    }
}
