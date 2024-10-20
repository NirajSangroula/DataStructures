package linkedlist;

public class LinkedList {
	class Node {
		int data;
		Node next;
		
		Node(int data) {
			this.data = data;
			this.next = null;
		}
	}
	
	Node head;
	Node tail;
	
	public void insert(int data) {
		if(head == null) {
			Node n = new Node(data);
			head = n;
			tail = n;
		}
		else {
			Node n = new Node(data);
			tail.next = n;
			tail = n;
		}
	}
	

	public void insertAfter(int x, int data) {
		for(Node curr = head; curr != null; curr = curr.next) {
			if(curr.data == x) {
				if(curr == tail) {
					Node n = new Node(data);
					curr.next = n;
					break;				
					
				}
				else {
					Node n = new Node(data);
					n.next = curr.next;
					curr.next = n;
					break;					
				}
			}
		}
	}

	
	public void display() {
		for(Node curr = head; curr != null; curr = curr.next) {
			System.out.println(curr.data);
		}
	}
	
	public void displayRecursively(Node n) {
		if(n != null) {
			System.out.println(n.data);
			displayRecursively(n.next);			
		}
	}
}
