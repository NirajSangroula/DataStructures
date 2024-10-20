/**
 * Assignment 3
 * Name: Niraj Sangroula
 * Course: COSC 2007T
 * Student No: 219886770
 * email: nsangroula@algomau.ca
 */
package Lab3;

import Lab3.TreeException;

public class BinaryTree<T> extends BinaryTreeBasis<T> {
	public BinaryTree() {
		super();
	}
	public BinaryTree(BinaryTreeNode<T> rootNode) {
		root = rootNode;
	} // end protected constructor

	@Override
	public void setRootItem(T newItem) {
		if (root != null)
			root.item = newItem;
		else
			root = new BinaryTreeNode<T>(null, null, newItem);
	}

	// Assume there is no child
	public void attachLeft(T newItem) {
		if (!isEmpty() && root.left == null) {
			root.left = new BinaryTreeNode<T>(null, null, newItem);
		}
	}

	// Assume there is no child
	public void attachRight(T newItem) {
		if (!isEmpty() && root.right == null) {
			root.right = new BinaryTreeNode<T>(null, null, newItem);
		}
	}

	public void attachLeftSubtree(BinaryTree<T> leftTree) throws TreeException {
		if (isEmpty()) {
			throw new TreeException("TreeException: Empty tree");
		} else if (root.left != null) {
			// a left subtree already exists; it should have been
			// deleted first
			throw new TreeException("TreeException: " + "Cannot overwrite left subtree");
		} else {
			// assertion: nonempty tree; no left child
			root.left = leftTree.root;
			// clear old references of Basis Tree
			leftTree.makeEmpty();
		} // end if
	} // end

	public void attachRightSubtree(BinaryTree<T> rightTree) throws TreeException {
		if (isEmpty()) {
			throw new TreeException("TreeException: Empty tree");
		} else if (root.right != null) {
			// a right subtree already exists; it should have been
			// deleted first
			throw new TreeException("TreeException: " + "Cannot overwrite right subtree");
		} else {
			// assertion: nonempty tree; no right child
			root.right = rightTree.root;
			// don't want to leave multiple entry points into
			// our tree
			rightTree.makeEmpty();
		} // end if
	} // end attachRightSubtree

//Will return the detached subtree
	public BinaryTree<T> detachLeftSubtree() throws TreeException {
		if (isEmpty()) {
			throw new TreeException("TreeException: Empty tree");
		} else {
			// create a new binary tree that has root's left
			// node as its root
			BinaryTree<T> leftTree;
			leftTree = new BinaryTree<T>(root.left);
			root.left = null;
			return leftTree;
		}

	}

	public BinaryTree<T> detachRightSubtree() throws TreeException {
		if (isEmpty()) {
			throw new TreeException("TreeException: Empty tree");
		} else {
			BinaryTree<T> rightTree;
			rightTree = new BinaryTree<T>(root.right);
			root.right = null;
			return rightTree;
		}
	}
	
}
