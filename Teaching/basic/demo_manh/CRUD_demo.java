import java.util.Scanner;
public class CRUD_demo {

    static int[] nums = {1,2,3,4,5};
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int a = Integer.parseInt(sc.nextLine());
        String b = sc.nextLine();
        System.out.println(a + " and " + b);
    }
    
    // delete many elements
    public static void deleteMany(){
        int amount = 0;
        while (amount <= 0 || amount > nums.length) {
            System.out.println("Input how many to delete: ");
            amount = sc.nextInt();
        }
        for (int i = 0; i < amount; i++) {
            deleteById();
        }
    }

    // add at index
    public static void addAtIndex(){
        System.out.println("Input index to add:");
        int index = sc.nextInt();
        int[] b = new int[nums.length + 1];
        for (int i = 0; i < b.length; i++) {
            if (i < index) {
                b[i] = nums[i];
            } else if (i == index) {
                System.out.println("Input num to add: ");
                b[i] = sc.nextInt();
            } else {
                b[i] = nums[i-1];
            }
        }
        nums = b;
    }

    // add many elements
    public static void addMany(){
        System.out.println("Input how many to add: ");
        int amount = sc.nextInt();
        int[] b = new int[nums.length + amount];
        for (int i = 0; i < b.length; i++) {
            if (i < nums.length) {
                b[i] = nums[i];
            } else {
                System.out.println("Input num to add at " + i);
                b[i] = sc.nextInt();
            }
        }
        nums = b;
    }

    public static void getAll(){
        System.out.print("array a: [");
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]+ ", ");
        }
        System.out.print("]");
    }

    public static void addLast(){
        System.out.println("input the new num:");
        int numAdd = sc.nextInt();
        int[] b = new int[nums.length + 1];
        for (int i = 0; i < b.length; i++) {
            if (i == b.length - 1) {
                b[i] = numAdd;
            } else {
                b[i] = nums[i];
            }
        }
        nums = b;
    }

    public static void update(){
        System.out.println("input index num to update:");
        int index = sc.nextInt();
        System.out.println("input the new num:");
        int numAdd = sc.nextInt();
        nums[index] = numAdd;
    }

    public static void deleteById(){
        System.out.println("input index num to delete:");
        int index = sc.nextInt();
        int[] b = new int[nums.length - 1];
        for (int i = 0; i < b.length; i++) {
            if (i < index) {
                b[i] = nums[i];
            }
            if (i >= index) {
                b[i] = nums[i+1];
            }
        }
        nums = b;
    }
    
}