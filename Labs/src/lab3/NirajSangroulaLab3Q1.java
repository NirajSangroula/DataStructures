/**
Author: Niraj Sangroula
Student ID: 219586770
Lab 3
Any and all work in this file is my own.
*/
package lab3;

import java.util.Scanner;

public class NirajSangroulaLab3Q1 {

	public static void main(String[] args) {
		System.out.println("Enter a number: ");
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		//Simply display the number using function
		System.out.println("Fibonacci number is " + fib(n));
		
	}
	
	public static int fib(int n) {
		//Base cases
		if(n == 1)
			return 1;
		else if(n == 2)
			return 1;
		else
			return fib(n - 1) + fib(n - 2); // Definition of fibonacci number
	}

}
