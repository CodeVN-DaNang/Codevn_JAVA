package model.entity;

public class Product {
    private String idProduct;
    private String nameProduct;
    private float price;

    public Product() {
    }

    public Product(String idProduct, String nameProduct, float price) {
        this.idProduct = idProduct;
        this.nameProduct = nameProduct;
        this.price = price;
    }

    public String getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(String idProduct) {
        this.idProduct = idProduct;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product [idProduct=" + idProduct + ", nameProduct=" + nameProduct + ", price=" + price + "]";
    }
}
