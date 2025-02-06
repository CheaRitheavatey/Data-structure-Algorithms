// Class representing a node in the binary tree
class Node {
    int value;
    Node left, right;

    public Node(int item) {
        value = item;
        left = right = null;
    }
}

// Class representing the binary tree
public class BinaryTree {
    Node root;

    BinaryTree() {
        root = null;
    }

    // Method to insert a new node
    void insert(int value) {
        root = insertRec(root, value);
    }

    // Recursive function to insert a new node
    Node insertRec(Node root, int value) {
        if (root == null) {
            root = new Node(value);
            return root;
        }

        if (value < root.value) {
            root.left = insertRec(root.left, value);
        } else if (value > root.value) {
            root.right = insertRec(root.right, value);
        }

        return root;
    }

    // Method to perform in-order traversal
    void inOrderTraversal() {
        inOrderRec(root);
    }

    // Recursive function for in-order traversal
    void inOrderRec(Node root) {
        if (root != null) {
            inOrderRec(root.left);
            System.out.print(root.value + " ");
            inOrderRec(root.right);
        }
    }

    // Method to search for a value
    boolean search(int value) {
        return searchRec(root, value);
    }

    // Recursive function to search for a value
    boolean searchRec(Node root, int value) {
        if (root == null) {
            return false;
        }

        if (root.value == value) {
            return true;
        }

        if (value < root.value) {
            return searchRec(root.left, value);
        }

        return searchRec(root.right, value);
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        
        // Inserting values into the binary tree
        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);

        // Performing in-order traversal
        System.out.print("In-order traversal: ");
        tree.inOrderTraversal();

        // Searching for values
        System.out.println("\nSearch for 40: " + tree.search(40));
        System.out.println("Search for 90: " + tree.search(90));
    }
}

// // Main class to test the binary tree implementation
// class BinaryTreeDemo {
    
// }
