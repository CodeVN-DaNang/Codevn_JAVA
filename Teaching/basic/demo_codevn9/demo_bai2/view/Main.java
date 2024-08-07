package view;

import controller.HomeController;

public class Main {
    public static void main(String[] args) {
        HomeController homeController = new HomeController();
        while (true) {
            homeController.displayMenu();
        }
        
        
    }
}
