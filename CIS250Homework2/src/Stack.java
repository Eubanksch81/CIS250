import java.util.ArrayList;

public class Stack {
	private LinkedList2 linkedList2;
	
	Stack() {
		linkedList2 = new LinkedList2();
	}
	
	public void push(int newData) {
		// Create a new node and prepend
		Node newNode = new Node(newData);
		linkedList2.prepend(newNode);
	}

	
	public int pop() {
		// Copy list head's data
		int poppedItem = linkedList2.getHeadData();
		
		// Remove list head
		linkedList2.removeAfter(null);
		
		// Return popped item
		return poppedItem;
	}
	
	public int peek() { //Added this to get the top of the stack without deleting it
	   // Copy list head's data
		int poppedItem = linkedList2.getHeadData();
		
		// Return popped item
		return poppedItem;
	}
	
	public void print() {
		linkedList2.printList();
	}
	
	public boolean isStackEmpty() {
	   if (linkedList2.getSize() == 0) {
	      return true;
	   }
	   
	   return false;
	}
	
	// Sort() method sorts the stack in descending order using recursion:
	public void sort() {		
	   int topVal;
	   if (isStackEmpty()) {
	      return;
	   }
	   else {
	      topVal = pop();
	      sort();
	      placeValues(topVal);
	      print();
	   }
	}
	private void placeValues(int value) {
	   
	   if (isStackEmpty()) {
	      push(value); //This just places the stack back the same way, for now.
	   }
	   else if (value > peek()) {
	      push(value);
	   }
	   else {
		   ArrayList<Node> tempStackList = new ArrayList<>();
		      
		   while (!isStackEmpty() && value < peek()) {
			   Node tempNode = new Node(pop());
		       tempStackList.add(tempNode);
		   }
		   push(value); //Once this point is reached, value >= peek. 
		         
		   for (int i = tempStackList.size() - 1; i >= 0; --i) { 
		        //i starts as the length of the stack in the array, goes to beginning of array
		        push(tempStackList.get(i).data);
		   }
	  }
	}
}
