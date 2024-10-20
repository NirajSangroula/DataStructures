/**
 * Name: Niraj Sangroula
 * Course: COSC 2007T
 * Student No: 219886770
 * email: nsangroula@algomau.ca
 */
package Lab1;

public class TestDoublyLinkedList {

	public static void main(String[] args) {
		DoublyLinkedList l = new DoublyLinkedList();
		System.out.println("Doubly linked list with 10 Nodes: ");
		//Numbers from 101 to 110 are inserted first
		for(int i = 101; i <= (100 + 10); i++) {
			l.insertLast(i);
		}
		l.display();
		
		System.out.println("Inserting 900 after 103");
		l.insertAfter(103, 900);
		l.display();
		
		System.out.println("Inserting 8000 at last");
		l.insertLast(8000);
		l.display();
		
		System.out.println("Inserting 3 at first");
		l.insertFirst(3);
		l.display();

		System.out.println("Deleting 102");
		l.delete(102);
		l.display();

	}

}
