/**
 * Assignment 5
 * Name: Niraj Sangroula
 * Course: COSC 2007T
 * Student No: 219886770
 * email: nsangroula@algomau.ca
 */
package Lab5;

import assignment3.KeyedItem;

public class Student extends KeyedItem<String> {
	private String name;
	private String degree;
	private int age;
	public Student(String studentID, String name, String degree, int age) {
		super(studentID);
		this.name = name;
		this.degree = degree;
		this.age = age;
	}
	
	public String toString() {
		return this.getKey() + " - " + name + " - " + age + " years old " + " - " + degree + " degree " ;
	}
}
