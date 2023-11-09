import java.util.ArrayList;

public class ShoppingCart {
	private String customerName;
	private String currentDate;
	private ArrayList<ItemToPurchase> cartItems = new ArrayList<ItemToPurchase>();
	
	public ShoppingCart() {
		customerName = "none";
		currentDate = "January 1, 2016";
	}
	
	public ShoppingCart(String name, String date) {
		customerName = name;
		currentDate = date;
	}
	
	public String getcustomerName() {
		return customerName;
	}
	
	public String getDate() {
		return currentDate;
	}
	
	public void addItem(ItemToPurchase Item) { //adds item to cart
		cartItems.add(Item);
	}
	
	public void removeItem(String itemName) { //Find's name of item, and removes that item from cart.
		boolean itemRemoved = false;
		for (int i = 0; i < cartItems.size(); ++i) {
			if (itemName.equals(cartItems.get(i).getName())) {
				cartItems.remove(i);
				itemRemoved = true;
			}
		}
		if (itemRemoved == false) {
			System.out.println("Item not found in cart. Nothing removed.");
		}
		
	}
	
	public void modifyItem(ItemToPurchase item) { //Changes price, quantity, and description
		boolean isMatch = false;
		for (int i = 0; i < cartItems.size(); ++i) {
			if (item.getName().equals(cartItems.get(i).getName())) { //If item's name = cartItems item's name
				isMatch = true;
				if (item.getQuantity() != 0) { //If item's quantity isn't default
					cartItems.get(i).setQuantity(item.getQuantity());
				}
				if (item.getPrice() != 0) { //If item's price isn't default
					cartItems.get(i).setPrice(item.getPrice());
				}
				if (!item.getDescription().equals("none")) { //If item's description isn't default
					cartItems.get(i).setDescription(item.getDescription());
				}
			}
		}
		if (isMatch == false) {
			System.out.println("Item not found in cart. Nothing modified.");
		}
	}
	
	public int getNumItemsInCart() {
		int numItems = 0;
		for (int i = 0; i < cartItems.size(); ++i) {
			numItems += cartItems.get(i).getQuantity();
		}
		return numItems;
	}
	
	public int getCostOfCart() {
		int totalCost = 0;
		for (int i = 0; i < cartItems.size(); ++i) {
			totalCost += cartItems.get(i).getPrice();
		}
		return totalCost;
	}
	
	public void printTotal() {
		int totalCost = 0;
		if (cartItems.size() == 0) {
			System.out.println("SHOPPING CART IS EMPTY");
		}
		else {
			System.out.println(customerName + "'s Shopping Cart - " + currentDate);
			System.out.println("Number of Items: " + getNumItemsInCart() + "\n");
			for (int i = 0; i < cartItems.size(); ++i) {
				System.out.println(cartItems.get(i).getName() + " " + cartItems.get(i).getQuantity() + " @ $"
						+ cartItems.get(i).getPrice() + " = $" + 
						(cartItems.get(i).getQuantity() * cartItems.get(i).getPrice()));
				
				totalCost += (cartItems.get(i).getQuantity() * cartItems.get(i).getPrice());
				
			}
			System.out.println("\nTotal: $" + totalCost);
		}
	}
	
	public void printDescription() {
		if (cartItems.size() == 0) {
			System.out.println("SHOPPING CART IS EMPTY");
		}
		else {
			System.out.println(customerName + "'s Shopping Cart - " + currentDate);
			System.out.println("\nItem Descriptions");
			for (int i = 0; i < cartItems.size(); ++i) {
				System.out.println(cartItems.get(i).getName() + ": " + cartItems.get(i).getDescription());
			}
		}
	}

}
