package ch.bfh.nowad1.topic3;
import java.sql.Time;
import java.util.Observable;
import java.util.Observer;

import javafx.application.Platform;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class DigitalClock2 extends Stage implements Observer {

   	private final Label timeLabel;
    private final Time time;

   	public DigitalClock2(final Time time) {
        this.time = time;
        this.time.addObserver(this);
   	}

   	public void update(Observable o, Object arg) {
   	    // Make sure, the GUI is updated in the JavaFX Application Thread!
   	    Platform.runLater(() -> {
   	   	   	long s = this.time.getTime();
   	   	    this.timeLabel.setText(String.valueOf(s));
   	   	});
   	}
}
