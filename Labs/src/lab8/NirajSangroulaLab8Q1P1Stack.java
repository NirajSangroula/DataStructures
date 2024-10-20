/**
Author: Niraj Sangroula
Student ID: 219586770
Lab 8 P1
Any and all work in this file is my own.
*/
package lab8;

public class NirajSangroulaLab8Q1P1Stack {
	private int top;
	private char[] array;
	
	public NirajSangroulaLab8Q1P1Stack(int size) throws NirajSangroulaLab8Q1StackException{
		if(!(size > 0))
			throw new NirajSangroulaLab8Q1StackException("Invalid size: Size of array must be greater than 0");
		array = new char[size];
		top = 0;
	}
	
	public boolean isEmpty() {
		return top < 1;
	}
	
	public void push(char c) throws NirajSangroulaLab8Q1StackException {
		//If no of elements in stack (top) is already filled
		if(top >= array.length) {
			throw new NirajSangroulaLab8Q1StackException("Stack Overflow: Stack is full");
		}
		//Set the value and increase the top
		array[top++] = c;
	}
	
	public char pop() throws NirajSangroulaLab8Q1StackException {
		if(isEmpty())
			throw new NirajSangroulaLab8Q1StackException("Stack Underflow: Stack is empty");
		char ret = peek();
		top--;
		return ret;
	}

	public char peek() throws NirajSangroulaLab8Q1StackException {
		if(isEmpty())
			throw new NirajSangroulaLab8Q1StackException("Stack Underflow: Stack is empty");
		return array[top - 1];
	}
	
	public void popAll() {
		top = 0;
	}
}
