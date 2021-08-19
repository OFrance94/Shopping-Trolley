import java.util.ArrayList;

public class shoppingTrolley extends Shopping {
	static ArrayList<Item> itemList = new ArrayList<Item>();
	static float totalPrice;

	public static float getTotal() {
		for (Item i : itemList) {
			totalPrice = totalPrice + (i.getPrice() * i.getQuantity());
		}
		return totalPrice;
	}

	public static void addItem(String name, float price, int quantity) {
		Item myItem = new Item(name, price, quantity);

		itemList.add(myItem);
		System.out.println(name + " Added to cart.");

	}

	public static void removeItem(String name) {
		for (Item i : itemList) {

			if (i.getName().equals(name) && i.getQuantity() > 1) {
				i.setQuantity(i.getQuantity() - 1);
				System.out.println("Quantity of " + i.getName() + " is now " +i.getQuantity() +".");
				break;
			} else if (i.getName().equals(name)) {
				itemList.remove(i);
				System.out.println("Item successfully removed.");
				break;
			}
		}
	}

	public static void saleApply(String itemName, float discountPercent) {
		float discount = discountPercent / 100;
		for (Item i : itemList) {
			if (i.getName().equals(itemName)) {
				i.setPrice(i.getPrice() * discount);
				break;
			}
		}

	}

}
