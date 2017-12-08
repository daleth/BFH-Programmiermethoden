package ch.bfh.nowad1.stopwatch;

import java.util.Observable;
import java.util.Observer;

import ch.bfh.lph2.stopwatch.Timer;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.stage.Stage;

public class Stopwatch extends Stage implements Observer {

	BorderPane root = new BorderPane();
	
	Timer timer;

	Button startButton;
	Button stopButton;
	Button resetButton;

	Label counterLabel;
	Label statusLabel;
	
	final MenuBar menubar = new MenuBar();
	
	

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
		root.setTop(this.composeMenuBar(new MenuBar()));
		root.setCenter(contentBox);
		root.setBottom(bottom);
		root.setPadding(new Insets(10));

		// Button Functionality
		startButton.setOnAction(event -> {
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
	
	public MenuBar composeMenuBar(MenuBar menubar) {
		// Composing fileMenu
				final Menu fileMenu = new Menu("File");
				final ImageView imgN = new ImageView(new Image("file:res/New.gif"));
				final MenuItem newItem = new MenuItem("_New", imgN);
				newItem.setAccelerator(KeyCombination.keyCombination("Ctrl+N"));
				newItem.setOnAction(event -> {
					System.out.println("New Button pressed");
					Stage second = new Stopwatch(timer);
					Parent root = this.getScene().getRoot();
					this.getScene().setRoot(this.root);
					Main.newStopwatch(timer);
				});

				final MenuItem startItem = new MenuItem("_Start");
				startItem.setAccelerator(KeyCombination.keyCombination("Ctrl+S"));
				startItem.setOnAction(event -> {
					System.out.println("Start Menu Item pressed");
					timer.start();
				});
				final MenuItem stopItem = new MenuItem("S_top");
				stopItem.setAccelerator(KeyCombination.keyCombination("Ctrl+D"));
				stopItem.setOnAction(event -> {
					System.out.println("Stop Menu Item pressed");
					timer.stop();
				});
				final MenuItem resetItem = new MenuItem("_Reset");
				resetItem.setAccelerator(KeyCombination.keyCombination("Ctrl+R"));
				resetItem.setOnAction(event -> {
					System.out.println("Reset Menu Item pressed");
					timer.reset();
				});

				final ImageView imgC = new ImageView(new Image("file:res/Close.gif"));
				final MenuItem closeItem = new MenuItem("_Close", imgC);
				closeItem.setAccelerator(KeyCombination.keyCombination("Ctrl+Q"));
				closeItem.setOnAction(event -> {
					System.out.println("Close Button pressed");
					Platform.exit();
				});

				fileMenu.getItems().addAll(newItem, startItem, stopItem, resetItem, closeItem);
				
				// Composing Edit Menu
				final Menu editMenu = new Menu("Edit");
				
				final MenuItem changeIntervalItem = new MenuItem("Set _Interval");
				changeIntervalItem.setAccelerator(KeyCombination.keyCombination("Ctrl+I"));
				changeIntervalItem.setOnAction(event -> {
					System.out.println("Set Interval Menu Item chosen");
					//timer.reset();O
					this.timer.setInterval(100);
					this.timer.addObserver(this);
					// TODO update Interval
				});
				
				
				
				editMenu.getItems().addAll(changeIntervalItem);
				
				menubar.getMenus().addAll(fileMenu, editMenu);
				return menubar;
	}

}
