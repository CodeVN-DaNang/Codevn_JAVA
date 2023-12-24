package model.entity;

public class Customer {
    private int idCustomer;
    private String nameCustomer;
    private long price;
    private TypeCustomer typeCustomer;

    public Customer(int idCustomer, String nameCustomer, long price, TypeCustomer typeCustomer) {
        this.idCustomer = idCustomer;
        this.nameCustomer = nameCustomer;
        this.price = price;
        this.typeCustomer = typeCustomer;
    }

    public int getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(int idCustomer) {
        this.idCustomer = idCustomer;
    }

    public String getNameCustomer() {
        return nameCustomer;
    }

    public void setNameCustomer(String nameCustomer) {
        this.nameCustomer = nameCustomer;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public TypeCustomer getTypeCustomer() {
        return typeCustomer;
    }

    public void setTypeCustomer(TypeCustomer typeCustomer) {
        this.typeCustomer = typeCustomer;
    }

    @Override
    public String toString() {
        return "Customer [idCustomer=" + idCustomer + ", nameCustomer=" + nameCustomer + ", price=" + price
                + ", typeCustomer=" + typeCustomer + "]";
    }
}
