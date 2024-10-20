/**
Author: Niraj Sangroula
Student ID: 219586770
Lab 7
Any and all work in this file is my own.
*/
package lab7;

public class ListException extends RuntimeException {
	public ListException(String message) {
		super("[ListException] " + message);
	}
}
