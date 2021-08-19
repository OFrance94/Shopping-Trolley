import java.util.Scanner;

public class Shopping {

	static Scanner custInput = new Scanner(System.in);
	static String discountItem = "";
	static float disAmount = 0;

	public static void main(String[] args) {

		System.out.println(
				"Welcome! Please begin adding items to your cart. When finished, please type \"Finish\" to move on to discounts.");
		while (true) {
			System.out.println("Please enter the name of the item you wish to add.");
			String itemName = custInput.nextLine();
			if (itemName.equals("Finish")) {
				break;
			}
			System.out.println("Please enter the price of the product in pounds and pence eg. 2.50.");
			String itemcos = custInput.nextLine();
			float itemPrice = Float.parseFloat(itemcos);
			System.out.println("Please enter the amount of the item you would like.");
			String itemnum = custInput.nextLine();
			int itemAmount = Integer.parseInt(itemnum);

			shoppingTrolley.addItem(itemName, itemPrice, itemAmount);
		}

		for (Item i : shoppingTrolley.itemList) {

			System.out.println("Item : " + i.getName() + " Price: £" + i.getPrice() + " Quantity: " + i.getQuantity());

		}

		System.out.println("Do you wish to remove any items? y/n");
		String confirm = custInput.nextLine();
		while (true) {
			if (confirm.equals("y")) {
				System.out.println("Please enter the name of the item to remove.");
				String deleter = custInput.nextLine();
				shoppingTrolley.removeItem(deleter);
				System.out.println("Do you wish to remove another item? y/n");
				String redo = custInput.nextLine();
				if (redo.equals("n")) {
					break;
				}
			}
		}
		System.out.println(
				"Please type the name of any item with a discount. If none, please leave blank and press enter.");
		String userinput = custInput.nextLine();
		if (!userinput.isEmpty()) {
			discountItem = userinput;
		}
		System.out.println("Please type the discount percent. If none, please leave blank and press enter.");
		String discInput = custInput.nextLine();
		if (!discInput.isEmpty()) {
			disAmount = Float.parseFloat(discInput);
		}
		if (!discountItem.isEmpty() && !(disAmount == 0)) {
			shoppingTrolley.saleApply(discountItem, disAmount);
		}

		for (Item i : shoppingTrolley.itemList) {

			System.out.println("Item : " + i.getName() + " Price (Discount applied if applicable): £" + i.getPrice()
					+ " Quantity: " + i.getQuantity());

		}
		System.out.println("Total price is £" + shoppingTrolley.getTotal());
	}

}
