package ch.bfh.nowad1.dataEditor;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class DataEditorStage extends Stage {
	

	public DataEditorStage(Model model) throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("DataEditor.fxml"));
		// Create the node hierarchy by calling load
		Parent root = (Parent) loader.load();
		// Pass the model to the controller by calling init
		loader.<DataEditorController>getController().init(model);

		// Pane root = FXMLLoader.load(getClass().getResource("DataEditor.fxml"));
		Scene scene = new Scene(root);
		// scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

		setTitle("Data Editor");
		setScene(scene);
		show();

	}
//
//	public ObservableList<Data> getData() {
//		return data;
//	}

	public static void main(String[] args) {
	}
}
