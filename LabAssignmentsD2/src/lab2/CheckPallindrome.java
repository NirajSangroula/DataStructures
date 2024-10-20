package lab2;

import java.util.Scanner;

public class CheckPallindrome {

	public static void main(String[] args) {
		System.out.println("Enter a word to check: ");
		Scanner scanner = new Scanner(System.in);
		if(isPallindrome(scanner.next())) {
			System.out.println("The word is pallindrome.");
		}
		else {
			System.out.println("The word is not pallindrome.");
		}

	}
	static boolean isPallindrome(String w) {
		//Base case when length is 0 or 1
		if(w.length() == 0)
			return true;
		if(w.length() == 1)
			return true;
		else {
			//Test first and last character equal or not
			if(w.charAt(0) == w.charAt(w.length() - 1)) {
				return isPallindrome(substringFirstLast(w));
			}
			else
				return false;
		}
	}
	
	static String substringFirstLast(String w) {
		//Stripping first and last character of word length 0, 1, 2 Should be empty
		if(w.length() < 3)
			return "";
		else
			return w.substring(1, w.length() - 1);
	}

}
