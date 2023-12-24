package controller;

import java.util.ArrayList;
import java.util.Scanner;

import model.Bike;
import model.Car;
import model.Truck;
import model.Vehicle;

public class VehicleController {
    // displayMenu, addVehicle, deleteVehicle(id), findVehicle(manufacturer||color)

    ArrayList<Vehicle> vehicles = new ArrayList<>();
    Scanner sc = new Scanner(System.in);

    public void displayMenu() {
        System.out.println("----MENU----\n"
            + "1. add new vehicle.\n"
            + "2. delete vehicle.\n"
            + "3. find vehicle.\n"
            + "4. exit"
        ); 
        System.out.println("Input choice:");
        int key = Integer.parseInt(sc.nextLine());
        switch (key) {
            case 1:
                addNewVehicle();
                break;
            case 2:
                deleteVehicle();
                break;
            case 3:
                findVehicle();
                break;
            case 4:
                System.exit(1);
            default:
                break;
        }
        findAll();
    }

    private void findAll(){
        for (int i = 0; i < vehicles.size(); i++) {
            System.out.println(vehicles.get(i).toString());
        }
    }

    private void findVehicle() {
        System.out.println("What things you want to search ?\n"
                + "1. Color\n"
                + "2. Brand\n"
                + "Anny number to Exit\n");
        int key = Integer.parseInt(sc.nextLine());
        switch (key) {
            case 1:
                System.out.println("what color you want to search ?");
                String color = sc.nextLine();
                int count = 0;
                for (int i = 0; i < vehicles.size(); i++) {
                    if (color.equals(vehicles.get(i).getColor())) {
                        System.out.println(vehicles.get(i).toString());
                        count++;
                    }
                }
                System.out.println(count + "vehicel have this color");
                break;
            case 2:
                System.out.println("What brand you want to search ?");
                String brand = sc.nextLine();
                count = 0;
                for (int i = 0; i < vehicles.size(); i++) {
                    if (brand.equals(vehicles.get(i).getManufacturer())) {
                        System.out.println(vehicles.get(i).toString());
                        count++;
                    }
                }
                System.out.println(count + "vehicel have this brand");
                break;
            default:
                return;
        }
    }

    private void deleteVehicle() {
        System.out.println("Input ID vehicel to delete:");
        int id = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < vehicles.size(); i++) {
            if (vehicles.get(i).getId() == id) {
                vehicles.remove(i);
                System.out.println("Delete success ^_^");
                return;
            }
        }
        System.out.println("Delete fail T_T");
    }

    private void addNewVehicle() {
        System.out.println("Input ID vehicel :");
        int id = Integer.parseInt(sc.nextLine());
        System.out.println("Input Brand vehicel :");
        String brand = sc.nextLine();
        System.out.println("Input Year vehicel :");
        String year = sc.nextLine();
        System.out.println("Input Color vehicel :");
        String color = sc.nextLine();
        System.out.println("Input Price vehicel :");
        int price = Integer.parseInt(sc.nextLine());
        System.out.println("What type of vehicel you want to add ?\n"
                + "1. Car\n"
                + "2. Bike\n"
                + "3. Truck\n"
                + "Anny number to Exit\n");
        int key = Integer.parseInt(sc.nextLine());
        switch (key) {
            case 1:
                System.out.println("Input place to seat of car :");
                int seat = Integer.parseInt(sc.nextLine());
                System.out.println("Input type of machine  of car:");
                String machine = sc.nextLine();
                Car car = new Car(id, brand, year, price, color, seat, machine);
                vehicles.add(car);
                System.out.println("add car succesfull !");
                break;
            case 2:
                System.out.println("Input power of bike :");
                String power = sc.nextLine();
                Bike bike = new Bike(id, brand, year, price, color, power);
                vehicles.add(bike);
                System.out.println("add bike succesfull !");
                break;
            case 3:
                System.out.println("Input weight of Truck :");
                double weight = Double.parseDouble(sc.nextLine());
                Truck truck = new Truck(id, brand, year, price, color, weight);
                vehicles.add(truck);
                System.out.println("add truck succesfull !");
                break;
        }
    }



}
