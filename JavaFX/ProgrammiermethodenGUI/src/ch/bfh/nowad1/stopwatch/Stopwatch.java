package ch.bfh.nowad1.stopwatch;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import ch.bfh.lph2.stopwatch.Timer;

public class Stopwatch extends BorderPane {

	Timer timer; 
	Button startButton;
	Button stopButton;
	Button resetButton;

	Label counterLabel; 
	Label statusLabel;
	public Stopwatch() {
		timer = new Timer(100);
		// Creating necessary BorderPanes and HBoxes

		HBox buttonBox = new HBox();
		HBox contentBox = new HBox();
		BorderPane bottom = new BorderPane();

		// Creating and adding content for the contentBox

		contentBox.getChildren().add(new Label("Sekunden: "));
		counterLabel = new Label("0:00");
		contentBox.getChildren().add(counterLabel);
		contentBox.setAlignment(Pos.CENTER);

		// Creating Buttons and the status bar

		startButton = new Button("Start");
		stopButton = new Button("Stop");
		stopButton.setDisable(true);
		resetButton = new Button("Reset");

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

		statusLabel = new Label("stopped");
		statusLabel.setPadding(new Insets(5,5,0,5));

		// Compose bottom pane
		bottom.setTop(buttonBox);
		bottom.setBottom(statusLabel);

		// Compose main pane
		this.setCenter(contentBox);		
		this.setBottom(bottom);
		this.setPadding(new Insets(10));


		// Button Functionality
		startButton.addEventHandler(ActionEvent.ACTION, event -> {
			System.out.println("Start Button clicked"); 
			timer.start();
			stopButton.setDisable(false);
			startButton.setDisable(true);
			statusLabel.setText("started");
		});

		stopButton.addEventHandler(ActionEvent.ACTION, event -> {
			System.out.println("Stop Button clicked"); 
			timer.stop();
			startButton.setDisable(false); 
			stopButton.setDisable(true);
			statusLabel.setText("stopped");

		});

		resetButton.addEventHandler(ActionEvent.ACTION, event -> {
			System.out.println("Reset Button clicked"); 
			timer.reset();
			if (!timer.isRunning()) {
				startButton.setDisable(false);
				stopButton.setDisable(true); 
				statusLabel.setText("resetted");
			}
			
			
		});

		timer.attach(this);
	}

	public void update() {
		Platform.runLater(() -> {
		counterLabel.setText(timer.getTimeString());
		if (timer.isRunning()) {
			statusLabel.setText("running");
		} else {
			statusLabel.setText("stopped");
		}	
		});
		
	}


}

