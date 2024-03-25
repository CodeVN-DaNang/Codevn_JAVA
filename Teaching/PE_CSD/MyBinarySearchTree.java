import java.util.LinkedList;
import java.util.Queue;

public class MyBinarySearchTree {
    Node root;

    MyBinarySearchTree() {
        root = null;
    }

    // de goi cho ham main
    public void insert(Books books) {
        root = insert(books, root);
    }

    // de thuc thi insert o tren
    public Node insert(Books books, Node node) {
        if (node == null) {
            node = new Node(null, null, books);
            return node;
        }
        if (node.data.getIsbn().compareTo(books.getIsbn()) >= 0) {
            node.left = insert(books, node.left);
        } else {
            node.right = insert(books, node.right);
        }
        return node;
    }

    // preorder || ascending traversal
    public void traverse(Node node) {
        if (node == null) {
            return;
        }
        System.out.println(node.data.toString());
        traverse(node.left);
        traverse(node.right);
    }

    // post order || descending traversal
    void postOrder(Node node) {
        if (node != null) {
            postOrder(node.left);
            postOrder(node.right);
            System.out.println(node.data.toString() + " ");
        }
    }

    // inorder
    void inOrderTraversal(Node root) {
        if (root != null) {
            inOrderTraversal(root.left);
            System.out.print(root.data.toString() + " ");
            inOrderTraversal(root.right);
        }
    }

    // lever order || breath-traversal
    void levelOrderTraversal() {
        if (root == null)
            return;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node tempNode = queue.poll();
            System.out.print(tempNode.data.toString() + " ");

            if (tempNode.left != null)
                queue.add(tempNode.left);

            if (tempNode.right != null)
                queue.add(tempNode.right);
        }
    }

    // ham theo yeu cau de
    public void search(String year, Node node){
        if (node == null) {
            return;
        }
        if (node.data.getYearOfPublication().equals("\"" + year + "\"")) {
            System.out.println(node.data.toString());
        }
        
        search(year,node.left);
        search(year,node.right);
    }

    // public int countWorkerLess25(int count, Node node){
    //     if (node == null) {
    //         return count;
    //     }
    //     if (node.data.getAge() <  25 ) {
    //         count++;
    //     }
        
    //     countWorkerLess25(count,node.left);
    //     countWorkerLess25(count,node.right);
    // }

    // delete node
    void deleteNode(Books books) {
        root = deleteRec(root, books);
    }

    Node deleteRec(Node node, Books books) {
        if (node == null) return root;

        if (books.getIsbn().compareTo(root.data.getIsbn()) > 0)
            root.left = deleteRec(root.left, books);
        else if (books.getIsbn().compareTo(root.data.getIsbn()) < 0)
            root.right = deleteRec(root.right, books);
        else {
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;

            root.data = minValue(root.right);

            root.right = deleteRec(root.right, root.data);
        }

        return root;
    }

    Books minValue(Node node) {
        Books minValue = node.data;
        while (root.left != null) {
            minValue = root.left.data;
            root = root.left;
        }
        return minValue;
    }



}
