package ch.bfh.nowad1.dataEditor;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class DataEditorController {

	@FXML
	private TextField name;
	
	@FXML
	private TextField quantity;
	
	@FXML
	private Label title;
	
	@FXML
	protected void handleAdd() {
		System.out.printf("Name: %s, Quantity: %s%n", this.name.getText(), this.quantity.getText());
		this.name.setText("Name");
		this.quantity.setText("Quantity");
	}
}
