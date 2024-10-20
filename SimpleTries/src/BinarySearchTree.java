import java.util.Scanner;

class Node {
    int data;
    Node left, right;

    public Node(int data) {
        this.data = data;
        left = right = null;
    }
}

class BinarySearchTree {
    Node root;

    BinarySearchTree() {
        root = null;
    }

    void insert(int data) {
        root = insertRec(root, data);
    }

    Node insertRec(Node root, int data) {
        if (root == null) {
            root = new Node(data);
            return root;
        }

        if (data < root.data)
            root.left = insertRec(root.left, data);
        else if (data > root.data)
            root.right = insertRec(root.right, data);

        return root;
    }

    Node findNode(Node root, int data) {
        if (root == null || root.data == data)
            return root;

        if (data < root.data)
            return findNode(root.left, data);

        return findNode(root.right, data);
    }

    Node deleteNode(Node root, int data) {
        if (root == null)
            return root;

        if (data < root.data)
            root.left = deleteNode(root.left, data);
        else if (data > root.data)
            root.right = deleteNode(root.right, data);
        else {
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;

            root.data = minValue(root.right);
            root.right = deleteNode(root.right, root.data);
        }

        return root;
    }

    int minValue(Node root) {
        int minValue = root.data;
        while (root.left != null) {
            minValue = root.left.data;
            root = root.left;
        }
        return minValue;
    }

    void inorderTraversal(Node root) {
        if (root != null) {
            inorderTraversal(root.left);
            System.out.print(root.data + " ");
            inorderTraversal(root.right);
        }
    }

    void preorderTraversal(Node root) {
        if (root != null) {
            System.out.print(root.data + " ");
            preorderTraversal(root.left);
            preorderTraversal(root.right);
        }
    }

    void postorderTraversal(Node root) {
        if (root != null) {
            postorderTraversal(root.left);
            postorderTraversal(root.right);
            System.out.print(root.data + " ");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BinarySearchTree bst = new BinarySearchTree();

        bst.insert(15);
        bst.insert(5);
        // Insert other values here...

        int choice;
        do {
            System.out.println("=====================");
            System.out.println("1. Insert a node");
            System.out.println("2. Find a node");
            System.out.println("3. Delete a node");
            System.out.println("4. Print preorder traversal");
            System.out.println("5. Print inorder traversal");
            System.out.println("6. Print postorder traversal");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 0:
                    System.out.println("Exiting...");
                    break;
                case 1:
                    System.out.print("Enter value to insert: ");
                    int value = scanner.nextInt();
                    bst.insert(value);
                    break;
                case 2:
                    System.out.print("Enter value to find: ");
                    int findValue = scanner.nextInt();
                    Node foundNode = bst.findNode(bst.root, findValue);
                    if (foundNode != null)
                        System.out.println("Node found!");
                    else
                        System.out.println("Node not found!");
                    break;
                case 3:
                    System.out.print("Enter value to delete: ");
                    int deleteValue = scanner.nextInt();
                    bst.root = bst.deleteNode(bst.root, deleteValue);
                    break;
                case 4:
                    System.out.println("Preorder traversal:");
                    bst.preorderTraversal(bst.root);
                    System.out.println();
                    break;
                case 5:
                    System.out.println("Inorder traversal:");
                    bst.inorderTraversal(bst.root);
                    System.out.println();
                    break;
                case 6:
                    System.out.println("Postorder traversal:");
                    bst.postorderTraversal(bst.root);
                    System.out.println();
                    break;
                default:
                    System.out.println("Invalid choice!");
                    break;
            }
        } while (choice != 0);

        scanner.close();
    }
}
