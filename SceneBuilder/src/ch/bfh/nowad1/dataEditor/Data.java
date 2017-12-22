package ch.bfh.nowad1.dataEditor;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Data {
	private StringProperty name; 
	private IntegerProperty quantity; 
	
	public Data (String name, int quantity) {
		this.name = new SimpleStringProperty(name);
		this.quantity = new SimpleIntegerProperty(quantity);
	}

	public String getName() {
		return this.name.get();
	}

	public void setName(String name) {
		this.name.set(name);
	}
	
	public StringProperty nameProperty() {
		return this.name;
	}

	public int getQuantity() {
		return this.quantity.get();
	}

	public void setQuantity(int q) {
		this.quantity.set(q);
	}
	
	public IntegerProperty quantityProperty() {
		return this.quantity;
	}
}
