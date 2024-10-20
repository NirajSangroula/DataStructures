/**
 * Assignment 3
 * Name: Niraj Sangroula
 * Course: COSC 2007T
 * Student No: 219886770
 * email: nsangroula@algomau.ca
 */
package Lab3;


public class Main {

	public static void main(String[] args) {
		BinaryTree<Integer> btree = new BinaryTree<Integer>();
		btree.setRootItem(5);
		for(int i = -4; i <= 4 + 20; i+=2) {
			insertItem(btree.root, i);
		}
		
		BinaryTreeIterator<Integer> iterator = new BinaryTreeIterator<Integer>(btree);
		System.out.println("Postorder");
		iterator.setPostorder();
		while(iterator.hasNext()) {
			System.out.print(iterator.next() + " ");
		}
		
		System.out.println();

		System.out.println("Preorder");
		iterator.setPreorder();
		while(iterator.hasNext()) {
			System.out.print(iterator.next() + " ");
		}
		
		System.out.println();

		System.out.println("Inorder");
		iterator.setInorder();
		while(iterator.hasNext()) {
			System.out.print(iterator.next() + " ");
		}
		
		System.out.println();

	}

	public static void insertItem(BinaryTreeNode<Integer> currentNode, Integer item) {	
		if(currentNode == null) {
			System.err.println("Empty node");
		}
		//For item not initialized
		else if(currentNode.isEmpty()) {
			currentNode.item = item;
		}
		else if(item.compareTo(currentNode.item) < 0) {
			//Will immediately set left if it is right position
			if(currentNode.left == null)
				currentNode.left = new BinaryTreeNode<Integer>(item);
			else
				insertItem(currentNode.left, item);
		}
		else if(item.compareTo(currentNode.item) > 0) {
			if(currentNode.right == null)
				currentNode.right = new BinaryTreeNode<Integer>(item);
			else
				insertItem(currentNode.right, item);
		}
		else
			System.out.println("Item already exists");
		
	}

}
