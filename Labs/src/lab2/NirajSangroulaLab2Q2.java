/**
Author: Niraj Sangroula
Student ID: 219586770
Lab 2
Any and all work in this file is my own.
*/
package lab2;

import java.util.Scanner;

public class NirajSangroulaLab2Q2 {

	public static void main(String[] args) {
		System.out.println("Enter an integer: ");
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		System.out.println("Reverse is: ");
		reverse(n);
	}
	//Returns absolute value of the given integer
	public static int absoluteValue(int n) {
		return (n < 0)?(-n):n; //Return -n if the number is negative, to make it positive
	}

	public static void reverse(int n) {
		//Base case is the number is one digit ((3/10 is 0, 12/10 is 1 (Integer division rule))
		if(n / 10 == 0) {
			if(n < 0)
				System.out.print(absoluteValue(n)+"-"); // Should print the - sign after the number if it is negative (As overall sign is preserved in division)
			else
				System.out.print(absoluteValue(n));
		}
		else {
			//Print the last part (Be sure, to print absolute value ((Because we support negative numbers too))
			//Also, if the last digits are 000 eg. 12000, it will print 00021 (Because we would need special methodology to support 0 filters)
			System.out.print(absoluteValue(n % 10));
			//The remaining digits are reverse of number with last digit stripped away
			reverse(n / 10);
		}
	}

}
