package next;

public class Test {
    public static void main(String[] args) {
        TwoThreeTree<Integer> tree = new TwoThreeTree<>();

        // Insert integers from 1 to 10
        for (int i = 1; i <= 10; i++) {
            tree.insert(i);
        }

        // Display values
        System.out.println("In-order Traversal:");
        tree.inOrderTraversal();
        System.out.println();

        // Search for values in the tree
        int[] searchValues = { 1, 12, 3 };
        for (int value : searchValues) {
            System.out.println("Value " + value + " found: " + tree.search(value));
        }
        
        // Attempt to delete values
        int[] deleteValues = { 3, 7, 2 };
        for (int value : deleteValues) {
            boolean deleted = tree.delete(value);
            if (deleted) {
                System.out.println("Deleted value: " + value);
            } else {
                System.out.println("Failed to delete value: " + value);
            }
        }

        // Perform in-order traversal after deletion
        System.out.println("\nIn-order Traversal after deletion:");
        tree.inOrderTraversal();
    }
}

