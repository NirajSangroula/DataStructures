package queue;

public class ArrayQueue<T> {
	// 0, 1, 2, 3
	// Front means, position which contains first element
	// Rear means, position which contains the last element (need to + 1 to insert)
	// Last element is intended so we can insert, so important that's why we assume
	// it starts at -1
	// Front one is not significant because its objective is simply to be taken out and incremented
	// So we assume it starts at 0 (It simply means for now, you can take first element)
	// At other times, after taking few of them, some other index will be front, that I will tell you ok
	
	// FRONT ----> Which can I take out to read ? -- For now
	// REAR -----> Which position is the last element has right now... ( Useful to insert)
	
	int front, rear;
	Object[] array;
	int n;
	boolean empty; // Flag that represents if stack is empty or not empty (To distinguish between
	//Ambiguous situation, of front = 0, back = 4 (0, 1, 2, 3, 4) --> Can mean filled, or (empty-- coz
	//Empty --> Means, Back is just one step ahead of front... i.e   (back = 1, front = 2) --
	// But round about way, it also means, its 2, 3, 4, 0, 1 (Containing ) So flag
	public ArrayQueue(int n) {
		this.n = n;
		array = new Object[n];
		front = 0;
		rear = n - 1; // Because -1 is equal to that index, n - 1
		empty = true;
	}
	
	public boolean isEmpty() {
		return empty; // We take care of this in deletion behavious
	}
	
	public void enqueue(Object o) {
		// 0 4 (4 + 1 )%5) = 0 , equals front  1 0 (1 % 5 = 1) equals front... So, 
		if(!empty && (modOperationN(rear + 1) == front))
			throw new RuntimeException("Queue full");
		else {
			empty = false;
			rear = modOperationN(rear + 1);
			array[rear] = o;
		}
	}

	public Object dequeue() {
		if(empty)
			throw new RuntimeException("Queue empty");
		else {
			

			Object ret = array[front];
			front = modOperationN(front + 1);
			// 0, 1 --> 1 --> (front and rear are 1 ) has 1 element
			// delete once, then, rear = 0 (COZ next insert item is, 1) (as front is 1)
			// 0 + 1 = 1 is this case, after deletion ok.
			if(modOperationN(rear + 1) == front)
				empty = true;
			return ret;
		}
	}
	public void display() {
		if(empty)
			return;
		int i = front;
		do {
			if(array[i] instanceof String)
				System.out.println(((String)array[i]));
			i = modOperationN(i + 1);
		}
		while(i != modOperationN(rear + 1));
		//Initially, when it is equal to front, we print
		// But later, it will equal to rear + 1, then, we need to end the stupid loop
		
	}
	private int modOperationN(int v) {
		return v % n;
	}
	
	
	
}
