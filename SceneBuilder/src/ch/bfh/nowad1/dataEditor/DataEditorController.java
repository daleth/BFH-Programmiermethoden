package ch.bfh.nowad1.dataEditor;

import java.util.HashMap;
import java.util.Observable;
import java.util.Observer;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.converter.IntegerStringConverter;

public class DataEditorController implements Observer {

	private Model model;
	
	private ObservableList<Data> data;
	
	@FXML
	private TableView<Data> table;

	@FXML
	private TextField name, quantity;

	@FXML
	private Label title;

	@FXML
	private TableColumn<Data, String> colName;

	@FXML
	private TableColumn<Data, Integer> colQuant;

	@FXML
	protected void handleAdd() {
		System.out.printf("Name: %s, Quantity: %s%n", this.name.getText(), this.quantity.getText());
		model.setQuantity(name.getText(), Integer.parseInt(quantity.getText()));
//		 this.name.setText("");
//		 this.quantity.setText("0");
	}

	// Called by FXMLLoader after the node hierarchy has been created
	@FXML
	protected void initialize() {
		colName.setCellValueFactory(new PropertyValueFactory<>("name"));
		colQuant.setCellValueFactory(new PropertyValueFactory<>("quantity"));
		table.setEditable(true);

	}

	public void init(Model model) {
		this.model = model;
		this.data = table.getItems();
		for (String name : this.model.getNames()) {
			Data d = new Data(name, this.model.getQuantity(name));
			this.data.add(d);
		}
		
		// make the Quantity-column editable
		colQuant.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
		
		// Update the model on edit
		colQuant.setOnEditCommit((CellEditEvent<Data,Integer> t) -> {
			this.model.setQuantity(t.getRowValue().getName(), t.getNewValue());
		});
		
		this.model.addObserver(this);
	}

	@Override
	public void update(Observable o, Object arg) {
		@SuppressWarnings("unchecked")
		HashMap.Entry<String, Integer> entry = (HashMap.Entry<String, Integer>) arg;
		boolean isNew = true;
		for (Data d : this.data) {
			if (d.getName().equals(entry.getKey())) {
				d.setQuantity(entry.getValue());
				isNew = false;
				break;
			}
		}
		if (isNew) {
			this.data.add(new Data(entry.getKey(), entry.getValue()));
		}
	}
}
