package bai4.Controller;

import java.util.Scanner;

import bai4.Model.entities.Family;
import bai4.Model.entities.FamilyMember;
import bai4.Model.repo.FamilyMemberRepo;
import bai4.Model.repo.FamilyRepo;

public class Main {

    static FamilyMemberRepo familyMemberRepo = new FamilyMemberRepo();
    static FamilyRepo familyRepo = new FamilyRepo();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Input amount of families:");
        int n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n; i++) {
            System.out.println("Amount of members:");
            int memberAmount = Integer.parseInt(sc.nextLine());
            System.out.println("Input address:");
            String address = sc.nextLine();
            Family family = new Family(memberAmount, address);
            familyRepo.add(family);
            System.out.println("Input information of each member:");
            for (int j = 0; j < memberAmount; j++) {
                System.out.println("Input member" + j+1);
                System.out.println("Input name: ");
                String name = sc.nextLine();
                System.out.println("Input age:");
                int age = Integer.parseInt(sc.nextLine());
                System.out.println("Input job:");
                String job = sc.nextLine();
                System.out.println("input id:");
                String id = sc.nextLine();
                FamilyMember familyMember = new FamilyMember(name, age, job, id, family);
                familyMemberRepo.add(familyMember);
            }
        }
        for (Family family : familyRepo.getFamilies()) {
            System.out.println("----" + family.getAddress() + "----");
            for (FamilyMember familyMember : familyMemberRepo.getAll()) {
                if (family.getAddress().equals(familyMember.getFamily().getAddress())) {
                    System.out.println(familyMember.toString());
                }
            }
        }
    }
}
