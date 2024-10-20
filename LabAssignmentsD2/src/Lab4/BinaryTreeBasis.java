/**
 * Assignment 4
 * Name: Niraj Sangroula
 * Course: COSC 2007T
 * Student No: 219886770
 * email: nsangroula@algomau.ca
 */
package Lab4;


public abstract class BinaryTreeBasis<T extends Comparable> {
	protected BinaryTreeNode<T> root;

	public BinaryTreeBasis() {
		root = null;
	}

	public BinaryTreeBasis(T rootItem) {
		root = new BinaryTreeNode<T>(null, null, rootItem);
	}

	public boolean isEmpty() {
		return root.isEmpty();
	}

	public void makeEmpty() {
		root = null;
	}

	public T getRootItem() throws TreeException {
		if (root == null) {
			throw new TreeException("TreeException: Empty tree");
		}
		else {
		return root.item;
		}
	}
		public abstract void setRootItem(T newItem);
}
