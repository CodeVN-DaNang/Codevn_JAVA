package model.entity;

public class TypeCustomer {
    private int typeCustomerId;
    private String typeCustomerName;

    public TypeCustomer(int typeCustomerId, String typeCustomerName) {
        this.typeCustomerId = typeCustomerId;
        this.typeCustomerName = typeCustomerName;
    }

    public TypeCustomer() {
    }

    public int getTypeCustomerId() {
        return typeCustomerId;
    }

    public void setTypeCustomerId(int typeCustomerId) {
        this.typeCustomerId = typeCustomerId;
    }

    public String getTypeCustomerName() {
        return typeCustomerName;
    }

    public void setTypeCustomerName(String typeCustomerName) {
        this.typeCustomerName = typeCustomerName;
    }

    @Override
    public String toString() {
        return "TypeCustomer [typeCustomerId=" + typeCustomerId + ", typeCustomerName=" + typeCustomerName + "]";
    }
}
