/**
Author: Niraj Sangroula
Student ID: 219586770
Lab 9
Any and all work in this file is my own.
*/
package lab9;

public class NirajSangroulaLab9Q1Test {

	public static void main(String[] args) {
		try {
			NirajSangroulaLab9Q1Queue q = new NirajSangroulaLab9Q1Queue();
			//Enqueue and display each time
			q.enqueue("Niraj Sangroula");
			System.out.println(q);
			q.enqueue("Akash Khatri");
			System.out.println(q);
			q.enqueue("Nitesh Sangroula");
			System.out.println(q);
			q.enqueue("Kumar Sanu");
			System.out.println(q);
			q.enqueue("Udit Narayan");
			System.out.println(q);
			q.enqueue("Narayan Gopal");
			System.out.println(q);
			q.enqueue("Gopal Yonjan");
			System.out.println(q);
			q.enqueue("Gulam Ali");
			System.out.println(q);
			q.enqueue("Bhakta Raj Acharya");
			System.out.println(q);
			q.enqueue("Sugam Pokhrel");
			System.out.println(q);
			
			//Dequeue and display
			System.out.println("\nRemoving names: ");
			System.out.println("\nRemoving " + q.dequeue());
			System.out.println(q);
			System.out.println("\nRemoving " + q.dequeue());
			System.out.println(q);
			System.out.println("\nRemoving " + q.dequeue());
			System.out.println(q);
			System.out.println("\nRemoving " + q.dequeue());
			System.out.println(q);
		} 
		catch (NirajSangroulaLab9Q1QueueException e) {
			System.err.println(e.getMessage());
		}
	}
}
