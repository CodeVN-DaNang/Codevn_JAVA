public class Product {
    private int id;
    private String name;
    private String code;
    private String dayProduce;
    private String importDate;
    private int quality;
    private double price;

    public Product() {
    }

    public Product(int id, String name, String code, String dayProduce, String importDate, int quality, double price) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.dayProduce = dayProduce;
        this.importDate = importDate;
        this.quality = quality;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDayProduce() {
        return dayProduce;
    }

    public void setDayProduce(String dayProduce) {
        this.dayProduce = dayProduce;
    }

    public String getImportDate() {
        return importDate;
    }

    public void setImportDate(String importDate) {
        this.importDate = importDate;
    }

    public int getQuality() {
        return quality;
    }

    public void setQuality(int quality) {
        this.quality = quality;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void buyProduct(int buyAmount){
        if (buyAmount < 0) {
            System.out.println("so luong mua >0");
            return;
        }
        if (buyAmount > this.quality) {
            System.out.println("San pham khong du");
            return;
        }
        this.quality = this.quality - buyAmount;
        double money = buyAmount * price;
        System.out.println("So tien phai tra la: " + money);
    }

    public void display() {
        System.out.println("Product [id=" + id + ", name=" + name + ", code=" + code + ", dayProduce=" + dayProduce
                + ", importDate=" + importDate + ", quality=" + quality + ", price=" + price + "]");
    }

}
