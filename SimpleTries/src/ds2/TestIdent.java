package ds2;

import java.util.Scanner;

public class TestIdent {

	public static void main(String[] args) {
		TestGrammar tp = new TestGrammar();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a word: ");
		String w = sc.next();
		System.out.println((tp.isIdentifier(w)?"Identifier": "Not Identifier"));
		System.out.println((tp.isPallindrome(w)?"Pallindrome": "Not Pallindrome"));
		System.out.println((tp.isAnBn(w)?"Correct AnBn": "Not Correct AnBn"));

	}

}
