/**
 * User
 */
public class User implements Comparable<User> {
    private int id;
    private String name;
    private String dateOfBirth;
    private String gender;
    private String address;
    private String phone;
    private String email;

    public User(int id, String name, String dateOfBirth, String gender, String address, String phone, String email) {
        this.id = id;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.address = address;
        this.phone = phone;
        this.email = email;
    }

    public User() {
    }

    

    public void display() {
        System.out.println("User [id=" + id + ", name=" + name + ", dateOfBirth=" + dateOfBirth + ", gender=" + gender
                + ", address=" + address + ", phone=" + phone + ", email=" + email + "]");
    }

    @Override
    public int compareTo(User u) {
        return this.name.compareTo(u.name); // 65-95 = -30
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}