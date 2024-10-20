/**
Author: Niraj Sangroula
Student ID: 219586770
Lab 10 Q2 P1
Any and all work in this file is my own.
*/
package lab10;

import java.util.Arrays;

public class NirajSangroulaLab10Q2P1 {

	public static void main(String[] args) {
		int[] array = {10, 20, 15, 25, 2, 8, 5, 32, 54, 9, 4, 6, 1, 55, 97, 45};
		System.out.println("Before sorting " + Arrays.toString(array));
		bubbleSort(array);
		System.out.println("After sorting in ascending order" + Arrays.toString(array));
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

}
