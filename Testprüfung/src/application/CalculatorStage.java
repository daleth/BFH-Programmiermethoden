package application;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class CalculatorStage extends Stage {

	public CalculatorStage() throws IOException {
		FXMLLoader loader = new FXMLLoader(
				getClass().getResource("CalculatorGUI.fxml"));
				Parent root = (Parent) loader.load();
				loader.<CalculatorController>getController().init();

				Scene scene = new Scene(root);
				scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
				this.setTitle("Calculator");
				this.setScene(scene);
				this.show();
	}
}
