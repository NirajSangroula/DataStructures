package assignment4;

public class Main {

	public static void main(String[] args) {
		TwoThreeTree<Integer> tree = new TwoThreeTree<>();

		// Insert 10 values
		for (int i = 1; i <= 10; i++) {
			tree.insertItem(new KeyedItem<Integer>(i));
		}

		tree.displayInOrder();
		// Retrieve a specific value
		KeyedItem<Integer> retrievedItem = tree.retrieveItem(5);
		System.out.println("Retrieved value: " + retrievedItem.getKey());

		// Delete a single leaf node
		boolean deleted = tree.deleteItem(10); // Assuming 10 is a leaf node
		System.out.println("Deleted node: " + deleted);
	}
}
