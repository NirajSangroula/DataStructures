package assignment4;

class TreeNode<T extends Comparable<T>> {
	KeyedItem<T> smallItem;
	KeyedItem<T> largeItem;
	TreeNode<T> leftChild;
	TreeNode<T> midChild;
	TreeNode<T> rightChild;

	public TreeNode(KeyedItem<T> smallItem) {
		this.smallItem = smallItem;
		this.largeItem = null;
		this.leftChild = null;
		this.midChild = null;
		this.rightChild = null;
	}

	public boolean isLeaf() {
		return leftChild == null && midChild == null && rightChild == null;
	}

	public boolean isTwoNode() {
		return largeItem == null;
	}

	public boolean isThreeNode() {
		return smallItem != null && largeItem != null;
	}

	public boolean isFull() {
		return largeItem != null && smallItem != null;
	}
}