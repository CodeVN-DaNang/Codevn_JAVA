//  Thêm mới một giá trị vào trong mảng, xóa một giá trị khỏi mảng.
public class AddAndRemove {
    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 4, 5, 6, 7 };
        // them
        // tao 1 mang moi nhieu hon mang cu 1 phan tu -> sao chep mang cu xuong mang moi
        int[] newNums = new int[nums.length + 1];
        for (int i = 0; i < newNums.length; i++) {
            if (i < nums.length) {
                newNums[i] = nums[i];
            } else {
                newNums[i] = 10;
            }
        }
        nums = newNums;
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }

        // xoa
        // 1,2,3,4,5,6 -> 1,2,4,5,6
        // tao 1 mang moi it hon 1 -> vi tri < vi tri can xoa thi sao chep y nguyen ||
        // vi tri >= vi tri can xoa sao chep vi tri +1
        // int[] newNums = new int[nums.length - 1];
        int removeIndex = 2;
        for (int i = 0; i < newNums.length; i++) {
            if (i < removeIndex) {
                newNums[i] = nums[i];
            } else {
                newNums[i] = nums[i + 1];
            }
        }
        nums = newNums;
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }
}