package ch.bfh.nowad1.stopwatch;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import ch.bfh.lph2.stopwatch.Timer;;

public class Main extends Application {

	@Override
	public void start(Stage primaryStage) {
		Timer timer = new Timer(100);
		BorderPane stopwatch1 = new Stopwatch(timer);
		BorderPane stopwatch2 = new Stopwatch(timer);
		

		primaryStage.setTitle("StopWatch1");
		primaryStage.setScene(new Scene(stopwatch1, 350, 250));
		primaryStage.show();
		
		Stage second = new Stage();
		second.setTitle("StopWatch2");
		second.setScene(new Scene(stopwatch2, 350, 250));
		second.show();
	}
	
	

	public static void main(String[] args) {
		launch(args);
	}
}
