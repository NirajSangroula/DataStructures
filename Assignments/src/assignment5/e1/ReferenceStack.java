package assignment5.e1;

public class ReferenceStack<T> {
	Node<T> top;
	public ReferenceStack() {
		top = null;
	}
	
	public boolean isEmpty() {
		return top == null;
	}
	
	public void push(T data) throws StackException{
		if(isEmpty()) {
			top = new Node<T>(data);
		}
		else {
			top = new Node<T>(data, top);
		}
	}
	
	public T pop() throws StackException{
		if(!isEmpty()) {
			T o = top.data;
			top = top.next;
			return o;			
		}
		else
			throw new StackException("Pop: Stack is empty");
	}
	
	public void popAll() {
		top = null;
	}
	
	public T peek() throws StackException{
		if(!isEmpty()) 
			return top.data;
		else
			throw new StackException("Peek: Stack is empty");
	}
	
	public String toString() {
		String ret = "";
		for(Node cur = top; cur != null; cur = cur.next)
			ret += " " + cur.data;
		return ret;
	}
}
