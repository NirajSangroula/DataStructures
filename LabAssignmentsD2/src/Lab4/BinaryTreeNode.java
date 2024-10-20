/**
 * Assignment 4
 * Name: Niraj Sangroula
 * Course: COSC 2007T
 * Student No: 219886770
 * email: nsangroula@algomau.ca
 */
package Lab4;

public class BinaryTreeNode<T> {
	BinaryTreeNode<T> left, right;
	T item;
	public BinaryTreeNode(T root) {
		this.item = root;
		left = right = null;
	}
	
	public BinaryTreeNode(BinaryTreeNode<T> left, BinaryTreeNode<T> right, T root) {
		this.left = left;
		this.right = right;
		this.item = root;
	}
	
	public void makeEmpty() {
		left = right = null;
		item = null;
	}
	
	public boolean isEmpty() {
		return (item == null && left == null && right == null);
	}
}
