/**
Author: Niraj Sangroula
Student ID: 219586770
Lab 3
Any and all work in this file is my own.
*/
package lab3;

import java.util.Scanner;

public class NirajSangroulaLab3Q3 {

	public static void main(String[] args) {
		System.out.println("Enter a number: ");
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		
		System.out.println("Print up method");
		printUp(n);
		System.out.println("Print down method");
		printDown(n);

	}

	public static void printUp(int n) {
		if(n == 0) {
			
		}
		else {
			//First print others and the print own at last
			printUp(n - 1);
			for(int i = 1; i <= n; i++) {
				System.out.print("* ");
			}
			System.out.println();
		}
	}
	
	public static void printDown(int n) {
		if(n == 0) {
			
		}
		else {
			//Print own symbols first and then print others
			for(int i = 1; i <= n; i++) {
				System.out.print("* ");
			}
			System.out.println();
			printDown(n - 1);
		}
	}
}
