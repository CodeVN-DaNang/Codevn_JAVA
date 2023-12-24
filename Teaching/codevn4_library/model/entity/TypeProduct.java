package model.entity;

public class TypeProduct {
    private int typeProductId;
    private String typeProductName;

    public TypeProduct() {
    }

    public TypeProduct(int typeProductId, String typeProductName) {
        this.typeProductId = typeProductId;
        this.typeProductName = typeProductName;
    }

    public int getTypeProductId() {
        return typeProductId;
    }

    public void setTypeProductId(int typeProductId) {
        this.typeProductId = typeProductId;
    }

    public String getTypeProductName() {
        return typeProductName;
    }

    public void setTypeProductName(String typeProductName) {
        this.typeProductName = typeProductName;
    }

    @Override
    public String toString() {
        return "TypeProduct [typeProductId=" + typeProductId + ", typeProductName=" + typeProductName + "]";
    }

}
