import java.util.Scanner;

public class ShoppingCartManager {
	
	public void printMenu() {
		System.out.println("\nMENU");
		System.out.println("a - Add item to cart");
		System.out.println("d - Remove item from cart");
		System.out.println("c - Change item quantity");
		System.out.println("i - Output items' descriptions");
		System.out.println("o - Output shopping cart");
		System.out.println("q- Quit");
	}
	
	public void executeMenu(Scanner scnr, ShoppingCart cart, char managerChoice) {
		if (managerChoice == 'a') { //add item
			scnr.nextLine(); //clears out scanner
			System.out.println("ADD ITEM TO CART"); 
			
			System.out.println("Enter the item name: ");
			String itemName = scnr.nextLine();
			System.out.println("Enter the item description: ");
			String itemDescription = scnr.nextLine();
			System.out.println("Enter the item price: ");
			int itemPrice = scnr.nextInt();
			System.out.println("Enter the item quantity: ");
			int itemQuantity = scnr.nextInt();
			
			ItemToPurchase item = new ItemToPurchase(itemName, itemDescription, itemPrice, itemQuantity);
			cart.addItem(item);
		} // adding objects works
		
		else if (managerChoice == 'd') { //remove item
			scnr.nextLine(); //Clears out scanner
			System.out.println("REMOVE ITEM FROM CART"); 
			
			System.out.println("Enter name of item to remove: "); 
			String itemName = scnr.nextLine();
			
			cart.removeItem(itemName);
		} //removing objects works
		
		else if (managerChoice == 'c') { //change quantity
			scnr.nextLine(); //Clears out scanner
			System.out.println("CHANGE ITEM QUANTITY"); 
			
			System.out.println("Enter the item name: ");
			String itemName = scnr.nextLine();
			System.out.println("Enter new item quantity: "); 
			int itemQuantity = scnr.nextInt();
			
			ItemToPurchase newItem = new ItemToPurchase(itemName,"none", 0, itemQuantity);
			cart.modifyItem(newItem);	
		} //modifying quantities works
		
		else if (managerChoice == 'i') { //output item description
			System.out.println("OUTPUT ITEMS' DESCRIPTIONS");
			cart.printDescription();
		} //Printing descriptions works
		
		else if (managerChoice == 'o') { //output shopping cart
			System.out.println("OUTPUT SHOPPING CART");
			cart.printTotal();
		} //Printing totals works
	}
	
	public static void main(String[] args) {
		String name;
		String date;
		char managerChoice;
		Scanner scnr = new Scanner(System.in);
		ShoppingCartManager manager = new ShoppingCartManager();
		
		System.out.println("Enter customer's name:");
		name = scnr.nextLine();
		System.out.println("Enter today's date: ");
		date = scnr.nextLine();
		
		ShoppingCart cart = new ShoppingCart(name, date);
		
		System.out.println("\nCustomer name: " + cart.getcustomerName());
		System.out.println("Today's date: " + cart.getDate());
		
		manager.printMenu();
		System.out.println("\nChoose an option: ");
		managerChoice = scnr.next().charAt(0);
		
		while (managerChoice != 'q') {
			if (managerChoice != 'a' && managerChoice != 'd' && managerChoice != 'c'
				&& managerChoice != 'i' && managerChoice != 'o') { //If not proper input
					
					managerChoice = scnr.next().charAt(0); //get new input
			}
			else {
				manager.executeMenu(scnr, cart, managerChoice); //Execute input
				manager.printMenu();
				System.out.println("\nChoose an option: ");
				managerChoice = scnr.next().charAt(0);
			}
		}
	}
	
}
