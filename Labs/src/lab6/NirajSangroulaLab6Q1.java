/**
Author: Niraj Sangroula
Student ID: 219586770
Lab 6
Any and all work in this file is my own.
*/
package lab6;

public class NirajSangroulaLab6Q1 {

	public static void main(String[] args) {
		try {
			SingleLinkedList l = new SingleLinkedList();
			l.add("Milk", 0);
			System.out.println(l);
			l.add("Eggs", 1);
			System.out.println(l);
			l.add("Celery", 2);
			System.out.println(l);
			l.add("Bananas", 3);
			System.out.println(l);
			l.add("Apples", 4);
			System.out.println(l);
			l.add("Oranges", 5);
			System.out.println(l);
			l.add("Cookies", 6);
			System.out.println(l);
			l.add("Steak", 7);
			System.out.println(l);
			
			System.out.println("Removing " + l.remove(l.find("Celery")));
			System.out.println(l);
			System.out.println("Removing " + l.remove(l.find("Oranges")));
			System.out.println(l);
		}
		catch(ListException l) {
			System.out.println(l.getMessage());
		}
		
	}

}
