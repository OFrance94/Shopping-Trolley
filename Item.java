
public class Item extends Shopping {
	String name;
	float price;
	int quantity;

	public Item(String itemName, float cost, int amount) {
		name = itemName;
		price = cost;
		quantity = amount;

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
