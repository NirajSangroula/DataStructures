package finalexam;

import java.util.Scanner;

public class PallindromeRecursion {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println(isPallindrome(sc.next()));

	}
	
	static boolean isPallindrome(String s) {
		if(s.length() == 0)
			return true;
		else if(s.length() == 1)
			return true;
		else {
			if(s.charAt(0) == s.charAt(s.length() - 1)) {
				String cut = s.substring(1, s.length() - 1);
				return isPallindrome(cut);
			}
			else
				return false;
			// abcd
		}
	}
	
	// aba aa x   
	// 

}
