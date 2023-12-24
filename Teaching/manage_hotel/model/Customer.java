package manage_hotel.model;

public class Customer {
    private String nameCustomer;
    private String age;
    private String idCard;

    public Customer(String nameCustomer, String age, String idCard) {
        this.nameCustomer = nameCustomer;
        this.age = age;
        this.idCard = idCard;
    }

    public String getNameCustomer() {
        return nameCustomer;
    }
    public void setNameCustomer(String nameCustomer) {
        this.nameCustomer = nameCustomer;
    }
    public String getAge() {
        return age;
    }
    public void setAge(String age) {
        this.age = age;
    }
    public String getIdCard() {
        return idCard;
    }
    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }
    
    @Override
    public String toString() {
        return "Customer [nameCustomer=" + nameCustomer + ", age=" + age + ", idCard=" + idCard + "]";
    }

    
}
