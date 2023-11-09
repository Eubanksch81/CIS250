public class ReverseTest {
	public static void main(String[] args) {
	
	   // size 0
      /*LinkedList list1 = new LinkedList();
    
		list1.printList();
		
		list1.reverse();
		
		list1.printList();


      //size 1
      LinkedList list2 = new LinkedList();
  
		list2.append(new Node(100));
	
		list2.printList();
		
		list2.reverse();
		
		list2.printList(); */


      //size 5
      LinkedList list3 = new LinkedList();
    
		for (int i = 0; i < 10; i+=2) {
			list3.append(new Node(i));
		}
		
		list3.printList();
		
		list3.reverse();
		
		list3.printList();


      //size 10

      LinkedList list4 = new LinkedList();
    
		for (int i = 0; i < 20; i+=2) {
			list4.append(new Node(i));
		}
		
		list4.printList();
		
		list4.reverse();
		
		list4.printList();

	}

}
