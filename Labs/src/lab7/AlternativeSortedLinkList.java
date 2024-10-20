//package lab7;
//
//public class AlternativeSortedLinkList {
//	public void insert(String item) throws ListException {
//		if(isEmpty()) {
//			SingleNode n = new SingleNode(item);
//			head = n;
//		}
////		//If the position is the first,
////		else if(item.compareToIgnoreCase(head.data) < 0) {
////			SingleNode n = new SingleNode(item, head);
////			head = n;
////		}
////		//For positions after first
////		else {
////			for(SingleNode current = head; current != null; current = current.next) {
////				if(item.compareToIgnoreCase(current.data) > 0 && (current.next == null || item.compareToIgnoreCase(current.next.data) < 0)) {
////				//If this is the exact place to be inserted, i.e item is greater than current and less than current.next
////					SingleNode n = new SingleNode(item, current.next);
////					current.next = n;
////					break;
////				}
////			}
////		}
//		else {
//			//We retain current and previous scope, so that we keep track if current had to loop till it is null
//			//It will mean that, the end of the loop had to be reached and the data wasn't still inserted
//			SingleNode current = head, previous = null;
//			//We run to insert at the first place, or between previous and current. (We still don't insert after current)
//			for(; current != null; current = current.next) {
//				//If this place is position of item between previous and current
//				if(item.compareToIgnoreCase(current.data) < 0) {
//					//If we found the location and previous is null, i.e insert at the beginning
//					if(previous == null) {
//						SingleNode n = new SingleNode(item, head);
//						head = n;
//						break;
//					}
//					//If location is between previous and current. (BUT NOT AFTER CURRENT)
//					else {
//						SingleNode n = new SingleNode(item, current);
//						previous.next = n;
//						break;
//					}
//					
//				}
//				previous = current;
//			}
//			//IF the loop had to continue till current = null it means, it couldn't break and insertion was incomplete
//			//We insert at the end at that condition
//			if(current == null) {
//				previous.next = new SingleNode(item);
//			}
//		}
//
//	}
//
//}
