package ch.bfh.nowad1.exercises2.GFR;

import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;

public class GFR extends BorderPane {
	// Instance variables
	private int age;
	private double weight;
	private double creatinin;
	private double GFRate;

	public enum Sex {
	male(1.0), female(0.85);
	public final double factor;
	private Sex(double factor) {
		this.factor = factor; 
	}
}
	private Button calculateButton;
		
	public GFR() {
		
	}
	
	private double calculate(int age, double weight, double creatinin, Sex sex ) {
		return (140-age) * weight / 72 * creatinin * sex.factor;
	}
	
	

}


