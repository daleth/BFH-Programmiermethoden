	package ch.bfh.nowad1.dataEditor;
	
import javafx.application.Application;
import javafx.stage.Stage;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		new DataEditorStage();
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}


}
