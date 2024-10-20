package lab2;

import java.util.Scanner;

public class PrefixPostfixConversion {

	public static void main(String[] args) {
		System.out.println("Enter prefix expression");
		Scanner scanner = new Scanner(System.in);
		//We use StringBuffer to make it mutable
		Prefix p = new Prefix(scanner.next());
		if(p.isValid())
			System.out.println("Postfix expression is : " + p.getPostfix());
		else
			System.out.println("Invalid postfix expression");
	}
	

}
