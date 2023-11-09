
import java.util.Random;

public class StackSortTest {
	
	public static void main(String[] args) {
		
		// Sort on 10 numbers
		Stack numStack = new Stack();
		int size = 10;
		int[] numbers = {10, 30, 50, 70, 90, 0, 20, 40, 60, 80};
		for (int number : numbers) {
			numStack.push(number);
		}
		
		System.out.print("Stack of 10 unique numbers pre sort: ");
		numStack.print();
		
		numStack.sort();
		System.out.print("Stack of 10 unique numbers post sort: ");
		numStack.print();
		System.out.println();
		
		
		//Test sort on stack of size 1
		numStack = new Stack();
		numStack.push(100);
		
		System.out.print("Stack of 1 number pre sort: ");
		numStack.print();
		
		numStack.sort();
		System.out.print("Stack of 1 number post sort: ");
		numStack.print();
		System.out.println();
		
		
		// Test on empty stack
		numStack = new Stack();
		
		System.out.print("Empty stack pre sort: ");
		numStack.print();
		
		numStack.sort();
		System.out.print("Empty stack post sort: ");
		numStack.print();
		System.out.println();
		
		
	}
}
