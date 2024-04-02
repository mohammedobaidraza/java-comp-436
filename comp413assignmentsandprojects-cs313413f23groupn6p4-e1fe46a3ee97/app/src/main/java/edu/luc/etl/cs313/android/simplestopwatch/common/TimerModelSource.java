package edu.luc.etl.cs313.android.simplestopwatch.common;

/**
 * A source of UI update events for the stopwatch.
 * This interface is typically implemented by the model.
 *
 * The method in this interface allows setting a listener for the timer model,
 * which will receive UI update events from the model
 *
 * @author laufer
 */
public interface TimerModelSource {
    /**
     * Sets the listener for the timer model
     *
     * @param listener the TimeModelListener to be set as the listener
     *                 for the time model
     */
    void setModelListener(TimerModelListener listener);
}
