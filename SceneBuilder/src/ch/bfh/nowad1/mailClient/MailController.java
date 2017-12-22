package ch.bfh.nowad1.mailClient;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class MailController {
	@FXML
	private ProgressIndicator progressIndicator;

	@FXML
	private Button sendButton;

	@FXML
	private TextField to;

	@FXML
	private TextField from;

	@FXML
	private TextField subject;
	
	@FXML
	private TextArea message;
	
	@FXML 
	protected void handleSend(ActionEvent event) {
		System.out.println("Send clicked...");
		
	}
}
