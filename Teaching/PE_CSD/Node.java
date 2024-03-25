public class Node {
    Node right;
    Node left;
    int height;
    Books data;

    Node(Books books) {
        data = books;
        height = 1;
    }

    Node(Node left, Node right, Books books){
        this.right = right;
        this.left = left;
        this.data = books;
    }

    public Node() {
    }

}
