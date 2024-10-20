/**
 * Assignment 4
 * Name: Niraj Sangroula
 * Course: COSC 2007T
 * Student No: 219886770
 * email: nsangroula@algomau.ca
 */
package Lab4;


public class BinarySearchTree<T extends Comparable> extends BinaryTreeBasis<T> {
	public BinarySearchTree() {
		super();
	}
	public BinarySearchTree(BinaryTreeNode<T> rootNode) {
		root = rootNode;
	}

	@Override
	public void setRootItem(T newItem) {
		if (root != null)
			root.item = newItem;
		else
			root = new BinaryTreeNode<T>(null, null, newItem);
	}

	public BinaryTreeNode insert(T newItem, BinaryTreeNode tree) {
		if(tree == null) {
			return new BinaryTreeNode(newItem);
		}
		else if(newItem.compareTo(tree.item) > 0) {
				tree.right = insert(newItem, tree.right);
			}
		else if(newItem.compareTo(tree.item) < 0) {
			tree.left = insert(newItem, tree.left);
		}
		else {
			System.out.println("Item already exists");
		}
		return tree;
	}
	
	public boolean search(T item, BinaryTreeNode tree) {
		if(tree == null)
			return false;
		else if(item.compareTo(tree.item) == 0) {
			return true;
		}
		else if(item.compareTo(tree.item) > 0) {
			return search(item, tree.right);
		}
		else{
			return search(item, tree.left);
		}
	}
	
	public BinaryTreeNode delete(T item, BinaryTreeNode tree) {
		BinaryTreeNode newRoot;
		if(tree == null) {
			throw new TreeException("Item not found");
		}
		else if(item.compareTo(tree.item) == 0) {
			newRoot = deleteNode(tree);
			//Set each references
			if(newRoot != null) {
				tree.item = newRoot.item;
				tree.left = newRoot.left;
				tree.right = newRoot.right;
			}
			else {
				tree.item = null;
			}
		}
		else if(item.compareTo(tree.item) > 0) {
			newRoot =  delete(item, tree.right);
		}
		else {
			newRoot = delete(item, tree.left);
		}
		return newRoot;
	}
	//Its basic work is to remove node, and return what remains
	public BinaryTreeNode deleteNode(BinaryTreeNode tree) {
		//If it is leaf node
		if(tree.right == null && tree.left == null) {
			return null;
		}
		else if(tree.left == null ^ tree.right == null) {
			return (tree.left == null)?tree.right:tree.left;
		}
		else {
			throw new RuntimeException("Not Implemented for node with 2 child");
		}
	}

}
