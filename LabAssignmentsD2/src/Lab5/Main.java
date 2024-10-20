/**
 * Assignment 5
 * Name: Niraj Sangroula
 * Course: COSC 2007T
 * Student No: 219886770
 * email: nsangroula@algomau.ca
 */
package Lab5;

import assignment3.TableArrayBased;
import assignment3.TableReferenceBased;

public class Main {

	public static void main(String[] args) {
		Student me = new Student("219586770", "Niraj", "BCOSC", 18);
		Student s1 = new Student("435465", "Akash", "Diploma CS", 30);
		Student s2 = new Student("65456", "Dipan", "PG CS", 23);
		Student s3 = new Student("665543", "Peter", "BCOSC 3 CS", 24);
		Student s4 = new Student("431665", "Mark", "Management", 19);
		
		TableArrayBased<Student, String> tab = new TableArrayBased<>();
		tab.tableInsert(s1);
		tab.tableInsert(s3);
		tab.tableInsert(s4);
		System.out.println("Current table: ");
		tab.displayAll();
		
		TableReferenceBased<Student, String> tab1 = new TableReferenceBased<>();
		tab1.tableInsert(me);
		tab1.tableInsert(s2);
		tab1.tableInsert(s4);
		tab1.tableInsert(s3);
		
		System.out.println("Current table: ");
		tab1.displayAll();
	}

}
