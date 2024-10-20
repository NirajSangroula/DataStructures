package assignment2.e1;

import java.util.Scanner;

public class RecurrenceValue {

	public static void main(String[] args) {
		System.out.println("Enter a number : ");
		Scanner s = new Scanner(System.in);
		System.out.println("The value is : " + recurrenceValue(s.nextInt()));
	
	}
	
	public static int recurrenceValue(int n) {
		if(n == 1)
			return 1;
		else if(n == 2)
			return 2;
		else if(n == 3)
			return 3;
		else if(n == 4)
			return 2;
		else if(n == 5)
			return 4;
		else {
			/**
			 * if a, b c d and e correspond to 1, 2, 3, 4, 5
 			 * next = 2 * e + a
 			 * according the recursive method
			 */
			int a = 1, b = 2, c = 3, d = 2, e = 4, next = -1;
			for(int i = 5; i < n; i++) {
				next = 2 * e + a;
				a = b;
				b = c;
				c = d;
				d = e;
				e = next;
			}
			//At this point, the next is the exact answer, 
			return next;
		}
	}

}
