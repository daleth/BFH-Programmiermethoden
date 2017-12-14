package ch.bfh.nowad1.dataEditor;

public class Item {
	private String name; 
	private String quantity; 
	
	public Item (String name, String quantity) {
		this.setName(name);
		this.setQuantity(quantity); 
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	
	
}
