/**
Author: Niraj Sangroula
Student ID: 219586770
Lab 1
Any and all work in this file is my own.
*/
package lab1;

public class Student extends Person{
	//Data members
	private double average;
	
	//Constructor
	public Student(int id, String name) {
		super(id, name);
		average = 0;
	}
	
	//Getter and Setter methods
	public double getAverage() {
		return average;
	}

	public void setAverage(double average) {
		this.average = average;
	}

	//toString method implementation
	@Override
	public String toString() {
		return "Student[id=" + id() + ", name=" + name + ", GPA=" + average + "%]";
	}
}
