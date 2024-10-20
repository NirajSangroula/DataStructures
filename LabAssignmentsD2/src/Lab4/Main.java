/**
 * Assignment 4
 * Name: Niraj Sangroula
 * Course: COSC 2007T
 * Student No: 219886770
 * email: nsangroula@algomau.ca
 */
package Lab4;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		BinarySearchTree<Integer> tree = new BinarySearchTree<>();
		BinaryTreeIterator<Integer> iterator = new BinaryTreeIterator<Integer>(tree);
		
		tree.root = tree.insert(34, tree.root);
		tree.insert(14, tree.root);
		tree.insert(39, tree.root);
		tree.insert(26, tree.root);
		tree.insert(45, tree.root);

		tree.insert(54, tree.root);
		tree.insert(46, tree.root);
		tree.insert(17, tree.root);
		tree.insert(7, tree.root);
		tree.insert(68, tree.root);

		System.out.println("Inorder");
		iterator.setInorder();
		display(iterator);
		System.out.println("Preorder");
		iterator.setPreorder();
		display(iterator);
		System.out.println("Postorder");
		iterator.setPostorder();
		display(iterator);
	}

	private static void display(BinaryTreeIterator<Integer> iterator) {
		while(iterator.hasNext()) {
			System.out.print(iterator.next() + " ");
		}
		System.out.println();
	}

}
