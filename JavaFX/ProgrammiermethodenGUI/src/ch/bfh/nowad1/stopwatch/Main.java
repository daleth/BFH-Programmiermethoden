package ch.bfh.nowad1.stopwatch;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {

	@Override
	public void start(Stage primaryStage) {
		BorderPane stopwatch = new Stopwatch();

		primaryStage.setTitle("StopWatch");
		primaryStage.setScene(new Scene(stopwatch, 350, 250));
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
