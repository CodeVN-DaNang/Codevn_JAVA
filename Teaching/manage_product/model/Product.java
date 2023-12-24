package manage_product.model;

public class Product {
    // atribute
    private String idProduct;
    private String nameProduct;
    private String category;
    private String manufacturer;
    private String inputDay;
    private long price;

    // constructor
    public Product(String idProduct, String nameProduct, String category, String manufacturer, String inputDay,
            long price) {
        this.idProduct = idProduct;
        this.nameProduct = nameProduct;
        this.category = category;
        this.manufacturer = manufacturer;
        this.inputDay = inputDay;
        this.price = price;
    }

    // method
    public void displayInfor(){
        System.out.println("San pham: " + this.idProduct + " ten san pham: " + this.nameProduct + " ngay nhap vao " + this.inputDay);
    }

    
}
