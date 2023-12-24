package main.controller;

import java.util.Scanner;

import main.model.service.MotorService;

public class MotorController {
    MotorService motorService = new MotorService();

    public void displayMenuMotor() throws Exception {
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("---MENU---\n"
                    + "1. display all");
            int key = Integer.parseInt(sc.nextLine());
            switch (key) {
                case 1:
                    displayAllMotors();
                    break;

                default:
                    break;
            }
        }

    }

    private void displayAllMotors() throws Exception {
        motorService.findAllMotor();
    }
}
