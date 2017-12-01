package ch.bfh.nowad1.stopwatch;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

import java.util.Observable;
import java.util.Observer;

import ch.bfh.lph2.stopwatch.Timer;

public class Stopwatch extends BorderPane implements Observer{

	Timer timer	;

	Button startButton;
	Button stopButton;
	Button resetButton;

	Label counterLabel;
	Label statusLabel;

	public Stopwatch(Timer timer) {
		this.timer = timer;
		this.timer.addObserver(this);
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

		buttonBox.getChildren().addAll(startButton, stopButton, resetButton);
		buttonBox.setSpacing(20);
		// buttonBox.setPadding(new Insets(0,10,0,10));

		// Creating status label and set Padding

		statusLabel = new Label("stopped");
		statusLabel.setPadding(new Insets(5, 5, 0, 5));

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
		});

		stopButton.addEventHandler(ActionEvent.ACTION, event -> {
			System.out.println("Stop Button clicked");
			timer.stop();
		});
		// Kurzform setOnAction
		resetButton.setOnAction(event -> {
			System.out.println("Reset Button clicked");
			timer.reset();
		});

	}

	public void update() {
		Platform.runLater(() -> {
			
			counterLabel.setText(timer.getTimeString());
			// Buttons update hier machen und nicht im lambda, ist jedoch nicht ganz
			// effizient, da alle paar Sekunden ein update gemacht werden muss.
			startButton.setDisable(timer.isRunning());
			stopButton.setDisable(!timer.isRunning());
			resetButton.setDisable(timer.isRunning());
			
			
			
			if (timer.isRunning()) {
				statusLabel.setText("running");
			} else {
				statusLabel.setText("stopped");
			}
		});

	}

	@Override
	public void update(Observable o, Object arg) {
		this.update();
	}

}
