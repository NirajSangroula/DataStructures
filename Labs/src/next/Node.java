package next;

class Node<T extends Comparable<T>> {
    T[] values;
    Node<T>[] children;
    int numValues;
    boolean leaf;

    @SuppressWarnings("unchecked")
    Node(boolean leaf) {
        this.leaf = leaf;
        values = (T[]) new Comparable[2]; // Maximum 2 values for 2-node or 3 values for 3-node
        children = new Node[4]; // Maximum 3 children for a node
        numValues = 0;
    }

    boolean isFull() {
        return numValues == 2;
    }

    void insertValue(T value) {
        int i = numValues - 1;
        while (i >= 0 && value.compareTo(values[i]) < 0) {
            values[i + 1] = values[i];
            i--;
        }
        values[i + 1] = value;
        numValues++;
    }
}