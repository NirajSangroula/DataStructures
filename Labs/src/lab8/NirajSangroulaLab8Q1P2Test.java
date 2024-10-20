/**
Author: Niraj Sangroula
Student ID: 219586770
Lab 8 P2
Any and all work in this file is my own.
*/
package lab8;

import java.util.Scanner;

public class NirajSangroulaLab8Q1P2Test {

	public static void main(String[] args) {
		try {
			//Read string
			System.out.println("Enter a string");
			Scanner sc = new Scanner(System.in);
			String str = sc.nextLine();
			NirajSangroulaLab8Q1P1Stack stack = new NirajSangroulaLab8Q1P1Stack(str.length());
			//Insert data to stack
			for(char c : str.toCharArray()) {
				stack.push(c);
			}
			//Keep popping and print until stack is empty
			while(!stack.isEmpty()) {
				System.out.print(stack.pop());
			}
			
		}
		catch(NirajSangroulaLab8Q1StackException e) {
			System.err.println(e.getMessage());
		}
	}

}
