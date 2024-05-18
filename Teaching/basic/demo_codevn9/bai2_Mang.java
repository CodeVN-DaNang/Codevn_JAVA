// 2. cho một mảng bất kì
// 	a. kiểm tra mảng đó có ít nhất là một số nguyên tố không
// 	b. kiểm tra mảng đó có phải mảng đối xứng không
// 	c. tìm số lượng phần tử khác nhau trong mảng
// d.tìm số lần xuất hiện của mỗi phần tử khác nhau trong mảng
public class bai2_Mang {
    public static void main(String[] args) {
        // int[] nums = { 1, 2, 34, 5, 6, 7, 12, 456, 23, 78 };
        // bai1
        // for (int j = 0; j < nums.length; j++) {
        //     boolean flag = true;
        //     if (nums[j] < 2) {
        //         flag = false;
        //     }
        //     for (int i = 2; i < nums[j]; i++) {
        //         if (nums[j] % i == 0) {
        //             flag = false;
        //             break;
        //         }
        //     }
        //     if (flag) {
        //         System.out.println(nums[j]);
        //     }
        // }

        // bai2
        // int[] nums = { 1,2,3,3,2,1 };
        // boolean flag = false;
        // for (int i = 0; i < nums.length/2; i++) {
        //     if (nums[i] == nums[nums.length -1 - i]) {
        //         flag = true;
        //     } else {
        //         flag = false;
        //         break;
        //     }
        // }
        // if (flag) {
        //     System.out.println("Mang doi xung");
        // } else {
        //     System.out.println("Mang khong doi xung");
        // }

        // bai3
        // int[] nums = { 1,2,3,3,2,1,4 };
        // int[] findNum = {-1,-1,-1,-1,-1,-1};
        // int count = 0;
        // for (int i = 0; i < nums.length; i++) {
        //     boolean flag = true;
        //     for (int j = 0; j < findNum.length; j++) {
        //         if (nums[i] == findNum[j]) {
        //             flag = false;
        //             break;
        //         }
        //     }
        //     if (flag) {
        //         findNum[count] = nums[i];
        //         count++;
        //     }
        // }
        // System.out.println(count);

        // bai4
        int[] nums = { 1,2,3,3,2,1,4 };
        int[] findNum = {-1,-1,-1,-1,-1,-1};
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            
            boolean flag = true;
            for (int j = 0; j < findNum.length; j++) {
                if (nums[i] == findNum[j]) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                findNum[count] = nums[i];
                count++;
            }
            
        }
        
        for (int j = 0; j < count; j++) {
            int countEachNum = 0;
            for (int i = 0; i < nums.length; i++) {
                if (findNum[j] == nums[i]) {
                    countEachNum++;
                }
            }
            System.out.println("so " + findNum[j] + " xuat hien " + countEachNum + " lan");
        }
        
    }
}
