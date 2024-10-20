package assignment3.e1;

public class LinkedList {
	class Node{
		Object data;
		Node next;
		
		Node(Object data){
			this.data = data;
			next = null;
		}
	}
	
	Node head;
	Node tail;
	
	public void insertBeginning(Object data) {
		Node n = new Node(data);
		if(head == null) {
			head = n;
			tail = n;
		}
		else {
			n.next = head; // First set next after new node, be current head (Which will be 2nd element)
			head = n; // Now set the head
		}
	}
	
	public void deleteBeginning() {
		if(head != null) {
			if(head.next != null)
				head = head.next;
			else {
				head = null;
				tail = null;
			}
		} 
	}
	//This method assumes that we have head only
	public void insertEnd(Object data) {
		Node n = new Node(data);
		if(head == null) {
			head = n;
			tail = n;
		}
		else {
			for(Node curr = head; curr != null; curr = curr.next) {
				if(curr.next == null) {
					curr.next = n;
					tail = n;
					break;
				}
			}
		}
	}
	
	public void deleteEnd() {
		if(head != null) {
			if(head.next == null) {
				head = null;
				tail = null;
			}
			else
				for(Node curr = head; curr != null; curr = curr.next) {
					if(curr.next.next == null) { // if ob1-ob2-null (ob1.next = null) means ob1-null
						curr.next = null;
						tail = curr;
						break;
					}
				}
		}
		
	}
	//This method assumes that we have access to tail as well
	public void insertEnd2(Object data) {
		Node n = new Node(data);
		if(head == null) {
			head = n;
			tail = n;
		}
		else {
			/**
			 * We assume having tail as well
			 */
			tail.next = n;
			tail = n;
		}
	}
	//This method assumes that we have access to tail as well
	public void deleteEnd2() {
		if(head != null) {
			if(head.next == null) {
				head = null;
				tail = null;
			}
			else 
				for(Node curr = head; curr != null; curr = curr.next) {
					/**
					 * We assume having tail as well
					 */
					if(curr.next == tail) {
						curr.next = null;
						tail = curr;
						break;
					}
			}
		}
	}
	
	public void displayRecursive(Node n) {
		if(n != null) {
			System.out.println(n.data);
			displayRecursive(n.next);
		}
	}
}
