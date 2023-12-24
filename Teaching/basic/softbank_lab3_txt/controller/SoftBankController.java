package controller;

import java.util.Scanner;

import model.entities.MidSoftBank;
import model.entities.NorthSoftBank;
import model.service.SoftBankService;

public class SoftBankController {
    static Scanner sc = new Scanner(System.in);
    static SoftBankService softBankService = new SoftBankService();

    public static void main(String[] args) {
        while (true) {
            System.out.println("----MENU----\n"
                    + "1. Add new softbank\n"
                    + "2. Delete softbank\n"
                    + "3. Update softbank\n"
                    + "4. Show all softbanks\n"
                    + "5. Find softbank\n"
                    + "6. Show estimate cost\n"
                    + "7. Exit");
            int key = Integer.parseInt(sc.nextLine());
            switch (key) {
                case 1:
                    addNewSoftBank();
                    break;
                case 2:
                    delete();
                    break;
                case 3:
                    update();
                    break;
                case 4:
                    showAll();
                    break;
                case 5:
                    find();
                    break;
                case 6:
                    showEstimateAndReal();
                    break;
                case 7:
                    return;
                default:
                    break;
            }
        }
    }

    public static void showEstimateAndReal() {
        for (NorthSoftBank softBank : softBankService.getAllSoftBanks()) {
            System.out.println(softBank.toString().split(" ")[0] + " name: " + softBank.getName() + " estimate cost: " + softBank.getSugPackage() + " real cost: " + softBank.getRealPackage());
        }
    }

    public static void find() {
        System.out.println("Input name to search:");
        String name = sc.nextLine();
        softBankService.getSoftBankByName(name);
    }

    public static void showAll() {
        for (NorthSoftBank softBank : softBankService.getAllSoftBanks()) {
            System.out.println(softBank.toString());
        }
    }

    public static void update() {
        System.out.println("Input id to update:");
        int id = Integer.parseInt(sc.nextLine());
        for (NorthSoftBank softBank : softBankService.getAllSoftBanks()) {
            if (softBank.getId() == id) {
                System.out.println(softBank.toString());
            }
        }
        System.out.println("Input name:");
        String name = sc.nextLine();
        System.out.println("Input date of birth:");
        String dateOfBirth = sc.nextLine();
        System.out.println("Input address:");
        String address = sc.nextLine();
        System.out.println("Input amount senior:");
        int amountSr = Integer.parseInt(sc.nextLine());
        System.out.println("Input amount junior:");
        int amountJr = Integer.parseInt(sc.nextLine());
        System.out.println("1. North soft bank\n"
            + "2. Mid softbank"
        );
        int choose = Integer.parseInt(sc.nextLine());
        NorthSoftBank softBank;
        if (choose == 1) {
            softBank = new NorthSoftBank(id, name, dateOfBirth, address, amountSr, amountJr);
        } else {
            System.out.println("Input amount collabrators:");
            int amountCrt = Integer.parseInt(sc.nextLine());
            softBank = new MidSoftBank(id, name, dateOfBirth, address, amountSr, amountJr, amountCrt);
        }
        softBankService.updateSoftBank(id, softBank);
    }

    public static void delete() {
        System.out.println("Input id to delete:");
        int id = Integer.parseInt(sc.nextLine());
        softBankService.deleteSoftBank(id);
    }

    public static void addNewSoftBank() {
        System.out.println("Input id:");
        int id = Integer.parseInt(sc.nextLine());
        System.out.println("Input name:");
        String name = sc.nextLine();
        System.out.println("Input date of birth:");
        String dateOfBirth = sc.nextLine();
        System.out.println("Input address:");
        String address = sc.nextLine();
        System.out.println("Input amount senior:");
        int amountSr = Integer.parseInt(sc.nextLine());
        System.out.println("Input amount junior:");
        int amountJr = Integer.parseInt(sc.nextLine());
        System.out.println("1. North soft bank\n"
            + "2. Mid softbank"
        );
        int choose = Integer.parseInt(sc.nextLine());
        if (choose == 1) {
            NorthSoftBank northSoftBank = new NorthSoftBank(id, name, dateOfBirth, address, amountSr, amountJr);
            softBankService.addSoftBank(northSoftBank);
        } else {
            System.out.println("Input amount collabrators:");
            int amountCrt = Integer.parseInt(sc.nextLine());
            NorthSoftBank softBank = new MidSoftBank(id, name, dateOfBirth, address, amountSr, amountJr, amountCrt);
            softBankService.addSoftBank(softBank);
        }
    }
}
