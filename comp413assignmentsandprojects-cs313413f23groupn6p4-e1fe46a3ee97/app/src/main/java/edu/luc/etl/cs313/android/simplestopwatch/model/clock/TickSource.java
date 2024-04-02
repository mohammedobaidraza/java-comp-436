package edu.luc.etl.cs313.android.simplestopwatch.model.clock;

/**
 * A source of onTick events for the timer.
 * The method in this interface allows setting a listener for onTick events,
 * which will receive periodic events from the timer
 *
 * @author Manny
 */
public interface TickSource {
    /**
     * Sets the listener for onTick events from the timer
     *
     * @param listener The TickListener to be set as the listener for onTick events
     */
    void setTickListener(TickListener listener);
}
