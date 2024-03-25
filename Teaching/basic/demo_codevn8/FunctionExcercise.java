public class FunctionExcercise {

    static int[] arr = {4,5,2,48,5,87,17};

    public static void main(String[] args) {
        displayPrimeNum();
        System.out.println(findMax());
        selectionSort();
    }

    public static boolean isPrime(int num){
        if (num < 2) {
            return false;
        }
        for (int i = 2; i < num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void displayPrimeNum(){
        String result = "";
        for (int i = 0; i < arr.length; i++) {
            if (isPrime(arr[i])) {
                result += arr[i] + ", ";
            }
        }
        System.out.println("Cac so nguyen to la: " + result);
    }

    public static int findMax(){
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (max < arr[i]) {
                max = arr[i];
            }
        }
        return max;
    }

    // selection sort
    public static void selectionSort(){
        int[] arr2 = new int[arr.length];
        for (int i = 0; i < arr2.length; i++) {
            arr2[i] = arr[i];
        }
        for (int i = 0; i < arr2.length; i++) {
            boolean flag = true;
            for (int j = 0; j < arr2.length; j++) {
                if (arr2[i] < arr2[j]) {
                    int temp = arr2[i];
                    arr2[i] = arr2[j];
                    arr2[j] = temp;
                    flag = false;
                }
            }
            if (flag) {
                break;
            }
        }
        for (int i = 0; i < arr2.length; i++) {
            System.out.print(arr2[i] + ", ");
        }
        System.out.println();
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ", ");
        }
    }

}
