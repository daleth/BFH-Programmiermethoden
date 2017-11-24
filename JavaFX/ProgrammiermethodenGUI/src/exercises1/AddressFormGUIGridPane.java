package exercises1;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class AddressFormGUIGridPane extends Application {

	@Override
	public void start(Stage primaryStage) {
		GridPane root = new GridPane();

		ArrayList<Label> labels = new ArrayList<>();

		Label addressLabel = new Label("Adresse");
		Label nameLabel = new Label("Name");
		Label firstNameLabel = new Label("Vorname");
		Label streetLabel = new Label("Strasse");
		Label ZIPLabel = new Label("PLZ");
		Label townLabel = new Label("Ort");

		labels.add(addressLabel);
		labels.add(nameLabel);
		labels.add(firstNameLabel);
		labels.add(streetLabel); 
		labels.add(ZIPLabel);
		labels.add(townLabel); 

		
		labels.forEach(label -> {
			label.setPrefWidth(75.0);
			label.setMinWidth(65.0);
		});
//		for (Label label : labels) {
//			label.setPrefWidth(75.0);
//			label.setMinWidth(65.0);
//		}
		int i = 0;
		for (Label label : labels) {
			root.add(label, 0, i++);
		}
		
		
		TextField addressTextField = new TextField("Adresse");
		TextField nameTextField = new TextField("Name");
		TextField firstNameTextField = new TextField("Vorname");
		TextField streetTextField = new TextField("Strasse");
		TextField ZIPTextField = new TextField("PLZ");
		TextField townTextField = new TextField("Ort");
		
		ArrayList<TextField> textFields = new ArrayList<>();

		textFields.add(addressTextField);
		textFields.add(nameTextField);
		textFields.add(firstNameTextField);
		textFields.add(streetTextField); 
		textFields.add(ZIPTextField);
		textFields.add(townTextField); 
		
		textFields.forEach(field -> field.setPrefWidth(300.0));
		
//		for (TextField field : textFields) {
//			field.setPrefWidth(250.0);
//		}
		i = 0;
		for (TextField field : textFields) {
			root.add(field, 1, i++, GridPane.REMAINING, 1);
		}
		
		Button okButton = new Button("OK");
		Button cancelButton = new Button("Cancel");
		
		okButton.setPrefWidth(100.0);
		cancelButton.setPrefWidth(100.0);
		
		root.add(okButton, 1, 6);
		root.add(cancelButton, 2, 6);
		
		root.setAlignment(Pos.CENTER);
		root.setVgap(10.0);
		root.setHgap(10.0);
		
		root.setPadding(new Insets(10));
		root.setGridLinesVisible(false);


		primaryStage.setTitle(this.getClass().getSimpleName());
		primaryStage.setScene(new Scene(root, 400, 300));
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
