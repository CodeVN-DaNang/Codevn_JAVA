package model;

public class Truck extends Vehicle {
    private double weight;

    public Truck(int id, String manufacturer, String year, int price, String color, double weight) {
        super(id, manufacturer, year, price, color);
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Truck [weight=" + weight + super.toString() +  "]";
    }
    
}
