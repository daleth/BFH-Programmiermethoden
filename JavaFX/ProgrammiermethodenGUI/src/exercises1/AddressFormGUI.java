package exercises1;


import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class AddressFormGUI extends Application {

	@Override
	public void start(Stage primaryStage) {
		BorderPane root = new BorderPane();
		VBox centerContainer = new VBox(); 
		
		centerContainer.setSpacing(10.0);
		centerContainer.setAlignment(Pos.CENTER);
		
		HBox titleContainer = new HBox(); 
		HBox nameContainer = new HBox(); 
		HBox firstNameContainer = new HBox(); 
		HBox streetContainer = new HBox(); 
		HBox ZIPContainer = new HBox(); 
		HBox townContainer = new HBox();
		HBox buttonContainer = new HBox();
		
		titleContainer.setAlignment(Pos.CENTER);
		nameContainer.setAlignment(Pos.CENTER);
		firstNameContainer.setAlignment(Pos.CENTER);
		streetContainer.setAlignment(Pos.CENTER);
		ZIPContainer.setAlignment(Pos.CENTER);
		townContainer.setAlignment(Pos.CENTER);
		buttonContainer.setAlignment(Pos.CENTER);
		
		
		
		double labelWidth = 75.0;
		double textFieldPrefWidth = 300.0;
		
		Label titleLabel = new Label("Adresse");
		titleLabel.setFont(Font.font("Dialog", FontWeight.BOLD, 16.0));
		titleContainer.getChildren().add(titleLabel);
		
		Label nameLabel = new Label("Name");
		Label firstNameLabel = new Label("Vorname");
		Label streetLabel = new Label("Strasse");
		Label ZIPLabel = new Label("PLZ");
		Label townLabel = new Label("Ort");
		
		nameLabel.setPrefWidth(labelWidth);
		firstNameLabel.setPrefWidth(labelWidth);
		streetLabel.setPrefWidth(labelWidth);
		ZIPLabel.setPrefWidth(labelWidth);
		townLabel.setPrefWidth(labelWidth);
		
		townLabel.setPadding(new Insets(10));
		
				
		TextField nameField = new TextField(); 
		TextField firstNameField = new TextField(); 
		TextField streetField = new TextField(); 
		TextField ZIPField = new TextField(); 
		TextField townField = new TextField(); 
		
		nameField.setPrefWidth(textFieldPrefWidth);
		firstNameField.setPrefWidth(textFieldPrefWidth);
		streetField.setPrefWidth(textFieldPrefWidth);
		ZIPField.setPrefWidth(50.0);
		townField.setPrefWidth(textFieldPrefWidth);
		
		
		nameContainer.getChildren().addAll(nameLabel, nameField);
		firstNameContainer.getChildren().addAll(firstNameLabel, firstNameField);
		streetContainer.getChildren().addAll(streetLabel, streetField);
		ZIPContainer.getChildren().addAll(ZIPLabel, ZIPField, townLabel, townField);
		
		Button OKButton = new Button("OK");
		Button CancelButton = new Button("Cancel");
		
		OKButton.setPrefWidth(100.0);
		CancelButton.setPrefWidth(100.0);
		
		buttonContainer.setSpacing(10.0);
		buttonContainer.getChildren().addAll(OKButton, CancelButton);
		

		centerContainer.getChildren().addAll(titleContainer, nameContainer, firstNameContainer, streetContainer, ZIPContainer, buttonContainer);
		centerContainer.setAlignment(Pos.CENTER);

		root.setCenter(centerContainer);
		
		primaryStage.setTitle("Address Form");
		primaryStage.setScene(new Scene(root, 400,300));
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
