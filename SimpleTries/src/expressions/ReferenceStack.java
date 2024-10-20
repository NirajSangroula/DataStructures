package expressions;

public class ReferenceStack {
	Node top;
	public ReferenceStack() {
		top = null;
	}
	
	public boolean isEmpty() {
		return top == null;
	}
	
	public void push(Object data) throws StackException{
		if(isEmpty()) {
			top = new Node(data);
		}
		else {
			top = new Node(data, top);
		}
	}
	
	public Object pop() throws StackException{
		if(!isEmpty()) {
			Object o = top.data;
			top = top.next;
			return o;			
		}
		else
			throw new StackException("Pop: Stack is empty");
	}
	
	public void popAll() {
		top = null;
	}
	
	public Object peek() throws StackException{
		if(!isEmpty()) 
			return top.data;
		else
			throw new StackException("Peek: Stack is empty");
	}
	
	public void print() {
		for(Node cur = top; cur != null; cur = cur.next) {
			System.out.println(cur.data);
		}
		
	}
}
