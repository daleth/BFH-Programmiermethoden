package ch.bfh.nowad1.dataEditor;

import java.io.IOException;
import java.util.Observer;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class DataEditorStage extends Stage implements Observer{

	private ObservableList<Item> data = FXCollections.observableArrayList();

	
	public DataEditorStage() throws IOException {

		
		
		
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("DataEditor.fxml"));
				// Create the node hierarchy by calling load
				Parent root = (Parent) loader.load();
				// Pass the model to the controller by calling init
				loader.<DataEditorController>getController().init(this);
		
		
		
//		Pane root = FXMLLoader.load(getClass().getResource("DataEditor.fxml"));
		Scene scene = new Scene(root);
//		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

		setTitle("Data Editor");
		setScene(scene);
		show();

	}
	public ObservableList<Item> getData(){
		return data;
	}
	public static void main(String[] args) {
	}
	
	
	@Override
	public void update(java.util.Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}
}
