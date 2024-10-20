package assignment4;

class KeyedItem<T extends Comparable<T>> {
	T item;

	public KeyedItem(T item) {
		this.item = item;
	}

	public T getKey() {
		return item;
	}
}