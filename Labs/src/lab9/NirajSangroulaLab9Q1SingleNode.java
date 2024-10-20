/**
Author: Niraj Sangroula
Student ID: 219586770
Lab 9
Any and all work in this file is my own.
*/
package lab9;

public class NirajSangroulaLab9Q1SingleNode {
	protected String data;
	protected NirajSangroulaLab9Q1SingleNode next;
	
	public NirajSangroulaLab9Q1SingleNode(String data) {
		this.data = data;
		next = null;
	}
	
	public NirajSangroulaLab9Q1SingleNode(String data, NirajSangroulaLab9Q1SingleNode next) {
		this(data);
		this.next = next;
	}
}
