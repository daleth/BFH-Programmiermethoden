package ch.bfh.nowad1.dataEditor;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class DataEditorStage extends Stage {

	public DataEditorStage() throws IOException {
		System.out.println(getClass().getResource("DataEditor.fxml"));
		Parent root = FXMLLoader.load(getClass().getResource("DataEditor.fxml"));
		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

		setTitle("Data Editor");
		setScene(scene);
		show();
	}

	public static void main(String[] args) {
	}
}
