package demo_bai2.view;

import demo_bai2.controller.PeopleController;

public class Main {
    public static void main(String[] args) {
        PeopleController peopleController = new PeopleController();
        while (true) {
            peopleController.displayMenu();
        }
        
    }
}
