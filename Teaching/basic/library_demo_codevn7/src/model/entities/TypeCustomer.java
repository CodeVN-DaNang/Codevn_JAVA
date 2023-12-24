package model.entities;

public class TypeCustomer {
    private String typeCustomerId;
    private String typeCustomerName;

    public TypeCustomer(String typeCustomerId, String typeCustomerName) {
        this.typeCustomerId = typeCustomerId;
        this.typeCustomerName = typeCustomerName;
    }

    public TypeCustomer() {
    }

    public String getTypeCustomerId() {
        return typeCustomerId;
    }

    public void setTypeCustomerId(String typeCustomerId) {
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
