public class Hello {
    public static void main(String[] args) {
        Hello hello = new Hello();
        hello.b = 0;
        Hello.a = 0;
    }

    static int a;
    int b;

    public static void display(){
        System.out.println("hello");
    }

    public void displayNon(){
        System.out.println("hello Khanh");
    }
}
