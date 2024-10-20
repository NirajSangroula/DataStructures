package linkedlist;

import assignment4.e1.StackException;

public class Stack {
	int top;
	Object[] items;
	
	public Stack(int n) {
		items = new Object[n];
		top = -1;
	}
	
	public void push(Object o) {
		if(top < items.length - 1)
			items[++top] = o;
		else
			throw new StackException("Stack is full");
	}
	
	public Object pop() {
		if(!isEmpty()) {
			return items[top--];
		}
		else
			throw new StackException("Stack is empty");
	}

	public boolean isEmpty() {
		return top < 0;
	}
	
	public void popAll() {
		top = -1;
	}
	
	public Object peek() {
		if(!isEmpty())
			return items[top];
		else
			throw new StackException("Stack is empty");
	}
	
}
