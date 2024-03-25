import java.util.Scanner;
import java.util.ArrayList;

public class BaiTapThem {
    static Scanner sc = new Scanner(System.in);
    static ArrayList<String> studentList = new ArrayList<>();

    public static void main(String[] args) {
        studentList.add("Huy");

        while (true) {
            System.out.println("----MENU----\n"
                    + "1. add new student\n"
                    + "2. update student\n"
                    + "3. delete student\n"
                    + "4. display all student\n"
                    + "5. search student\n"
                    + "6. exit");
            int key = Integer.parseInt(sc.nextLine());
            switch (key) {
                case 1:
                    addNewStudent();
                    break;
                case 2:
                    updateStudent();
                    break;
                case 3:
                    deleteStudent();
                    break;
                case 4:
                    displayStudent();
                    break;
                case 5:
                    searchStudent();
                    break;
                case 6:
                    System.exit(1);
                    break;
                default:
                    break;
            }
            System.out.println("Total students: " + studentList.size());
            ;
        }

    }

    private static void searchStudent() {
        System.out.println("Input name: ");
        String find = sc.nextLine();
        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).contains(find)) { // "Khanh" "Khanh"
                System.out.println("index: " + i);
            }
        }
    }

    private static void displayStudent() {
        // cach 1
        for (int i = 0; i < studentList.size(); i++) {
            System.out.println(studentList.get(i));
        }
        // cach 2
        for (String string : studentList) {
            System.out.println(string);
        }
        // cach 3
        System.out.println(studentList.toString());
    }

    private static void deleteStudent() {
        System.out.println("Input index of student: ");
        int index = Integer.parseInt(sc.nextLine());
        studentList.remove(index);
    }

    private static void updateStudent() {
        System.out.println("Input index of student: ");
        int index = Integer.parseInt(sc.nextLine());
        System.out.println("Input new name to update: ");
        String name = sc.nextLine();
        studentList.set(index, name);
    }

    static void addNewStudent() {
        System.out.println("Input number of student to add: ");
        int n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n; i++) {
            System.out.println("Input name of student:");
            String name = sc.nextLine();
            studentList.add(name);
        }

    }
}
