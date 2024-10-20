package assignment4;

public class TwoThreeTree<T extends Comparable<T>> {
	TreeNode<T> root;

	public TwoThreeTree() {
		root = null;
	}

	public void insertItem(KeyedItem<T> newItem) {
		if (root == null) {
			root = new TreeNode<>(newItem);
		} else {
			TreeNode<T> temp = insertItem(root, newItem);
			if (temp != null) {
				TreeNode<T> newRoot = new TreeNode<>(temp.smallItem);
				newRoot.leftChild = temp.leftChild;
				newRoot.midChild = temp.midChild;
				newRoot.rightChild = temp.rightChild;
				newRoot.largeItem = temp.largeItem;
				root = newRoot;
			}
		}
	}

	private TreeNode<T> insertItem(TreeNode<T> node, KeyedItem<T> newItem) {
		if (node.isLeaf()) {
			return insertIntoNode(node, newItem);
		} else {
			if (node.isTwoNode()) {
				if (newItem.getKey().compareTo(node.smallItem.getKey()) < 0) {
					TreeNode<T> temp = insertItem(node.leftChild, newItem);
					if (temp == null)
						return null;
					else
						return insertIntoTwoNode(node, temp);
				} else {
					TreeNode<T> temp = insertItem(node.rightChild, newItem);
					if (temp == null)
						return null;
					else
						return insertIntoTwoNode(node, temp);
				}
			} else {
				if (newItem.getKey().compareTo(node.smallItem.getKey()) < 0) {
					TreeNode<T> temp = insertItem(node.leftChild, newItem);
					if (temp == null)
						return null;
					else
						return insertIntoThreeNode(node, temp);
				} else if (newItem.getKey().compareTo(node.largeItem.getKey()) > 0) {
					TreeNode<T> temp = insertItem(node.rightChild, newItem);
					if (temp == null)
						return null;
					else
						return insertIntoThreeNode(node, temp);
				} else {
					TreeNode<T> temp = insertItem(node.midChild, newItem);
					if (temp == null)
						return null;
					else
						return insertIntoThreeNode(node, temp);
				}
			}
		}
	}
	//Leaf node
	private TreeNode<T> insertIntoNode(TreeNode<T> node, KeyedItem<T> newItem) {
		if (node.isFull()) {
			return splitNode(node, newItem);
		} else {
			if (node.largeItem == null) {
				if (node.smallItem == null) {
					node.smallItem = newItem;
				} else {
					if (newItem.getKey().compareTo(node.smallItem.getKey()) < 0) {
						node.largeItem = node.smallItem;
						node.smallItem = newItem;
					} else {
						node.largeItem = newItem;
					}
				}

			} else {
				if (newItem.getKey().compareTo(node.smallItem.getKey()) > 0
						&& newItem.getKey().compareTo(node.largeItem.getKey()) < 0) {
					node.smallItem = newItem;
				} else if (newItem.getKey().compareTo(node.largeItem.getKey()) > 0) {
					node.smallItem = node.largeItem;
					node.largeItem = newItem;
				}
			}
			return null;
		}
	}

	private TreeNode<T> splitNode(TreeNode<T> node, KeyedItem<T> newItem) {
		TreeNode<T> newNode = new TreeNode<>(null);
		if (node.largeItem == null) {
			if (newItem.getKey().compareTo(node.smallItem.getKey()) < 0) {
				newNode.smallItem = node.smallItem;
				node.smallItem = newItem;
			} else {
				newNode.smallItem = newItem;
			}
		} 
		//Case of splitting (two nodes existent) (Means produces binary tree)
		else {
			if (newItem.getKey().compareTo(node.smallItem.getKey()) > 0
					&& newItem.getKey().compareTo(node.largeItem.getKey()) < 0) {
				newNode.smallItem = newItem;
			} else if (newItem.getKey().compareTo(node.largeItem.getKey()) > 0) {
				newNode.smallItem = node.largeItem;
				node.largeItem = newItem;
			}
		}

		newNode.leftChild = new TreeNode<>(node.smallItem);
		newNode.rightChild = new TreeNode<>(node.largeItem);
		return newNode;
	}

	private TreeNode<T> insertIntoTwoNode(TreeNode<T> node, TreeNode<T> child) {
		if (node.smallItem.getKey().compareTo(child.smallItem.getKey()) < 0) {
			node.rightChild = child.leftChild;
			node.midChild = child.rightChild;
			return splitNode(node, child.smallItem);
		} else {
			node.leftChild = child.rightChild;
			node.midChild = node.rightChild;
			node.rightChild = null;
			return splitNode(node, child.smallItem);
		}
	}

	private TreeNode<T> insertIntoThreeNode(TreeNode<T> node, TreeNode<T> child) {
		if (child.smallItem.getKey().compareTo(node.smallItem.getKey()) < 0) {
			TreeNode<T> newNode = new TreeNode<>(node.smallItem);
			newNode.leftChild = child;
			newNode.midChild = node.leftChild;
			node.smallItem = node.largeItem;
			node.largeItem = null;
			node.leftChild = node.midChild;
			node.midChild = node.rightChild;
			node.rightChild = null;
			return newNode;
		} else if (child.smallItem.getKey().compareTo(node.largeItem.getKey()) > 0) {
			TreeNode<T> newNode = new TreeNode<>(node.largeItem);
			newNode.leftChild = node.rightChild;
			newNode.midChild = child;
			node.largeItem = null;
			node.rightChild = null;
			return newNode;
		} else {
			TreeNode<T> newNode = new TreeNode<>(child.smallItem);
			newNode.leftChild = node.rightChild;
			newNode.midChild = child.leftChild;
			node.rightChild = child.rightChild;
			child.leftChild = node.midChild;
			child.rightChild = null;
			node.midChild = null;
			return newNode;
		}
	}

	public KeyedItem<T> retrieveItem(T searchKey) {
		return retrieveItem(root, searchKey);
	}

	private KeyedItem<T> retrieveItem(TreeNode<T> node, T searchKey) {
		if (node == null) {
			return null;
		} else if (node.isTwoNode()) {
			if (searchKey.compareTo(node.smallItem.getKey()) == 0) {
				return node.smallItem;
			} else if (searchKey.compareTo(node.smallItem.getKey()) < 0) {
				return retrieveItem(node.leftChild, searchKey);
			} else {
				return retrieveItem(node.rightChild, searchKey);
			}
		} else {
			if (searchKey.compareTo(node.smallItem.getKey()) == 0) {
				return node.smallItem;
			} else if (searchKey.compareTo(node.smallItem.getKey()) < 0) {
				return retrieveItem(node.leftChild, searchKey);
			} else if (searchKey.compareTo(node.smallItem.getKey()) > 0
					&& searchKey.compareTo(node.largeItem.getKey()) == 0) {
				return node.largeItem;
			} else if (searchKey.compareTo(node.largeItem.getKey()) < 0) {
				return retrieveItem(node.midChild, searchKey);
			} else {
				return retrieveItem(node.rightChild, searchKey);
			}
		}
	}

	public boolean deleteItem(T searchKey) {
		if (root == null) {
			return false;
		} else {
			TreeNode<T> dummy = new TreeNode<>(null);
			dummy.leftChild = root;
			boolean result = deleteItem(dummy, root, searchKey);
			root = dummy.leftChild;
			return result;
		}
	}

	private boolean deleteItem(TreeNode<T> parent, TreeNode<T> node, T searchKey) {
		if (node.isLeaf() && node.isTwoNode() && node.smallItem.getKey().equals(searchKey)) {
			deleteFromNode(node, null);
			return true;
		} else {
			System.out.println("Not implemented");
			return false;
		}
	}

	private void deleteFromNode(TreeNode<T> node, KeyedItem<T> itemToDelete) {
		if (node.isTwoNode()) {
			if (node.smallItem == itemToDelete) {
				node.smallItem = null;
			} else {
				node.smallItem = node.largeItem;
				node.largeItem = null;
			}
		} else if (node.isThreeNode()) {
			if (node.smallItem == itemToDelete) {
				node.smallItem = node.largeItem;
				node.largeItem = null;
			} else {
				node.largeItem = null;
			}
		}
	}

	public void displayInOrder() {
		if (root == null) {
			System.out.println("Tree is empty.");
		} else {
			System.out.print("Inorder traversal: ");
			inOrderTraversal(root);
			System.out.println();
		}
	}

	private void inOrderTraversal(TreeNode<T> node) {
		if (node != null) {
			if (node.isTwoNode()) {
				inOrderTraversal(node.leftChild);
				System.out.print(node.smallItem.getKey() + " ");
				inOrderTraversal(node.rightChild);
			} else {
				inOrderTraversal(node.leftChild);
				System.out.print(node.smallItem.getKey() + " ");
				inOrderTraversal(node.midChild);
				System.out.print(node.largeItem.getKey() + " ");
				inOrderTraversal(node.rightChild);
			}
		}
	}
}
