package assignment5.e2;

import java.util.Scanner;

public class UserChoiceSorter {

	public static void main(String[] args) {
		System.out.println("Enter number of elements you wish to enter: ");
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int[] array = new int[n];
		System.out.println("Enter " + n + " elements");
		for(int i = 0; i < n; i++) {
			array[i] = s.nextInt();
		}
		System.out.println("Enter which sort method you want to use:[1,2,3,4]");
		System.out.println("1. Selection Sort");
		System.out.println("2. Bubble Sort");
		System.out.println("3. Insertion Sort");
		System.out.println("4. Merge Sort");
		int option = s.nextInt();
		switch(option) {
			case 1: 
				System.out.println("Using selection sort");
				selectionSort(array); break;
			case 2: 
				System.out.println("Using bubble sort");
				bubbleSort(array); break;
			case 3: 
				System.out.println("Using insertion sort");
				insertionSort(array); break;
			default: 
				System.out.println("Using merge sort");
				mergeSort(array, new int[array.length], 0, array.length - 1);
		}
		
		for(int value: array) {
			System.out.print(value + " ");
		}
		System.out.println();
	}

	public static void insertionSort(int[] array) {
		for(int unsorted = 1; unsorted < array.length; unsorted++) {
			int thisItem = array[unsorted];
			int i = unsorted;
			/**
			 * For each unsorted place,
			 * We start with i which is current vacant place to insert the element- that starts with
			 * unsorted,
			 * checking i-1 whether to change i or not
			 * If not, then i is the current place to insert things... Ok
			 */
			while((i > 0) && array[i - 1] > thisItem) {
				array[i] = array[i - 1];
				i--;
			}
			array[i] = thisItem; //Here it is, we place the freaking item in current place
		}
	}

	public static void selectionSort(int[] array) {
		for(int i = array.length - 1; i >= 0; i--) {
			int indexOfLargest = indexOfLargest(array, i + 1);
			int temp = array[i];
			array[i] = array[indexOfLargest];
			array[indexOfLargest] = temp;
		}
	}
	
	public static int indexOfLargest(int[] array, int n) {
		int indexOfLargest = 0;
		for(int i = 0; i < n; i++) {
			if(array[i] > array[indexOfLargest])
				indexOfLargest = i;				
		}
		return indexOfLargest;
	}
	
	public static void bubbleSort(int[] array) {
		for(int i = 0; i < array.length - 1; i++) {
			for(int j = i + 1; j < array.length; j++) {
				if(array[i] > array[j]) {
					int temp = array[i];
					array[i] = array[j];
					array[j] = temp;
				}
			}
		}
	}
	public static void mergeSort(int[] array, int[] result, int first, int last) {
		if(first < last) {
			int mid = (first + last) / 2;
			mergeSort(array, result, first, mid);
			mergeSort(array, result, mid + 1, last);
			merge(array, result, first, mid, last);
		}
	}
	
	public static void merge(int[] array, int[] result, int first, int mid, int last) {
		/**
		 * 
		 * first1 and first2 are iterator points while
		 * last1 and last2 are just ending points like n
		 * 
		 * We keep running while loop until each exceed ending points, (So it is kind of nested loop)
		 * ((While loop used with 2 variables is indeed like a nested loop))
		 */
		int first1 = first;
		int first2 = mid + 1;
		int last1 = mid;
		int last2 = last;
		int i = first1;
		/**
		 * The index, where we will actually be inserting the data is accounted in i
		 * Because, nested loop it may be, but they all will be fighting for just n positions
		 * So we track position using i, starting with first1
		 */
		while((first1 <= last1) && (first2 <= last2)) {
			if(array[first1] > array[first2]) {
				result[i] = array[first2++];
			}
			else {
				result[i] = array[first1++];
			}
			i++;
		}
		/**
		 * If all the 2nd part elements are gone,
		 * Remains only the first part then,
		 * While is better because we do not want to advance the next item,
		 * until it is actually stored in original array ok.
		 */
		while(first1 <= last1) {
			result[i++] = array[first1++];
			
		}
		/**
		 * If all first part elements are gone,
		 * Remains only second part elements, then
		 */
		while(first2 <= last2) {
			result[i++] = array[first2++];
			
		}
		//Finally, we just copy contents modified into original array, from results
		for(i = first; i <= last; i++) {
			array[i] = result[i];
		}
	}
}
