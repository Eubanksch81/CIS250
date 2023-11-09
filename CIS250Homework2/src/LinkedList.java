public class LinkedList {
	   private Node head;
	   private Node tail;
	    
	   public LinkedList() {
	      head = null;
	      tail = null;
	   }
	   public Node getHead()
	   {
		   return head;
	   }
	    
	   public void append(Node newNode) { //Add to back of list
	      if (head == null) {
	         head = newNode;
	         tail = newNode;
	      }
	      else {
	         tail.next = newNode;
	         tail = newNode;
	      }
	   }
	   
	   public void prepend(Node newNode) { //Add to front of list
	      if (head == null) {
	         head = newNode;
	         tail = newNode;
	      }
	      else {
	         newNode.next = head;
	         head = newNode;
	      }
	   }
	   
	   public void printList() {
	      Node node = head;
	      while (node != null) {
	         System.out.print(node.data + " ");
	         node = node.next;
	      }
	      System.out.println();
	   }
	   
	   public void insertAfter(Node currentNode, Node newNode) {
	      if (head == null) {
	         head = newNode;
	         tail = newNode;
	      }
	      else if (currentNode == tail) {
	         tail.next = newNode;
	         tail = newNode;
	      }
	      else {
	         newNode.next = currentNode.next;
	         currentNode.next = newNode;
	      }
	   }
	   
	   public void removeAfter(Node currentNode) {
	      if (currentNode == null && head != null) {
	         // Special case: remove head
	         Node succeedingNode = head.next;
	         head = succeedingNode;
	         if (succeedingNode == null) {
	             // Last item was removed
	             tail = null;
	         }
	      }
	      else if (currentNode.next != null) {
	         Node succeedingNode = currentNode.next.next;
	         currentNode.next = succeedingNode;
	         if (succeedingNode == null) {
	            // Remove tail
	            tail = currentNode;
	         }
	      }
	   }
	   
   	public void reverse() {
   		if (head == null) { //meaning if this is called on an empty list
   		   return; //Don't do anything
   		}
   		
   		//int listSize = 1; Use later
   		Node oldTail = tail; //Keeps the pointer to the old tail as it moves throughout the list
   		System.out.println(oldTail.data);
   		//In the case of list3, the tail is 8. In the case of list4, the tail is 16.
   		
   		while (oldTail != head) { //Keeps iterating between 0 and 2. Why?
   	      insertAfter(oldTail, head); //Adds head after the old tail
   	      removeAfter(null); //Removes the old head
   	      //++listSize; //Gets the size of the list for copying back to original list later
   		}
   		//0 2 4 6 8 Head added after 8, and removed.
   		//2 4 6 8 0
   		//4 6 8 2 0
   		//6 8 4 2 0
   		//8 6 4 2 0 The old tail is now the head, which terminates the loop.
   		//printList(); //For testing
   	}
	
}

	