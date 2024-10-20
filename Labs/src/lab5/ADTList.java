/**
Author: Niraj Sangroula
Student ID: 219586770
Lab 5
Any and all work in this file is my own.
*/
package lab5;

public class ADTList {
	int size;
	int length;
	String[] array;
	public ADTList(int length) {
		//Initialize length, size and allocate size for array
		this.length = length;
		size = 0;
		array = new String[length];
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public int size() {
		return size;
	}
	
	public void add(String item, int index) throws ListException{
		if(length == size) { // Check if room is available
			throw new ListException("Invalid Operation: Array is full");
		}
		if(index < 0 || index > size) { // Check for valid index
			throw new ListException("Invalid index: index " + index + " isn't between 0 and " + (size));
		}
		if(index == size) { //Check if we are inserting at last -- We won't need to shift at this condition
			array[index] = item;
			size++;
		}
		else {
			/*  
			 *  Use loop to actually shift contents right,
			 *  
			 *  add the element at the vacant position in an array
			 *  increase the size
			 */
			for(int i = size; i > index; i--) {
				array[i] = array[i - 1];
			}
			size++;
			array[index] = item;
		}
	}
	
	public String remove(int index) {
		if(index < 0 || index >= size) { //Check for invalid index
			throw new ListException("Invalid argument: Item doesn't exist at the specified index");
		}
		String s = array[index];
		if(index == size - 1) { // No need to shift if we remove the last item
			array[index] = null;
			//Decrease the size
			size--;
		}
		else {
				//Shift entire contents to left
				for(int i = index; i < size - 1; i++) {
					array[i] = array[i + 1];
				}
				//Set the last content null
				array[size - 1] = null;
				//Decrease the size
				size--;
		}
		return s;
	}
	
	public void removeAll() {
		//Simply remove all and set size 0
		for(int i = 0; i < size; i++) {
			array[i] = null;
		}
		size = 0;
	}
	
	public String get(int index) {
		return array[index];
	}
	
	public int find(String item) {
		//Search sequentially and return index if found
		for(int i = 0; i < size; i++) {
			if(item.equals(array[i]))
				return i;
		}
		return -1;
	}
	
	public String toString() {
		if(isEmpty())
			return "";
		else { // For one or more contents
			String s = array[0];
			for(int i = 1; i < size; i++) {
				s += (", " + array[i]);
			}
			return s;
		}
	}
}
