package assignment3.e1;

public class TestLinkedList {

	public static void main(String[] args) {
		LinkedList l1 = new LinkedList();
		
		l1.insertBeginning(4);
		System.out.println("Inserting 4");
		l1.displayRecursive(l1.head);
		//Insert 2 data and display
		l1.insertBeginning(20);
		l1.insertBeginning(30);
		System.out.println("After inserting 2 data at the beginning");
		l1.displayRecursive(l1.head);
		//Insert end
		l1.insertEnd2(88);
		l1.insertEnd2(89);
		System.out.println("After insert end");
		l1.displayRecursive(l1.head);
		//Delete beginning and display
		System.out.println("Delete beginning 2 times");
		l1.deleteBeginning();
		l1.deleteBeginning();
		l1.displayRecursive(l1.head);
		//Delete end and display
		System.out.println("Delete end 2 times");
		l1.deleteEnd2();
		l1.deleteEnd2();
		l1.displayRecursive(l1.head);		
		
	}

}
