/**
 * Name: Niraj Sangroula
 * Course: COSC 2007T
 * Student No: 219886770
 * email: nsangroula@algomau.ca
 */
package Lab1;

public class DoublyLinkedList {
	class Node {
		int data;
		Node next;
		Node prev;
		Node(int data) {
			//Initialize data
			this.data = data;
			this.next = null;
			this.prev = null;
		}
	}
	
	Node head;
	
	public void insertLast(int data) {
		//If list is empty when method is called just insert node
		if(head == null) {
			Node n = new Node(data);
			head = n;
		}
		else {
			Node lastNode = null;
			for(Node curr = head; curr != null; curr = curr.next) {
				//Search for last node
				if(curr.next == null) {
					lastNode = curr;
				}
			}
			//There we reached to the last node
			Node newNode = new Node(data);
			//Set new node's previous
			newNode.prev = lastNode;
			//Set old tail's next
			lastNode.next = newNode;
		}
	}
	
	public void insertFirst(int data) {
		//n gets to be head whose next is previous head
		Node n = new Node(data);
		n.next = head;
		head = n;
	}

	public void insertAfter(int x, int data) {
		//found keeps track of successful insertion
		boolean found = false;
		for(Node curr = head; curr != null; curr = curr.next) {
			if(curr.data == x) {
					found = true;
					Node n = new Node(data);
					//current detaches and its next is assigned to node's next
					n.next = curr.next;
					n.prev = curr;
					curr.next = n;
			}
		}
		if(!found)
			throw new ListException("Item " + x + " does not exist in the list");
	}

	public void delete(int x) {
		//Keep track of successful finding of data
		boolean found = false;
		for(Node curr = head; curr != null; curr = curr.next) {
			if(curr.data == x) {
				found = true;
				//If it is first element, we change head too
				if(curr == head) {
					head = curr.next;
					//If now list is not empty, we need to set prev of head null
					if(curr.next != null) {
						head.prev = null;
					}
				}
				else {
					curr.prev.next = curr.next;
				}
			}
		}
		if(!found)
			throw new ListException("Item " + x + " does not exist in the list");
	}
	
	public void display() {
		for(Node curr = head; curr != null; curr = curr.next) {
			System.out.print(curr.data + " ");
		}
		//To print double new lines
		System.out.println("\n");
	}
}
