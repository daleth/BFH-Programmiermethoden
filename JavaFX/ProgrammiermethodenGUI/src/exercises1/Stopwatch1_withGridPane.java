package exercises1;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Stopwatch1_withGridPane extends Application {

	@Override
	public void start(Stage primaryStage) {
		// Creating necessary BorderPanes and HBoxes
		GridPane root = new GridPane();
		HBox buttonBox = new HBox();
		HBox contentBox = new HBox();
		BorderPane bottom = new BorderPane();
		
		// Creating and adding content for the contentBox
		
		contentBox.getChildren().add(new Label("Sekunden: "));
		Label counterLabel = new Label("0:0");
		contentBox.getChildren().add(counterLabel);
		contentBox.setAlignment(Pos.CENTER);
		
		// Creating Buttons and the status bar
		
		Button startButton = new Button("Start");
		Button stopButton = new Button("Stop");
		Button resetButton = new Button("Reset");
		
		// Declare preferred and minimum button width
		double prefButtonWidth = 100.0;
		double minButtonWidth = 60.0;
		
		// Set pref and min button width
		startButton.setPrefWidth(prefButtonWidth);
		stopButton.setPrefWidth(prefButtonWidth);
		resetButton.setPrefWidth(prefButtonWidth);
		
		startButton.setMinWidth(minButtonWidth);
		stopButton.setMinWidth(minButtonWidth);
		resetButton.setMinWidth(minButtonWidth);
		
		// Add all Buttons to the buttonBox and set spacing and padding and alignment
		
		buttonBox.getChildren().addAll(startButton,stopButton,resetButton);
		buttonBox.setSpacing(20);
		buttonBox.setPadding(new Insets(0,20,0,20));
		buttonBox.setAlignment(Pos.CENTER);
		
		// Creating status label and set Padding
		
		Label statusLabel = new Label("stopped");
	//	statusLabel.setPadding(new Insets(5,20,5,20));
		
		// Compose bottom pane
		bottom.setTop(buttonBox);
		bottom.setBottom(statusLabel);
		
		// Compose main pane
		
		GridPane.setConstraints(contentBox, 1, 0);
		GridPane.setConstraints(startButton, 0, 1, 1, 1);
		GridPane.setConstraints(stopButton, 1, 1, 1, 1);
		GridPane.setConstraints(resetButton, 2, 1, 1, 1);
		GridPane.setConstraints(statusLabel, 0, 2, 3, 1);
		
		
		//contentBox.setPrefSize(300, 400);
//		GridPane.setConstraints(bottom, 0, 1, 1, 1, HPos.CENTER,VPos.BOTTOM);

		root.setHgap(10);
		root.setVgap(10);
		root.setPadding(new Insets(20));
		
		root.getChildren().add(contentBox);
		root.getChildren().add(startButton);
		root.getChildren().add(stopButton);
		root.getChildren().add(resetButton);
		root.getChildren().add(statusLabel);
	
		
		primaryStage.setTitle("StopWatch");
		primaryStage.setScene(new Scene(root, 350, 250));
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
