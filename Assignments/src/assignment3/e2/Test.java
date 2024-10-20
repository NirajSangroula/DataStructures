package assignment3.e2;

public class Test {

	public static void main(String[] args) {
		ADTLinkedList list = new ADTLinkedList();
		try {
			list.insert(0, 20); //Inserting several items
			list.insert(0, 10);
			list.insert(2, 30);
			list.insert(2, 25);
			list.insert(4, 40);
			list.insert(5, 45);
			list.insert(6, 80);
			list.displayRecursive(list.head); //Displaying all
			System.out.println();
			
			System.out.println(removeRandom(list)+ " Removed \n"); // Remove and display random (using removeRandom)
			list.displayRecursive(list.head);
			System.out.println();
			
			System.out.println(removeRandomRefBased(list)+ " Removed \n");// Remove and display random (using referenced based random method)
			list.displayRecursive(list.head);
			System.out.println();
			
			System.out.println(removeRandomArrayBased(list)+ " Removed \n");// Remove and display random (using Array based random method)
			list.displayRecursive(list.head);
			
			System.out.println("\nRemoving item at 2 "); // Test remove method of list
			list.remove(2);
			list.displayRecursive(list.head);
			
			System.out.println("\nLength is " + list.getLength()); // Display length using method
			System.out.println("\nList is empty? : " + list.isEmpty()); // check isEmpty method
			
			System.out.println("\nRemoving all"); // Remove all items
			list.removeAll();
			
			System.out.println("\nList is empty? : " + list.isEmpty()); // isEmpty check
		} catch (ListException e) {
			System.out.println(e.getMessage());
		}

	}
/**
 * Question a
 * Uses only ADT based operations 
 * @param list
 * @return
 * @throws ListException
 */

	public static Object removeRandom(ADTLinkedList list) throws ListException {
		int randomIndex = (int)(Math.random() * list.getLength());
		Object remove = list.get(randomIndex);
		list.remove(randomIndex);
		return remove;
	}

	/**
	 * 
	 * Question b Assumes and uses reference based implementation
	 * @param list
	 * @return
	 * @throws ListException
	 */
	public static Object removeRandomRefBased(ADTLinkedList list) throws ListException {
		if(list.isEmpty())
			return null;
		int randomIndex = (int)(Math.random() * list.getLength());
		int index = 0;
		if(randomIndex == 0) {
			Object remove = list.head.data;
			list.head = list.head.next;
			return remove;
		}
		else
			for(ADTLinkedList.Node current = list.head; current != null; current = current.next, index++) {
				if(index + 1 == randomIndex) {
					Object remove = current.next.data;
					current.next = current.next.next;
					return remove;
				}
			}
		return null;
	}

/**
 * Question c
 * Assuming list has Array based implementation 
 * @param list
 * @return
 * @throws ListException
 */

	public static Object removeRandomArrayBased(ADTLinkedList list) throws ListException {
		int randomIndex = (int)(Math.random() * list.getLength());
		int size = list.getLength();
		Object remove = list.get(randomIndex);
		//Shift entire contents starting from the item to be removed to the left
		for(int i = randomIndex; i < size - 1; i++) {
			list.replace(i, list.get(i + 1));
		}
		list.remove(list.getLength() - 1); // Remove the last item in the list
		return remove;
	}
	
}

