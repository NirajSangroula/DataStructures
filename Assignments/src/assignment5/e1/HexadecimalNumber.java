package assignment5.e1;

import java.util.Scanner;

public class HexadecimalNumber {
	public static void main(String[] args) {
		System.out.println("Enter a decimal number: ");
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		System.out.println("Hexadecimal for " + n + " = " + convertToHexadecimal(n));
	}
	
	public static String convertToHexadecimal(int n) {
		String hexadecimal = "";
		ReferenceStack<Character> stack = new ReferenceStack<>();
		int temp = n;
		while(temp > 0) {
			stack.push(convertToHexaDigit(temp % 16));
			temp /= 16;
		}
		
		while(!stack.isEmpty())
			hexadecimal += stack.pop();
		return hexadecimal;
	}
	
	public static char convertToHexaDigit(int n) {
			switch(n) {
			case 10: return 'A';
			case 11: return 'B';
			case 12: return 'C';
			case 13: return 'D';
			case 14: return 'E';
			case 15: return 'F';
			default: return String.valueOf(n).charAt(0);
			}
	}
}
