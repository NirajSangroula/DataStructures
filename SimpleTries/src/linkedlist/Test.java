package linkedlist;

public class Test {

	public static void main(String[] args) {
		LinkedList l1 = new LinkedList();
		l1.insert(3);
		l1.insert(4);
		l1.insert(374);
		l1.insertAfter(4, 100);
		l1.display();
		l1.displayRecursively(l1.head);
	}

}
