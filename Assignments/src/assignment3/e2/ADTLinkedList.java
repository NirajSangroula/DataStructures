package assignment3.e2;

public class ADTLinkedList implements ADTListInterface{

	class Node{
		Object data;
		Node next;
		
		Node(Object data){
			this.data = data;
			next = null;
		}
	}
	
	Node head;
	
	@Override
	public boolean isEmpty() {
		return head == null;
	}

	@Override
	public int getLength() {
		int count = 0;
		for(Node current = head; current != null; current = current.next) {
			count++;
		}
		return count;
	}

	@Override
	public void insert(int i, Object o) throws ListException {
		if(i < 0 || i > getLength())
			throw new ListException("Cannot insert at the given index");
		else {
			if(isEmpty()) {
				Node n = new Node(o);
				head = n;
			}
			else if(i == 0) {
				Node n = new Node(o);
				n.next = head;
				head = n;
			}
			else {
				int currentIndex = 0;
				for(Node current = head; current != null; current = current.next) {
					if(currentIndex == i - 1) {
						Node n = new Node(o);
						n.next = current.next;
						current.next = n;
						break;
					}						
					currentIndex++;
				}
			}
		}
		
	}

	/**
	 * When inserted in between, it shifts other elements to the right, removing the last one
	 * Does not resize
	 * 
	 * @param i
	 * @param o
	 * @throws ListException
	 */
	public void replace(int i, Object o) throws ListException {
		if(i < 0 || i > getLength())
			throw new ListException("Cannot insert at the given index");
		else {
			if(isEmpty()) {
				Node n = new Node(o);
				head = n;
			}
			else if(i == 0) {
				Node n = new Node(o);
				n.next = head;
				head = n;
			}
			else {
				int currentIndex = 0;
				for(Node current = head; current != null; current = current.next) {
					if(currentIndex == i - 1) {
						Node n = new Node(o);
						n.next = current.next.next; //We remove current.next and replace with new node
						current.next = n;
						break;
					}						
					currentIndex++;
				}
			}
		}
	}
	@Override
	public void remove(int i) throws ListException {
		if(i < 0 || i >= getLength())
			throw new ListException("Item doesn't exist");
		else {
			if(i == 0) {
				head = head.next;
			}
			else {
				int currentIndex = 0;
				for(Node current = head; current != null; current = current.next) {
					if(currentIndex == i - 1) {
						current.next = current.next.next;
						break;
					}					
					currentIndex++;
				}
			}
		}
	}

	@Override
	public void removeAll() {
		head = null;
	}

	@Override
	public Object get(int i) throws ListException {
		if(i < 0 || i >= getLength())
			throw new ListException("Item doesn't exist");
		else {
			int currentIndex = 0;
			for(Node current = head; current != null; current = current.next, currentIndex++) {
				if(currentIndex == i)
					return current.data;
			}
		}
		return null;
	}


	
	public void displayRecursive(Node n) {
		if(n != null) {
			System.out.println(n.data);
			displayRecursive(n.next);
		}
	}
}
