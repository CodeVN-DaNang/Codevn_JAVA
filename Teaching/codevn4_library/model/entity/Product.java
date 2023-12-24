package model.entity;

public class Product {
    private int productId;
    private String productName;
    private String productCode;
    private String importDay;
    private String exportDay;
    private String manufacturer;
    private TypeProduct typeProduct;
    private String price;

    public Product(int productId, String productName, String productCode, String importDay, String exportDay,
            String manufacturer, TypeProduct typeProduct, String price) {
        this.productId = productId;
        this.productName = productName;
        this.productCode = productCode;
        this.importDay = importDay;
        this.exportDay = exportDay;
        this.manufacturer = manufacturer;
        this.typeProduct = typeProduct;
        this.price = price;
    }

    public Product() {
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getImportDay() {
        return importDay;
    }

    public void setImportDay(String importDay) {
        this.importDay = importDay;
    }

    public String getExportDay() {
        return exportDay;
    }

    public void setExportDay(String exportDay) {
        this.exportDay = exportDay;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public TypeProduct getTypeProduct() {
        return typeProduct;
    }

    public void setTypeProduct(TypeProduct typeProduct) {
        this.typeProduct = typeProduct;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product [productId=" + productId + ", productName=" + productName + ", productCode=" + productCode
                + ", importDay=" + importDay + ", exportDay=" + exportDay + ", manufacturer=" + manufacturer
                + ", typeProduct=" + typeProduct + ", price=" + price + "]";
    }

}
