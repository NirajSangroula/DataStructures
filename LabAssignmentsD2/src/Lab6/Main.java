	/**
	 * Assignment 6
	 * Name: Niraj Sangroula
	 * Course: COSC 2007T
	 * Student No: 219886770
	 * email: nsangroula@algomau.ca
	 */
package Lab6;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {		
		ArrayList<Integer> items = new ArrayList<>();
		items.add(4);
		items.add(5);
		items.add(12);
		items.add(3);
		items.add(13);
		items.add(40);
		items.add(44);
		
		heapSort(items);
		
		displayArraylist(items);
	}

	public static void heapSort(ArrayList<Integer> items) {
		//Rebuild heap for the first time
		for(int i = items.size() - 1; i >= 0; i--) {
			heapRebuild(items, i, items.size());
		}
		
		int lastHeapIndex = items.size() - 1;
		for(int i = 0; i < items.size(); i++) {
			int temp = items.get(lastHeapIndex);
			items.set(lastHeapIndex, items.get(0));
			items.set(0, temp);
			lastHeapIndex--;
			heapRebuild(items, 0, lastHeapIndex);
			//Now the largest value is again at 0, and we repeat steps
		}
	}

	private static void displayArraylist(ArrayList<Integer> items) {
		for(int i = 0; i < items.size(); i++) {
			System.out.println(items.get(i) + "\t");
		}
		System.out.println();
	}

	protected static void heapRebuild(ArrayList<Integer> items, int root, int last) {
		//Find 2 childs, rebuild itself. (Then rebuild which child you replaced)
		int leftChild = 2 * root + 1;
		if(leftChild < last) {
			int rightChild = leftChild + 1;
			
			if(rightChild <= last && (items.get(rightChild).compareTo(items.get(leftChild)) > 0)) {
				leftChild = rightChild;
			}
			
			//To this point, we have setup such that, we are going to change the greatest child index... It could be actual right child
			
			if(items.get(root).compareTo(items.get(leftChild)) < 0) {
				Integer temp = items.get(root);
				items.set(root, items.get(leftChild));
				items.set(leftChild, temp);
				heapRebuild(items, leftChild, last);
			}
		}
	}

}
