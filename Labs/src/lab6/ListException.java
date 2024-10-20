/**
Author: Niraj Sangroula
Student ID: 219586770
Lab 6
Any and all work in this file is my own.
*/
package lab6;

public class ListException extends RuntimeException {
	public ListException(String message) {
		super("[ListException] " + message);
	}
}
