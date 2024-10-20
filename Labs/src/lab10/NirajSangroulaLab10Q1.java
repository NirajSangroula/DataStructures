/**
Author: Niraj Sangroula
Student ID: 219586770
Lab 10
Any and all work in this file is my own.
*/

package lab10;

import java.util.Arrays;

public class NirajSangroulaLab10Q1 {

	public static void main(String[] args) {
		int[] array = {10, 20, 15, 25, 2, 8, 5, 32, 54, 9, 4, 6, 1, 55, 97, 45};
		System.out.println("Index of 9 : " + sequentialSearch(array, 9));
		System.out.println("Index of 12: " + sequentialSearch(array, 12));

		System.out.println("Before sorting " + Arrays.toString(array));
		bubbleSort(array);
		System.out.println("After sorting in ascending order" + Arrays.toString(array));
		

		System.out.println("Index of 20 : " + binarySearch(array, 0, array.length - 1, 20));
		System.out.println("Index of 3: " + binarySearch(array, 0, array.length - 1, 3));
		

		System.out.println("Array before sorting : " + Arrays.toString(array));
		array = mergeSort(array);

		System.out.println("Array after sorting in descending order: " + Arrays.toString(array));
	}


	public static int sequentialSearch(int[] array, int k) {
		for(int i = 0; i < array.length; i++) {
			if(array[i] == k)
				return i;
		}
		return -1;
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
	public static int binarySearch(int[] array, int start, int end, int k) {
		//We are done when start becomes > end, We will allow start = end, so that the only element becomes mid value
		//And it's index is returned
		if(start < 0 || start >= array.length || end < 0 || end >= array.length || start > end) {
			return -1;
		}
		else {
			int mid = (start + end) / 2;
			if(array[mid] == k)
				return mid;
			else if(k < array[mid])
				return binarySearch(array, start, mid - 1, k);
			else 
				return binarySearch(array, mid + 1, end, k);
		}
	}
	public static int[] mergeSort(int[] array) {
		if(array.length == 1) {
			return array;
		}
		else {
			//We want to find the mid index, (first + last) / 2 (first = 0 and last = length -1
			// Therefore, (first + last) = (0 + length - 1) / 2
			int mid = (array.length - 1) / 2;
			//Divide array into 2 parts index, 0 to mid and mid + 1 to endOfArray
			int[] b = copyArray(array, 0, mid);
			int[] c = copyArray(array, mid + 1, array.length - 1);
			//MergeSort both So that they are sorted each
			b = mergeSort(b);
			c = mergeSort(c);
			//Merge sorted arrays together
			int a[] = merge(b, c);
			return a;
		}
	}
	
	public static int[] merge(int[] a, int[] b) {
		//length of both arrays
		int x = a.length;
		int y = b.length;
		//result variable where result will be added each time by comparing each elements of a with b
		int[] result = new int[x + y];
		//Initialize index of all 3 arrays
		int aPos = 0, bPos = 0, i = 0;
		
		//While both positions are valid
		while((aPos < x) && (bPos < y)) {
			//Move bigger number to result and increase the indices
			if(a[aPos] < b[bPos]) {
				result[i++] = b[bPos++];
			}
			else {
				result[i++] = a[aPos++];
			}
		}
		//If anything from left array is left, move to the result
		while(aPos < x) {
			result[i++] = a[aPos++];
			
		}
		//If anything from right array is left, move to the result
		while(bPos < y) {
			result[i++] = b[bPos++];
			
		}
		
		return result;
	}

	public static int[] copyArray(int[] array, int from, int to) {
		//Create a result array of calculated size
		int[] a = new int[to - from + 1];
		//Set the subarray
		for(int i = from, j = 0; i <= to; i++, j++) {
			a[j] = array[i];
		}
		return a;
	}
}
