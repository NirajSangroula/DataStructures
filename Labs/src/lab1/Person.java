/**
Author: Niraj Sangroula
Student ID: 219586770
Lab 1
Any and all work in this file is my own.
*/
package lab1;

public class Person {
	//Data members
	private int id;
	protected String name;
	
	//Constructor
	public Person(int id, String name) {
		this.id = id;
		this.name = name;
	}
	
	//Getter and Setter methods
	public int id() {
		return id;
	}
	
	public String name() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	//toString method implementation
	@Override
	public String toString() {
		return "Person[id=" + id + ", name=" + name + "]";
	}
}
