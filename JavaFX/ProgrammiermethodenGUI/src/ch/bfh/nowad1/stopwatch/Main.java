package ch.bfh.nowad1.stopwatch;

import ch.bfh.lph2.stopwatch.Timer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;;

public class Main extends Application {
	Timer timer = new Timer(500);

	@Override
	public void start(Stage primaryStage) {

		
		newStopwatch(timer);
		newStopwatch(timer);

	}
	
	public static void newStopwatch(Timer timer) {
		Stopwatch watch = new Stopwatch(timer);
		watch.setTitle("Stopwatch");
		watch.setScene(new Scene(watch.root, 350,250));
		watch.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
	

}
