package ch.bfh.nowad1.dataEditor;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class PieChartStage extends Stage {

	public PieChartStage(Model model) throws IOException {

		FXMLLoader loader = new FXMLLoader(getClass().getResource("PieChart.fxml"));
		Parent root = (Parent) loader.load();

		loader.<PieChartController>getController().init(model);

		Scene scene = new Scene(root);
		this.setTitle("Pie Chart");
		this.setScene(scene);
		this.show();
	}
}