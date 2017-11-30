package ch.bfh.nowad1.exercises2.GFR;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Main extends Application {

	@Override
	public void start(Stage primaryStage) {

		Button calculateButton;

		GridPane root = new GridPane();
		root.setAlignment(Pos.CENTER);
		root.setHgap(10.0);
		root.setVgap(10.0);

		// Declaring Labels
		Label ageLabel = new Label("Alter [Jahre]: ");
		Label weightLabel = new Label("Gewicht [kg]: ");
		Label creaLabel = new Label("Serum-Kreatinin [mg/dl]: ");
		Label sexLabel = new Label("Geschlecht: ");
		Label GFRLabel = new Label("GFR: ");
		Label ResultLabel = new Label("...");
		
		// Adding every Label to the GridPane
		root.add(ageLabel, 0, 0);
		root.add(weightLabel, 0, 1);
		root.add(creaLabel, 0, 2);
		root.add(sexLabel, 0, 3);
		root.add(GFRLabel, 0, 4);
		root.add(ResultLabel, 1, 4);

		// Creating a List of Options for the age ComboBox
		ObservableList<Integer> options = FXCollections.observableArrayList();
		// Generating entries in the List from 1 to 99
		for (int i = 1; i < 100; i++) {
			options.add(Integer.valueOf(i));
		}
		// Instantiate a new ComboBox for the age
		ComboBox<Integer> age = new ComboBox<>(options);

		// Defining the text Field for the weight
		TextField weight = new TextField();

		// Defining the text Field for the weight
		TextField crea = new TextField();

		// Defining the Toggle group and the radio buttons for the gender
		final ToggleGroup tg = new ToggleGroup();
		RadioButton rbFemale = new RadioButton("weiblich");
		rbFemale.setToggleGroup(tg);
		rbFemale.setUserData(Gender.female);

		RadioButton rbMale = new RadioButton("männlich");
		rbMale.setToggleGroup(tg);
		rbMale.setUserData(Gender.male);

		// Defining the calculate Button
		calculateButton = new Button("Berechnen");
		calculateButton.addEventHandler(ActionEvent.ACTION, event -> {
			ResultLabel.setText(
					String.format("%.2f", calculate(age.getValue().intValue(), Double.parseDouble(weight.getText()),
							Double.parseDouble(crea.getText()), (Gender) tg.getSelectedToggle().getUserData())));
		});

		// Add elements to the Pane
		root.add(age, 1, 0, GridPane.REMAINING, 1);
		root.add(weight, 1, 1, GridPane.REMAINING, 1);
		root.add(crea, 1, 2, GridPane.REMAINING, 1);
		root.add(rbFemale, 1, 3);
		root.add(rbMale, 2, 3);
		root.add(calculateButton, 1, 5);

		// Define the Stage
		primaryStage.setTitle("Cockcroft-Gault-Formel");
		primaryStage.setScene(new Scene(root, 400, 250));
		primaryStage.show();

	}

	public static void main(String[] args) {
		launch(args);
	}

	private double calculate(int age, double weight, double creatinin, Gender sex) {
		return (((140 - age) * weight) / (72 * creatinin)) * sex.factor;
	}
}
