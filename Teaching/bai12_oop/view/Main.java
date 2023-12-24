package view;

import controller.VehicleController;

public class Main {
    static VehicleController vehicleController = new VehicleController();
    public static void main(String[] args) {
        while (true) {
            vehicleController.displayMenu();
        }
    }
}
