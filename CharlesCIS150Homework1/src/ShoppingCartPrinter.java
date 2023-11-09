import java.util.Scanner;

public class ShoppingCartPrinter {
	
	public static void main(String[] args) {
		
		Scanner scnr = new Scanner(System.in);
		ItemToPurchase item1 = new ItemToPurchase();
		ItemToPurchase item2 = new ItemToPurchase();
		
		System.out.println("Item 1");
		System.out.println("Enter the item name: ");
		item1.setName(scnr.next());
		
		System.out.println("Enter the item price: ");
		item1.setPrice(scnr.nextInt());
		
		System.out.println("Enter the item quantity: ");
		item1.setQuantity(scnr.nextInt());
		
		scnr.nextLine(); //Clears out scanner
		System.out.println("");
		
		System.out.println("Item 2");
		System.out.println("Enter the item name: ");
		item2.setName(scnr.next());
		
		System.out.println("Enter the item price: ");
		item2.setPrice(scnr.nextInt());
		
		System.out.println("Enter the item quantity: ");
		item2.setQuantity(scnr.nextInt());
		
		System.out.println("TOTAL COST");
		System.out.println(item1.getName() + " " + item1.getQuantity() + " @ $"
				+ item1.getPrice() + " = $"  + (item1.getQuantity() * item1.getPrice()));
		System.out.println(item2.getName() + " " + item2.getQuantity() + " @ $"
				+ item2.getPrice() + " = $"  + (item2.getQuantity() * item2.getPrice()));
				
		//item1.printItemCost();
		//item2.printItemCost();
		/* DO NOT ADD DESCRIPTION INPUT IN THIS FILE */

	}
}
