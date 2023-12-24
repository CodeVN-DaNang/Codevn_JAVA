public class Customer {
    // Họ tên, tuổi, số chứng minh nhân dân.
    private String name;
    private int age;
    private String idCustomer;

    public Customer(String name, int age, String idCustomer) {
        this.name = name;
        this.age = age;
        this.idCustomer = idCustomer;
    }

    public Customer() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(String idCustomer) {
        this.idCustomer = idCustomer;
    }

    @Override
    public String toString() {
        return "Customer [name=" + name + ", age=" + age + ", idCustomer=" + idCustomer + "]";
    }
}
