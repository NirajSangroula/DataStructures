/**
Author: Niraj Sangroula
Student ID: 219586770
Lab 3
Any and all work in this file is my own.
*/
package lab3;

import java.util.Scanner;

public class NirajSangroulaLab3Q2 {

	public static void main(String[] args) {
		System.out.println("Enter a number: ");
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		//Create an array to store n fibonacci numbers
		int[] fibonacci = new int[n];
		for(int i = 0; i < n; i++) {
			fibonacci[i] = fib(i + 1);
		}
		System.out.println("Fibonacci sequence is : ");
		for(int i = 0; i < n; i++) {
			System.out.print(fibonacci[i] + " ");
		}

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
