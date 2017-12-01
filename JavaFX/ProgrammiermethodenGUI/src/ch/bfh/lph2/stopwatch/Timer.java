package ch.bfh.lph2.stopwatch;

import java.util.Observable;

/**
 * This class implements the functionality of a timer. A timer can be started,
 * stopped and reset. A timer notifies an attached {@code Stopwatch} about state
 * changes by calling the {@code update} method of the {@code Stopwatch}.
 */
public class Timer extends Observable implements Runnable {

	/**
	 * The number of ticks.
	 */
	private int ticks;

	/**
	 * The time interval (in milliseconds) of a tick.
	 */
	private int interval;

	/**
	 * The thread which triggers the ticks. Is null if the timer is not running.
	 */
	private Thread thread;

	/**
	 * Creates a Timer for the given interval.
	 * 
	 * @param interval
	 *            the time interval (in milliseconds) of the timer
	 */
	public Timer(int interval) {
		this.interval = interval;
	}

	/**
	 * Gets the time of the timer.
	 * 
	 * @return the time (in seconds) of the timer.
	 */
	public final double getTime() {
		return ticks * interval / 1000.0;
	}

	/**
	 * Gets the hours of the time.
	 * 
	 * @return the hours of the time.
	 */
	public int getHours() {
		return (int) this.getTime() / 3600;
	}

	/**
	 * Gets the minutes of the time.
	 * 
	 * @return the minutes of the time.
	 */
	public int getMinutes() {
		return (int) (this.getTime() / 60) % 60;
	}

	/**
	 * Gets the seconds of the time.
	 * 
	 * @return the seconds of the time.
	 */
	public int getSeconds() {
		return (int) this.getTime() % 60;
	}

	/**
	 * Gets the time of the timer as String.
	 * 
	 * @return the time (in seconds) converted to a String.
	 */
	public final String getTimeString() {
		return String.valueOf(this.getTime());
	}

	/**
	 * Returns true if timer is running.
	 * 
	 * @return true if the timer is running, otherwise false.
	 */
	public final boolean isRunning() {
		return thread != null;
	}

	/**
	 * Starts the timer.
	 */
	public final void start() {
		if (thread == null) {
			thread = new Thread(this);
			thread.setDaemon(true);
			thread.setPriority(Thread.MAX_PRIORITY);
			thread.start();
			this.setChanged();
			this.notifyObservers();
		}
	}

	/**
	 * Stops the timer.
	 */
	public final void stop() {
		if (thread != null) {
			thread = null;
		}
		this.setChanged();
		this.notifyObservers();
	}

	/**
	 * Resets the time of the timer.
	 */
	public final void reset() {
		ticks = 0;
		this.setChanged();
		this.notifyObservers();
	}

	/**
	 * Increments ticks at the expiration of the time interval.
	 */
	@Override
	public final void run() {
		while (thread != null) {
			try {
				Thread.sleep(interval);
			} catch (InterruptedException e) {
				// do nothing
			}
			if (thread != null) {
				ticks++;
				this.setChanged();
				this.notifyObservers();
			}
		}
	}
}
