package ch.bfh.nowad1.exercises2.GFR;

public enum Sex {
male(1.0), female(0.85);
public final double factor;
private Sex(double factor) {
	this.factor = factor; 
}
}
