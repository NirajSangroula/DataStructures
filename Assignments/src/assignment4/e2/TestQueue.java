package assignment4.e2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TestQueue {

	public static void main(String[] args) {
		try {
			//Put numbers.txt file in project folder alongside src
			Scanner sc = new Scanner(new FileInputStream("numbers.txt"));
			Queue<Integer> positive = new Queue<Integer>();
			Queue<Integer> negative = new Queue<Integer>();
			while(sc.hasNext()) {
				int n = sc.nextInt();
				if(n < 0)
					negative.enqueue(n);
				else
					positive.enqueue(n);
			}
			System.out.println("Printing positive numbers: ");
			while(!positive.isEmpty()) {
				System.out.print(positive.dequeue() + " ");
			}

			System.out.println("\nPrinting negative numbers: ");
			while(!negative.isEmpty()) {
				System.out.print(negative.dequeue() + " ");
			}
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (QueueException e) {
			System.out.println(e.getMessage());
		}

	}

}
