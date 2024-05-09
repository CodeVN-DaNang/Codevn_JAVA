import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);
    static ArrayList<Block> blockList = new ArrayList<>();
    static ArrayList<Student> studentList = new ArrayList<>();

    public static void main(String[] args) {
        blockList.add(new Block("Block A", "Math, Physics, Chemical"));
        blockList.add(new Block("Block B", "Math, Biology, Chemical"));
        blockList.add(new Block("Block C", "Literature, Geomitry, History"));
        while (true) {
            System.out.println("----MENU----\n"
                    + "Thêm mới thí sinh.\n" + //
                    "Hiện thị thông tin của thí sinh và khối thi của thí sinh.\n" + //
                    "Tìm kiếm theo số báo danh.\n" + //
                    "Thoát khỏi chương trình.");
            int key = Integer.parseInt(sc.nextLine());
            switch (key) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    display();
                    break;
                case 3:
                    search();
                    break;
                case 4:
                    System.exit(0);
                default:
                    break;
            }
        }

    }

    private static void search() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'search'");
    }

    private static void display() {
        for (int i = 0; i < studentList.size(); i++) {
            System.out.println(studentList.get(i).toString());
        }
    }

    private static void addStudent() {
        System.out.println("Input code:");
        String code = sc.nextLine();
        System.out.println("Input name:");
        String name = sc.nextLine();
        System.out.println("Input address:");
        String address = sc.nextLine();
        System.out.println("Input priority:");
        String priority = sc.nextLine();
        System.out.println("----Choose block----:");
        for (int i = 0; i < blockList.size(); i++) {
            System.out.println(i + ". " + blockList.get(i).getBlockName());
        }
        int keyBlock = Integer.parseInt(sc.nextLine());
        Student student = new Student(code, name, address, priority, blockList.get(keyBlock));
        studentList.add(student);
    }
}
