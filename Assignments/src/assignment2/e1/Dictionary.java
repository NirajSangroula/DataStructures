package assignment2.e1;

import java.util.Scanner;

public class Dictionary {

	public static void main(String[] args) {
		String[] dictionary = new String[] {
				"apple",
				"applet",
				"ball",
				"cat",
				"dog",
				"donkey",
				"zebra"
		};
		Scanner s = new Scanner(System.in);
		System.out.println("Enter a word: ");
		int index = binarySearch(dictionary, s.next(), 0, dictionary.length - 1);
		if(index == -1)
			System.out.println("Word not found");
		else
			System.out.println("Word found at index " + index);
	}
	public static int binarySearch(String[] dictionary, String value, int start, int end) {
		int index;
		if(start > end) {
			index = -1;; //Value is not in the dictionary
		}
		else {
			int midIndex = (start + end) / 2;
			if(dictionary[midIndex].equalsIgnoreCase(value))
				index = midIndex;
			else {
				if(value.compareToIgnoreCase(dictionary[midIndex]) < 0) { //The value is smaller than mid value (a b)
					index = binarySearch(dictionary, value, start, midIndex - 1);
				}
				else{
					index = binarySearch(dictionary, value, midIndex + 1, end);
				}
			}
		}
		return index;
	}
	
	/**
	 * binarySearch(array, searchValue, start, end)
	 * 
	 * (1, 2, 3, 4, 5) == search for 4
	 * 3 -> not matched (index 2)
	 * find which half contain (2 + 1, 4)
	 * 3.5 -> 3, -> match
	 * 
	 * ((search for 6))
	 * 3.5 -> 3 not match,
	 * (search in (4, 4)
	 * ((Gets 4 )) -> Not match,
	 * Next time, (5, 4) --> We increase so...
	 * 
	 * start > end, so not found
	 * Sorted
	 * 
	 * (start and end -> 0 and 4
	 * 
	 * 
	 * if(start > end)
	 * 
	 * 
	 */

}
