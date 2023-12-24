import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<test1> list = new ArrayList<>();
        test1 n = new test1();
        test1 a = new test2();
        list.add(n);
        list.add(a);
        // System.out.println(list.toString());
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).toString());
        }

        // for (test1 q : list) {
        //     q.chao(0);
        // }
    }
}
