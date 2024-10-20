/**
 * Assignment 3
 * Name: Niraj Sangroula
 * Course: COSC 2007T
 * Student No: 219886770
 * email: nsangroula@algomau.ca
 */
package Lab3;

import java.util.Iterator;
import java.util.LinkedList;

import Lab4.BinarySearchTree;
import Lab4.BinaryTreeBasis;


public class BinaryTreeIterator<T> implements Iterator {
	private BinarySearchTree<Integer> binTree;
	private BinaryTreeNode currentNode;
	private LinkedList<BinaryTreeNode<T>> queue;

	public BinaryTreeIterator(BinaryTree<Integer> btree) {
		binTree = btree;
		currentNode = null;
		// empty queue indicates no traversal type currently
		// selected or end of current traversal has been reached
		queue = new LinkedList<BinaryTreeNode<T>>();
	} // end constructor

	public boolean hasNext() {
		return !queue.isEmpty();
	} // end hasNext

	public T next() throws java.util.NoSuchElementException {
		currentNode = queue.remove();
		return (T) currentNode.item;
	} // end next

	public void remove() throws UnsupportedOperationException {
		throw new UnsupportedOperationException();
	} // end remove

	public void setPreorder() {
		queue.clear();
		preorder(binTree.root);
	} // setPreOrder

	public void setInorder() {
		queue.clear();
		inorder(binTree.root);
	} // end setInorder

	public void setPostorder() {
		queue.clear();
		postorder(binTree.root);
	} // end setPostorder

	private void preorder(BinaryTreeNode<T> treeNode) {
		if (treeNode != null) {
			queue.add(treeNode);
			preorder(treeNode.left);
			preorder(treeNode.right);
		} // end if
	} // end preorder

	private void inorder(BinaryTreeNode<T> treeNode) {
		if (treeNode != null) {
			inorder(treeNode.left);
			queue.add(treeNode);
			inorder(treeNode.right);
		} // end if
	} // end inorder

	private void postorder(BinaryTreeNode<T> treeNode) {
		if (treeNode != null) {
			postorder(treeNode.left);
			postorder(treeNode.right);
			queue.add(treeNode);
		} // end if
	} // end postorder
} // end TreeIterator
