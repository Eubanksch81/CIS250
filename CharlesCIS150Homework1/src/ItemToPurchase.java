
public class ItemToPurchase {
	private String itemName;
	private String itemDescription;
	private int itemPrice;
	private int itemQuantity;
	
	public ItemToPurchase() {
		itemName = "none";
		itemDescription = "none";
		itemPrice = 0;
		itemQuantity = 0;
	} 
	
	public ItemToPurchase(String name, String desc, int price, int quantity) {
		itemName = name;
		itemDescription = desc;
		itemPrice = price;
		itemQuantity = quantity;
	}
	
	public void setName(String name) {
		itemName = name;
	}
	public String getName() {
		return itemName;
	}
	
	public void setPrice(int price) {
		itemPrice = price;
	}
	public int getPrice() {
		return itemPrice;
	}
	
	public void setQuantity(int quantity) {
		itemQuantity = quantity;
	}
	public int getQuantity() {
		return itemQuantity;
	}
	public void setDescription(String description) {
		itemDescription = description;
	}
	public String getDescription() {
		return itemDescription;
	}
	public void printItemCost() {
		System.out.println(itemName + " " + itemQuantity + " @ $"
				+ itemPrice + " = $"  + (itemQuantity * itemPrice));
	}
	public void printItemDescription() {
		System.out.println(itemName + ": " + itemDescription);
	}
}
