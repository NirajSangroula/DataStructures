/**
Author: Niraj Sangroula
Student ID: 219586770
Lab 5
Any and all work in this file is my own.
*/
package lab5;

public class NirajSangroulaLab5Q1 {

	public static void main(String[] args) {
		try {
			ADTList l1 = new ADTList(8);
			//Milk, Eggs, Celery, Bananas, Apples, Oranges, Cookies, Steak
			l1.add("Milk", 0);
			System.out.println(l1);
			l1.add("Eggs", 1);
			System.out.println(l1);
			l1.add("Celery", 2);
			System.out.println(l1);
			l1.add("Bananas", 3);
			System.out.println(l1);
			l1.add("Apples", 4);
			System.out.println(l1);
			l1.add("Oranges", 5);
			System.out.println(l1);
			l1.add("Cookies", 6);
			System.out.println(l1);
			l1.add("Steak", 7);
			System.out.println(l1);
			
			System.out.println("\nRemoving Celery and Oranges one by one");
			l1.remove(l1.find("Celery"));
			System.out.println(l1);		
			l1.remove(l1.find("Oranges"));
			System.out.println(l1);	
			
			System.out.println("\nBefore swapping");
			System.out.println(l1);	
			System.out.println("\nAfter swapping the values with indices 1 and 3");
			swap(l1, 1, 3);
			System.out.println(l1);	
		}
		catch(ListException e) {
			System.out.println(e.getMessage());
		}

	}
	
	public static void swap(ADTList l, int i, int j) {
		if(i < 0 || i >= l.size() || j < 0 || j >= l.size())
			throw new ListException("IndexOutOfBounds: Index is not in the range 0 to " + (l.size() - 1));
		else {
			String tempI = l.get(i);
			String tempJ = l.get(j);
			l.remove(j);
			l.add(tempI, j);
			l.remove(i);
			l.add(tempJ, i);			
		}
	}

}
