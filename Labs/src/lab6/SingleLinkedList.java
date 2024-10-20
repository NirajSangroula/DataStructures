/**
Author: Niraj Sangroula
Student ID: 219586770
Lab 6
Any and all work in this file is my own.
*/
package lab6;

public class SingleLinkedList {
	private SingleNode head;
	
	//Checks if there are any elements
	public boolean isEmpty() {
		return head == null;
	}
	
	public int size() {
		int count = 0;
		//Iterate until current item is null and count every time
		for(SingleNode current = head; current != null; current = current.next) {
			count++;
		}
		return count;
	}
	
	public void add(String item, int i) throws ListException {
		if(i < 0 || i > size())
			throw new ListException("Cannot insert at the given index because it is not between 0 and " + size());
		else {
			if(i == 0) {
				SingleNode n = new SingleNode(item, head);
				head = n;
			}
			else {
				int currentIndex = 0;
				for(SingleNode current = head; current != null; current = current.next) {
					//If this is the previous to the place to be inserted
					if(currentIndex == i - 1) {
						SingleNode n = new SingleNode(item, current.next);
						current.next = n;
						break;
					}						
					currentIndex++;
				}
			}
		}
		
	}
	
	public String remove(int i) throws ListException {
		if(i < 0 || i >= size())
			throw new ListException("Item doesn't exist. Index should be between 0 and " + (size() - 1));
		else {
			String removed = get(i);
			if(i == 0) {
				head = head.next;
			}
			else {
				int currentIndex = 0;
				for(SingleNode current = head; current != null; current = current.next) {
					//If this position is previous to removing item position
					if(currentIndex == i - 1) {
						current.next = current.next.next;
						break;
					}					
					currentIndex++;
				}
			}
			return removed;
		}
	}
	
	public void removeAll() {
		head = null;
	}
	
	public String get(int i) throws ListException {
		if(i < 0 || i >= size())
			throw new ListException("Item doesn't exist. Index should be between 0 and " + (size() - 1));
		else {
			int currentIndex = 0;
			for(SingleNode current = head; current != null; current = current.next, currentIndex++) {
				if(currentIndex == i)
					return current.data;
			}
		}
		return null;
	}
	
	public int find(String item) {
		//Initialized for counting
		int i = 0;
		for(SingleNode current = head; current != null; current = current.next, i++) {
			if(current.data.equals(item))
				return i;
		}
		//Default value to be returned if not found
		return -1;
	}
	
	@Override
	public String toString() {
		String value = "";
		for(SingleNode current = head; current != null; current = current.next) {
			value += current.data + "->";
		}
		return value + "null";
	}
	
}
