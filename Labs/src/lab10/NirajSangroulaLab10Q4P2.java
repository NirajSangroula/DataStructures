/**
Author: Niraj Sangroula
Student ID: 219586770
Lab 10 Q4 P2
Any and all work in this file is my own.
*/
package lab10;

import java.util.Arrays;

public class NirajSangroulaLab10Q4P2 {

	public static void main(String[] args) {
		int[] array = {10, 20, 15, 25, 2, 8, 5, 32, 54, 9, 4, 6, 1, 55, 97, 45};
		System.out.println("Array before sorting : " + Arrays.toString(array));
		array = mergeSort(array);

		System.out.println("Array after sorting in descending order: " + Arrays.toString(array));
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
