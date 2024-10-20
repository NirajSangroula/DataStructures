package next;

public class TwoThreeTree<T extends Comparable<T>> {
    private Node<T> root;
    public TwoThreeTree() {
        root = new Node(true); // Initially, the root is a leaf node
    }

    public void insert(T value) {
        if (root.isFull()) {
            Node newRoot = new Node(false);
            newRoot.children[0] = root;
            splitChild(newRoot, 0);
            root = newRoot;
        }
        insertNonFull(root, value);
    }

    private void splitChild(Node parentNode, int childIndex) {
        Node childNode = parentNode.children[childIndex];
        Node newChildNode = new Node(childNode.leaf);
        parentNode.insertValue(childNode.values[1]);

        // Adjust children if the node being split is not a leaf
        if (!childNode.leaf) {
            newChildNode.children[0] = childNode.children[2];
            newChildNode.children[1] = childNode.children[3];
            childNode.children[2] = null; 
            childNode.children[3] = null;
        }

        childNode.numValues = 1;
        parentNode.children[childIndex + 1] = newChildNode;

        int parentNumValues = parentNode.numValues;
        for (int i = parentNumValues - 1; i > childIndex; i--) {
            parentNode.children[i + 1] = parentNode.children[i];
        }

        parentNode.children[childIndex] = childNode;
    }


    private void insertNonFull(Node node, T value) {
        int i = node.numValues - 1;

        if (node.leaf) {
            node.insertValue(value);
        } else {
            while (i >= 0 && value.compareTo((T) node.values[i]) < 0) {
                i--;
            }
            i++;

            if (node.children[i].isFull()) {
                splitChild(node, i);
                if (value.compareTo((T) node.values[i]) > 0) {
                    i++;
                }
            }
            insertNonFull(node.children[i], value);
        }
    }
    


    public void inOrderTraversal() {
        inOrderTraversal(root);
    }

    private void inOrderTraversal(Node node) {
        if (node != null) {
            if (!node.leaf) {
                inOrderTraversal(node.children[0]);
                for (int i = 0; i < node.numValues; i++) {
                    System.out.print(node.values[i] + " ");
                    inOrderTraversal(node.children[i + 1]);
                }
            } else {
                for (int i = 0; i < node.numValues; i++) {
                    System.out.print(node.values[i] + " ");
                }
            }
        }
    }

    public boolean search(T value) {
        return search(root, value);
    }

    private boolean search(Node node, T value) {
        if (node == null) {
            return false;
        }

        int i = 0;
        while (i < node.numValues && value.compareTo((T) node.values[i]) > 0) {
            i++;
        }

        if (i < node.numValues && value.compareTo((T) node.values[i]) == 0) {
            return true;
        }

        if (node.leaf) {
            return false;
        } else {
            return search(node.children[i], value);
        }
    }
    
    public boolean delete(T value) {
        return delete(root, value);
    }

    private boolean delete(Node node, T value) {
        if (node == null) {
            return false;
        }

        int i = 0;
        while (i < node.numValues && value.compareTo((T) node.values[i]) > 0) {
            i++;
        }

        if (i < node.numValues && value.compareTo((T) node.values[i]) == 0) {
            // Value when found in a leaf node, delete it
            if (node.leaf) {
                // Shift the values to fill gap due to deletion
                for (int j = i + 1; j < node.numValues; j++) {
                    node.values[j - 1] = node.values[j];
                }
                node.numValues--;
                return true;
            } else {
                // Display message
                System.out.println("Cannot delete. Node is not a leaf.");
                return false;
            }
        }

        // Recursively search in the appropriate child node
        if (node.leaf) {
            // Value not found in a leaf node
            return false;
        } else {
            boolean deleted = delete(node.children[i], value);
            if (deleted) {
                // Balance the tree if necessary - Unimplemented
            }
            return deleted;
        }
    }

}
