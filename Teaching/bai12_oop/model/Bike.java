package model;

public class Bike extends Vehicle {
    private String power;

    public Bike(int id, String manufacturer, String year, int price, String color, String power) {
        super(id, manufacturer, year, price, color);
        this.power = power;
    }

    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power;
    }

    @Override
    public String toString() {
        return "Bike [power=" + power + super.toString() + "]";
    }


    
}
