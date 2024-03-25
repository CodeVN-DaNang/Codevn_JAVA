import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        MyBinarySearchTree myBinarySearchTree = new MyBinarySearchTree();
        ArrayList<Books> bookList = new LoadFile().getAllBooks();
        for (Books books : bookList) {
            myBinarySearchTree.insert(books);
        }
        String year = "1991";
        myBinarySearchTree.search(year, myBinarySearchTree.root);
    }
}
