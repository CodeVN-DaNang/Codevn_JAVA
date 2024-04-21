/**
 * Product
 */
public class Product {

    String productId;
    String productType;
    int amount;
    String manufacturer;
    double price;
    
    public Product(String productId, String productType, int amount, String manufacturer, double price) {
        this.productId = productId;
        this.productType = productType;
        this.amount = amount;
        this.manufacturer = manufacturer;
        this.price = price;
    }

    public Product() {
    }

    public void setAmount(int amount){
        this.amount = amount;
    }

    public void display() {
        System.out.println( "Product [productId=" + productId + ", productType=" + productType + ", amount=" + amount
                + ", manufacturer=" + manufacturer + ", price=" + price + "]");
    }

    

}