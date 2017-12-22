package ch.bfh.nowad1.dataEditor;

import javafx.application.Application;
import javafx.stage.Stage;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) throws Exception {
		Model model = new Model();
		new PieChartStage(model);
		new DataEditorStage(model);
		new DataEditorStage(model);


	}

	public static void main(String[] args) {
		launch(args);
	}


}
