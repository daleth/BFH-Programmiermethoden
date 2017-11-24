package exercises1;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Stopwatch1_withBorderPane extends Application {


	// Private Fields (Alle Werte, die ich später mal benutzen möchte, um sie zu aktualisieren) 
	private Button start;
	private Button stop;
	private Button reset;
	private Label statusLabel;
	private Label counter;



	@Override
	public void start(Stage primaryStage) {
		// Creating necessary BorderPanes and HBoxes
		final BorderPane root = new BorderPane(); // mit final kann die Instanz nicht mehr verändert werden. 

		HBox buttonBox = new HBox();
		HBox contentBox = new HBox();
		BorderPane bottom = new BorderPane();

		// Creating and adding content for the contentBox

		contentBox.getChildren().add(new Label("Sekunden: "));
		Label counterLabel = new Label("0:00");
		contentBox.getChildren().add(counterLabel);
		contentBox.setAlignment(Pos.CENTER);

		// Creating Buttons and the status bar

		Button startButton = new Button("Start");
		Button stopButton = new Button("Stop");
		stopButton.setDisable(true);
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
		buttonBox.setAlignment(Pos.CENTER);

		buttonBox.getChildren().addAll(startButton,stopButton,resetButton);
		buttonBox.setSpacing(20);
		//buttonBox.setPadding(new Insets(0,10,0,10));

		// Creating status label and set Padding

		Label statusLabel = new Label("stopped");
		statusLabel.setPadding(new Insets(5,5,0,5));

		// Compose bottom pane
		bottom.setTop(buttonBox);
		bottom.setBottom(statusLabel);

		// Compose main pane
		root.setCenter(contentBox);		
		root.setBottom(bottom);
		root.setPadding(new Insets(10));

		primaryStage.setTitle("StopWatch");
		primaryStage.setScene(new Scene(root, 350, 250));
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
