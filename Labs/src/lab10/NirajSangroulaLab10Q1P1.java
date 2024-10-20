/**
Author: Niraj Sangroula
Student ID: 219586770
Lab 10 Q1 P1
Any and all work in this file is my own.
*/
package lab10;

public class NirajSangroulaLab10Q1P1 {

	public static void main(String[] args) {
		int[] array = {10, 20, 15, 25, 2, 8, 5, 32, 54, 9, 4, 6, 1, 55, 97, 45};
		System.out.println("Index of 9 : " + sequentialSearch(array, 9));
		System.out.println("Index of a number 888 that doesn't exist: " + sequentialSearch(array, 888));
		
		
	}
	
	public static int sequentialSearch(int[] array, int k) {
		for(int i = 0; i < array.length; i++) {
			if(array[i] == k)
				return i;
		}
		return -1;
	}

}
