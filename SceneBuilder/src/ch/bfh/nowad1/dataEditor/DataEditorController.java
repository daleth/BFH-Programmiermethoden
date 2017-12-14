package ch.bfh.nowad1.dataEditor;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class DataEditorController {

	@FXML
	private TextField name;
	
	@FXML
	private TextField quantity;
	
	@FXML
	private Label title;
	
	@FXML
	private TableView<Item> table;
	
	@FXML
	private TableColumn<String, String> colName;
	
	@FXML
	private TableColumn<String, String> colQuant;
	
	int i=0;
	
	@FXML
	protected void handleAdd() {
		System.out.printf("Name: %s, Quantity: %s%n", this.name.getText(), this.quantity.getText());
		model.getData().add(new Item(name.getText(), quantity.getText()));
		
		table.refresh();
		
		this.name.setText("Name " + i);
		this.quantity.setText("Quantity " + i++);
	}
		

	private DataEditorStage model;


	// Called by FXMLLoader after the node hierarchy has been created
	@FXML protected void initialize() {
	colName.setCellValueFactory(new PropertyValueFactory<>("name"));
	colQuant.setCellValueFactory(new PropertyValueFactory<>("Quantity"));
	table.refresh();
	}
	
	public void init(DataEditorStage model) {
		this.model = model;		
		this.table.setItems(model.getData());
	
	}
}

