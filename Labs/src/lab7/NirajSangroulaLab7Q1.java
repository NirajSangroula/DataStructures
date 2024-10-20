/**
Author: Niraj Sangroula
Student ID: 219586770
Lab 7
Any and all work in this file is my own.
*/
package lab7;

public class NirajSangroulaLab7Q1 {

	public static void main(String[] args) {
		try {
			SingleSortedLinkedList names = new SingleSortedLinkedList();
			//Inserting data
			names.insert("Niraj");
			System.out.println(names);
			names.insert("Nitesh");
			System.out.println(names);
			names.insert("Akash");
			System.out.println(names);
			names.insert("Abirman");
			System.out.println(names);
			names.insert("Zeff");
			System.out.println(names);
			names.insert("Ranju");
			System.out.println(names);
			names.insert("Kabita");
			System.out.println(names);
			names.insert("Aayushman");
			System.out.println(names);
			names.insert("Zeref");
			System.out.println(names);
			names.insert("Zeffrey");
			System.out.println(names);
			
			System.out.println("\nRemoving 3 names\n");
			System.out.println(names.remove(names.find("Aayushman")) + " Removed");
			System.out.println(names);
			System.out.println(names.remove(names.find("Akash")) + " Removed");
			System.out.println(names);
			System.out.println(names.remove(names.find("Zeff")) + " Removed");
			System.out.println(names);
		}
		catch(ListException e) {
			System.out.println(e.getMessage());
		}
	}

}
