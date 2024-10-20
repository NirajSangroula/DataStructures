/**
Author: Niraj Sangroula
Student ID: 219586770
Lab 10 Q3 P2
Any and all work in this file is my own.
*/
package lab10;

public class NirajSangroulalab10Q3P2 {

	public static void main(String[] args) {
		int[] array = {1, 2, 4, 5, 6, 8, 9, 10, 15, 20, 25, 32, 45, 54, 55, 97};
		System.out.println("Index of 20 : " + binarySearch(array, 0, array.length - 1, 20));
		System.out.println("Index of a number 888 that doesn't exist: " + binarySearch(array, 0, array.length - 1, 888));
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
}
