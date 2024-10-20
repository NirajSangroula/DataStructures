/**
Author: Niraj Sangroula
Student ID: 219586770
Lab 7
Any and all work in this file is my own.
*/
package lab7;

public class SingleSortedLinkedList {
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
	
	public void insert(String item) throws ListException {
		//If the list is empty, we can't go through loop
		if(isEmpty()) {
			SingleNode n = new SingleNode(item);
			head = n;
		}
		else {
			//We retain current and previous scope, so that we keep track if current had to loop till it is null
			//It will mean that, the end of the loop had to be reached and the data wasn't still inserted
			SingleNode current = head, previous = null;
			//We run to insert at the first place, or between previous and current. (We still don't insert after current)
			for(; current != null; current = current.next) {
				//If this place is position of item between previous and current
				if(item.compareToIgnoreCase(current.data) < 0) {
					//If we found the location and previous is null, i.e insert at the beginning
					if(previous == null) {
						SingleNode n = new SingleNode(item, head);
						head = n;
						break;
					}
					//If location is between previous and current. (BUT NOT AFTER CURRENT)
					else {
						SingleNode n = new SingleNode(item, current);
						previous.next = n;
						break;
					}
					
				}
				previous = current;
			}
			//IF the loop had to continue till current = null it means, it couldn't break and insertion was incomplete
			//We insert at the end at that condition
			if(current == null) {
				previous.next = new SingleNode(item);
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
