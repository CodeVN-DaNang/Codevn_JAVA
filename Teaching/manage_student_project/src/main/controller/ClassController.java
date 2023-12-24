package main.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

import main.model.entity.ClasS;
import main.model.service.ClassService.ClassService;

public class ClassController {
    ClassService classService = new ClassService();
    private ArrayList<ClasS> cList = new ArrayList<>();

    public void displayClassMenu() {
        while (true) {
            cList = classService.findAllClass();
            System.out.println("----MENU CLASS----\n"
                    + "1. display all classes.\n"
                    + "2. search\n"
                    + "3. add new class\n"
                    + "4. delete class\n"
                    + "5. edit class\n"
                    + "6. back to main menu");
            Scanner sc = new Scanner(System.in);
            int key = Integer.parseInt(sc.nextLine());
            switch (key) {
                case 1:
                    findAllClass();
                    break;
                case 2:
                    searchClasses();
                    break;
                case 3:
                    addNewClass();
                    break;
                case 4:
                    deleteClass();
                    break;
                case 5:
                    updateClass();
                    break;
                case 6:
                    return;
                default:
                    break;
            }
        }
    }

    public ClasS findClassById(int idClass) {
        for (int i = 0; i < cList.size(); i++) {
            if (cList.get(i).getIdClass() == idClass) {
                return cList.get(i);
            }
        }
        return null;
    }

    private void searchClasses() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input name to search:");
        String name = sc.nextLine();
        ArrayList<ClasS> searchClasSs = new ArrayList<>();
        for (int i = 0; i < cList.size(); i++) {
            if (cList.get(i).getNameClass().equals(name)) {
                ClasS newClass = findClassById(cList.get(i).getIdClass());
                searchClasSs.add(newClass);
                System.out.println(i + "   " + newClass.toString());
            }
        }
    }

    private void updateClass() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input id of class to update:");
        int idClass = Integer.parseInt(sc.nextLine());
        ClasS newClass = findClassById(idClass);
        System.out.println("Input name to edit:");
        String nameClass = sc.nextLine();
        if (!nameClass.equals("")) {
            newClass.setNameClass(nameClass);
        }
        System.out.println("Input startdate:");
        String startDate = sc.nextLine();
        if (!startDate.equals("")) {
            newClass.setStartDate(startDate);
        }
        System.out.println("Input status:");
        Boolean status = Boolean.parseBoolean(sc.nextLine());
        classService.updateClass(newClass);
    }

    private void deleteClass() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input id want to delete:");
        int idClass = Integer.parseInt(sc.nextLine());
        classService.deleteClass(idClass);
    }

    private void addNewClass() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input name:");
        String nameClass = sc.nextLine();
        LocalDate localDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy LLLL dd");
        String startDate = localDate.format(formatter);
        ClasS newClass = new ClasS(nameClass, startDate, true);
        classService.addNewClass(newClass);
    }

    private void findAllClass() {
        if (cList.size() > 0) {
            for (int i = 0; i < this.cList.size(); i++) {
                System.out.println(cList.get(i).toString());
            }
        } else {
            System.out.println("404-khong tim thay gia tri nao het");
        }
    }
}
