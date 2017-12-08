package ch.bfh.nowad1.topic3;

import java.sql.Time;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {


	@Override
	public void start(Stage stage) throws Exception {
		Time time = new Time();
		new DigitalClock2(time);
	//	new AnalogClock(time);
	}


	public static void main(String[] args) {
		launch(args);
	}
}
