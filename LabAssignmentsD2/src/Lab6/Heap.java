package Lab6;

import java.util.ArrayList;

public class Heap<T extends Comparable> {
	ArrayList<T> items;
	public Heap() {
		items = new ArrayList<T>();
	}
	
	public boolean isHeapEmpty() {
		return items.size() == 0;
	}
	public void insert(T item) {
		items.add(item);
		int place = items.size() - 1;
		int parent = (place - 1) / 2;
		while((parent >= 0 && (items.get(place).compareTo(items.get(parent)) > 0))) {
			T temp = items.get(place);
			items.set(place, items.get(parent));
			items.set(parent, temp);
			
			place = parent;
			parent = (place - 1) / 2;
		}
	}
	
	public T delete() {
		T rootItem = null;
		int last;
		if(!isHeapEmpty()) {
			//Note: It is also valid for single item... 
			last = items.size() - 1;
			rootItem = items.get(0);
			
			items.set(0, items.get(last));
			items.remove(last);
			heapRebuild(0);
		}
		return rootItem;
	}
	
	protected void heapRebuild(int root) {
		//Find 2 childs, rebuild itself. (Then rebuild which child you replaced)
		int leftChild = 2 * root + 1;
		if(leftChild < items.size()) {
			int rightChild = leftChild + 1;
			
			if(rightChild < items.size() && (items.get(rightChild).compareTo(items.get(leftChild)) > 0)) {
				leftChild = rightChild;
			}
			
			//To this point, we have setup such that, we are going to change the greatest child index... It could be actual right child
			
			if(items.get(root).compareTo(items.get(leftChild)) < 0) {
				T temp = items.get(root);
				items.set(root, items.get(leftChild));
				items.set(leftChild, temp);
				heapRebuild(leftChild);
			}
		}
	}

	public void display() {
		for(T t : items) {
			System.out.print(t + "\t");
		}
		System.out.println();
	}
	
}
