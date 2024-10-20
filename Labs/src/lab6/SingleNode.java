/**
Author: Niraj Sangroula
Student ID: 219586770
Lab 6
Any and all work in this file is my own.
*/
package lab6;

public class SingleNode {
	protected String data;
	protected SingleNode next;
	
	public SingleNode(String data) {
		this.data = data;
		next = null;
	}
	
	public SingleNode(String data, SingleNode next) {
		this(data);
		this.next = next;
	}
}
