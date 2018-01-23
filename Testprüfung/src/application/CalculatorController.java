package application;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class CalculatorController {
	Calculator calc = new Calculator();

	private ObservableList<String> data;
	
	@FXML
	TextField txtOperand1, txtOperand2;

	@FXML
	Label lblOperator, lblResult;

	@FXML
	ListView<String> listViewHistory;

	@FXML
	public void handleAdd() {
		int result = calc.add(Integer.parseInt(txtOperand1.getText()), 
				 Integer.parseInt(txtOperand2.getText()));
		this.lblOperator.setText("+");
		this.lblResult.setText("" + result);
		this.updateListView();
	}

	@FXML
	public void handleSubtract() {
		int result = calc.subtract(Integer.parseInt(txtOperand1.getText()), 
				Integer.parseInt(txtOperand2.getText()));
		this.lblOperator.setText("-");
		this.lblResult.setText("" + result);
		this.updateListView();

	}

	@FXML
	public void handleMultiply() {
		int result = calc.multiply(Integer.parseInt(txtOperand1.getText()), 
				Integer.parseInt(txtOperand2.getText()));
		this.lblOperator.setText("*");
		this.lblResult.setText("" + result);
		this.updateListView();

	}

	@FXML
	public void handleDivide() {
		int result;
		try {
			result = calc.divide(Integer.parseInt(txtOperand1.getText()), 
					Integer.parseInt(txtOperand2.getText()));
			this.lblOperator.setText("/");
			this.lblResult.setText("" + result);
		} catch (DivisionByZeroException e) {
			lblResult.setText("NaN");
			System.err.println("Division by Zero not allowed");
			}
		this.updateListView();

	}
	

	public void init() {
		data = FXCollections.observableArrayList(); 
		txtOperand1.setText("0");
		txtOperand2.setText("0");
		for (String h : calc.getHistory()) {
			this.data.add(h);
		}
		listViewHistory.setUserData(data);
		updateListView();
	}
	
	private void updateListView() {
		listViewHistory.getItems().clear();
		for (String s : this.calc.getHistory()) {
			listViewHistory.getItems().add(s); 
		}
	}
}