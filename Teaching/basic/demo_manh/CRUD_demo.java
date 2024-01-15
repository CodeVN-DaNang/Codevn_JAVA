import java.util.Scanner;
public class CRUD_demo {

    static int[] nums = {1,2,3,4,5};
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        getAll();
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