package ch.bfh.nowad1.dataEditor;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Observable;
import java.util.Observer;

import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.PieChart;

public class PieChartController implements Observer {

	private Model model;

	private ObservableList<PieChart.Data> pieChartData;

	@FXML
	private PieChart pieChart;

	@FXML
	protected void initialize() {
		this.pieChartData = this.pieChart.getData();
		this.pieChart.setLegendVisible(true);
	}

	public void init(Model model) {
		this.model = model;
		for (String name : this.model.getNames()) {
			this.pieChartData.add(new PieChart.Data(name, this.model.getQuantity(name)));
		}
		this.model.addObserver(this);
	}

	@Override
	public void update(Observable o, Object arg) {
		@SuppressWarnings("unchecked")
		HashMap.Entry<String, Integer> entry = (Entry<String, Integer>) arg;
		boolean updated = false;
		for (PieChart.Data d : pieChartData) {
			if (d.getName().equals(entry.getKey())) {
				// Platform.runLater(() -> d.setPieValue(entry.getValue()));
				d.setPieValue(entry.getValue());
				// GUI muss aus JavaFX-Application Thread aktualisiert werden. Wird für diese
				// Übung eigentlich nicht benötigt.
				updated = true;
				break;
			}
		}
		if (!updated) {
			Platform.runLater(() -> this.pieChartData.add(new PieChart.Data(entry.getKey(), entry.getValue())));

		}
	}
}
