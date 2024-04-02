package edu.luc.etl.cs313.android.simplestopwatch.model.clock;

import java.util.Timer;
import java.util.TimerTask;

/**
 * An implementation of the internal clock. This clock class is not used to keep track the passage of time,
 * but rather to schedule events which record the passage of time. That is, it results in changes
 * of state for the timer.
 *
 * This implementation utilizes the java.util.Timer class to schedule periodic tick events.
 * The timer fires the onTick event every second, notifying the registered TickListener.
 *
 * @author Manny
 */
public class DefaultClockModel implements ClockModel {

    // TODO make accurate by keeping track of partial seconds when canceled etc.

    private Timer timer;

    private TickListener listener;


    /**
     * Sets the listener to receive tick events from the timer
     *
     * @param listener The listener will be notified at regular intervals
     *                 indicating the progress of the time in the timer
     */
    @Override
    public void setTickListener(final TickListener listener) {
        this.listener = listener;
    }

    /**
     * Starts a task which updates the state machine every second.
     */
    @Override
    public void start() {
        timer = new Timer();

        // The clock model runs onTick every 1000 milliseconds
        timer.schedule(new TimerTask() {
            @Override public void run() {
                // fire event
                listener.onTick();
            }
        }, /*initial delay*/ 1000, /*periodic delay*/ 1000);
    }

    /**
     * This method cancels the onTick task. No more state changes will be made to the state machine
     * for onTick calls.
     */
    @Override
    public void stop() {
        if (timer != null) {
            timer.cancel();
        }
    }
}