/**
Author: Niraj Sangroula
Student ID: 219586770
Lab 8 P3
Any and all work in this file is my own.
*/
package lab8;

import java.util.Scanner;

public class NirajSangroulaLab8Q1P3Test {

	public static void main(String[] args) {
		try {
			//Get input
			System.out.println("Enter a string");
			Scanner sc = new Scanner(System.in);
			String str = sc.nextLine();
			NirajSangroulaLab8Q1P1Stack stack = new NirajSangroulaLab8Q1P1Stack(str.length());
			boolean moreClosingParenthesis = false;
			//Test string
			for(char c : str.toCharArray()) {
				//Add ( each time to stack
				if(c == '(')
					stack.push(c);
				if(c == ')') {
					//If no ( but, entered ) then, it has extra closing parenthesis
					if(stack.isEmpty()) {
						//Set a flag true and exit the loop
						moreClosingParenthesis = true;
						break;
					}
					stack.pop();
				}
			}
			//If extra closing parenthesis
			if(moreClosingParenthesis)
				System.out.println("The string \"" + str + "\" has too many closing parenthesis");
			//If stack is empty, and we are good to go
			else if(stack.isEmpty())
				System.out.println("String is valid");
			//Otherwise if it has some (
			else
				System.out.println("The string \"" + str + "\" has too many opening parenthesis");	
		}
		catch(NirajSangroulaLab8Q1StackException e) {
			System.err.println(e.getMessage());
		}
	}

}
