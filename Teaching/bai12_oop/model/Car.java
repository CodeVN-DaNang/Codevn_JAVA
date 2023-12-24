package model;

public class Car extends Vehicle{
    private int seat;
    private String power;
    
    public Car(int id, String manufacturer, String year, int price, String color, int seat, String power) {
        super(id, manufacturer, year, price, color);
        this.seat = seat;
        this.power = power;
    }

    public int getSeat() {
        return seat;
    }

    public void setSeat(int seat) {
        this.seat = seat;
    }

    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power;
    }

    @Override
    public String toString() {
        return "Car [seat=" + seat + ", power=" + power + super.toString() +"]";
    }

}
