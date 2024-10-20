/**
Author: Niraj Sangroula
Student ID: 219586770
Lab 9
Any and all work in this file is my own.
*/
package lab9;

public class NirajSangroulaLab9Q1Queue {
	NirajSangroulaLab9Q1SingleLinkedList front;
	
	public NirajSangroulaLab9Q1Queue() {
		front = new NirajSangroulaLab9Q1SingleLinkedList();
	}
	
	public boolean isEmpty() {
		return front.isEmpty();
	}
	
	public void enqueue(String item) {
		try {
			front.add(item, front.size());
		} catch (NirajSangroulaLab9Q1ListException e) {
			System.out.println("Queue Exception: Cannot enqueue");
		}
	}
	
	public String dequeue() throws NirajSangroulaLab9Q1QueueException {
		try {
			return front.remove(0);
		} catch (NirajSangroulaLab9Q1ListException e) {
			throw new NirajSangroulaLab9Q1QueueException("Queue Exception: Cannot dequeue");
		}
	}
	
	public void dequeueAll() {
		front.removeAll();
	}
	
	public String peek() throws NirajSangroulaLab9Q1QueueException {
		try {
			return front.get(0);
		} catch (NirajSangroulaLab9Q1ListException e) {
			throw new NirajSangroulaLab9Q1QueueException("Queue Exception: Cannot get item from queue");
		}
	}
	
	public int size() {
		return front.size();
	}
	
	public String toString() {
		//We cannot throw exception in this method, so we must return message
		// We are forced to handle exception here by returning string, as
		//Linkedlist.get method throws exception
			try {
				String ret = "";
				for(int i = 0; i < size(); i++) {
				ret += front.get(i);
				//Add comma if it isn't the last element
				if(i < size() - 1)
					ret += ", ";
				}
				return ret;
			} catch (NirajSangroulaLab9Q1ListException e) {
				return "Unexpected error while reading data from queue";
			}
	}
}
