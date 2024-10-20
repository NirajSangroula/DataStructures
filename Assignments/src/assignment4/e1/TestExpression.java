package assignment4.e1;

import java.util.Scanner;

public class TestExpression {

	public static void main(String[] args) {
		try (Scanner s = new Scanner(System.in)) {
			System.out.println("Enter an expression (No unary operators): ");
			Calculator e1 = new Calculator(s.next());
			System.out.println("Postfix : " + e1.getPostFix());
			System.out.println("Result: " + e1.evaluate());
		} catch (IllegalStateException e) {
			System.out.println(e.getMessage());
		}
	}
}
