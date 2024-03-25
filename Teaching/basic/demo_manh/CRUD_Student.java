import java.util.ArrayList;
import java.util.Scanner;

public class CRUD_Student {
    // Viết chương trình CRUD quản lý học viên bao gồm tên và lớp
    // có thêm phần tìm kiếm theo lớp và theo tên
    // Sử dụng string để lưu vừa tên và lớp theo dấu phẩy. VD: "Mạnh,SE17D05"
    // để làm được bài này thì em cần lưu ý là làm sao để người dùng
    // khi nhập vào là tên và lớp thì có thể gộp chung vào thành 1 chuỗi
    // Sử dụng cộng chuỗi để biến 2 chuỗi thành 1 chuỗi.
    // Ví dụ a = "abcd" và b = "qwer" ta có c = a + b = "abcdqwer"
    // Nếu muốn thêm dấu cộng thì chỉ cần thêm dấu cộng
    // c = a + "," + b = "abcd,qwer"
    // Và sử phải sử dụng được hàm split trong chuỗi để cắt chuỗi
    // ví dụ: String a = "ab,cd,ef" thì String[] arr = a.split(",");
    // kết qủa của arr sẽ là ["ab", "cd", "ef"]

    // Trước khi thực hiện thì phải khai báo list students với kiểu dữ liệu String
    static ArrayList<String> students = new ArrayList<>();
    // phan dung de nhap vao
    static Scanner sc = new Scanner(System.in);

    // Ham thuc hien viec in ra tat ca thong tin cua students
    public static void displayAll(ArrayList<String> strList) {
        for (String string : strList) {
            System.out.println(string);
        }
    }

    // Ham lay tat ca phan tu trong danh sach
    public static ArrayList<String> getAllStudents() {
        displayAll(students);
        return students;
    }

    // ham them moi hoc sinh
    public static void addStudent() {
        System.out.println("Input name of student:");
        String name = sc.nextLine();
        System.out.println("Input class of student:");
        String className = sc.nextLine();
        String student = name + "," + className;
        students.add(student);
    }

    // ham xoa hoc sinh theo vi tri
    public static void deleteStudent() {
        displayAll(students);
        System.out.println("Input index of student to delete:");
        int index = Integer.parseInt(sc.nextLine());
        students.remove(index);
        displayAll(students);
    }

    // ham chinh sua hoc sinh theo vi tri
    // anh se chi cho em lam la neu de trong enter thi se khong update du lieu do
    public static void updateStudent() {
        displayAll(students);
        System.out.println("Input index of student to delete:");
        int index = Integer.parseInt(sc.nextLine());
        System.out.println(students.get(index));
        System.out.println("Input name of student:");
        String name = sc.nextLine();
        if (name.equals("")) {
            name = students.get(index).split(",")[0];
        }
        System.out.println("Input class of student:");
        String className = sc.nextLine();
        if (className.equals("")) {
            className = students.get(index).split(",")[1];
        }
        String student = name + "," + className;
        students.set(index, student);
    }

    // đối với hàm search thì mình chỉ cần tìm kiếm chia menu chọn loại muốn tìm
    public static void search() {
        while (true) {
            System.out.println("----MENU SEARCH----\n"
                    + "1. search by name\n"
                    + "2. search by class");
            int key = Integer.parseInt(sc.nextLine());
            ArrayList<String> findStudents = new ArrayList<>();
            System.out.println("Input name or class to search: ");
            String search = sc.nextLine();
            switch (key) {
                case 1:
                    for (String string : students) {
                        if (string.split(",")[0].contains(search)) {
                            findStudents.add(string);
                        }
                    }
                    break;
                case 2:
                    for (String string : students) {
                        if (string.split(",")[1].contains(search)) {
                            findStudents.add(string);
                        }
                    }
                    break;
                default:
                    displayAll(findStudents);
                    findStudents.clear();
                    break;
            }
        }
    }

    public static void main(String[] args) {
        while (true) {
            System.out.println("----MENU----\n"
                    + "1. Display all\n"
                    + "2. Add new student\n"
                    + "3. Delete student\n"
                    + "4. update student\n"
                    + "5. exit");
            int key = Integer.parseInt(sc.nextLine());
            switch (key) {
                case 1:
                    getAllStudents();
                    break;
                case 2:
                    addStudent();
                    break;
                case 3:
                    deleteStudent();
                    break;
                case 4:
                    updateStudent();
                    break;
                case 5:
                    System.exit(key);
                case 6:
                    search();
                    break;
                default:
                    break;
            }
        }
    }

}
