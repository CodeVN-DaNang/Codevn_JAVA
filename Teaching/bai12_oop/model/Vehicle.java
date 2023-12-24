package model;

public class Vehicle {
    private int id;
    private String manufacturer;
    private String year;
    private int price;
    private String color;
    
    public Vehicle(int id, String manufacturer, String year, int price, String color) {
        this.id = id;
        this.manufacturer = manufacturer;
        this.year = year;
        this.price = price;
        this.color = color;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Vehicle [id=" + id + ", manufacturer=" + manufacturer + ", year=" + year + ", price=" + price
                + ", color=" + color + "]";
    }
}
