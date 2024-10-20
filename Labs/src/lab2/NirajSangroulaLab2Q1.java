/**
Author: Niraj Sangroula
Student ID: 219586770
Lab 2
Any and all work in this file is my own.
*/
package lab2;

import java.util.Scanner;

public class NirajSangroulaLab2Q1 {

	public static void main(String[] args) {
		System.out.println("Enter a string: ");
		Scanner s = new Scanner(System.in);
		String str = s.nextLine();
		System.out.println("The maximum character is : " + maximumChar(str, (char)0));
	}
/**
 * 
 * @param str
 * @param c
 * @return max character of the string (Between 0 to higher)
 * 
 * Returns the maximum character of the string and the character c
 */
	public static char maximumChar(String str, char c) {
		//Base case is if the str is empty and argument has the max character at this point
		if(str.length() == 0) {
			return c;
		}
		else {
			String newStr = str.substring(1); // Strips first character off the string to create a new string
			//Check if the first character is > parameter, and pass it next time if it is true
			if(str.charAt(0) > c) { 
				return maximumChar(newStr, str.charAt(0)); // The maximum character of the original call is (max of newStr and strippedIndex(Which was max till now))
			}
			else
				return maximumChar(newStr, c); // The maximum char is the same as parameter, not the stripped first character so we pass (c) as second arguement
		}
	}
	
	

}
