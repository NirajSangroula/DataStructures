/**
Author: Niraj Sangroula
Student ID: 219586770
Lab 1
Any and all work in this file is my own.
*/
package lab1;

public class Instructor extends Person {
	//Data members
	private String department;
	
	//constructor
	public Instructor(int id, String name, String department) {
		super(id, name);
		this.department = department;
	}
	
	//getter and setters

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	//toString method implementation
	@Override
	public String toString() {
		return "Instructor[id=" + id() + ", name=" + name + ", department=" + department + "]";
	}
	
}
