package edu.luc.etl.cs313.android.simplestopwatch.common;

/**
 * A listener for UI update events.
 * This interface is typically implemented by the adapter, with the
 * events coming from the model.
 *
 * The methods in this interface provide callbacks for updating the UI
 * with the current elapsed time on the timer and the current state of the
 * timer
 *
 * @author laufer
 */
public interface TimerModelListener {
    /**
     * Called when the elapsed time on the timer is updated
     *
     * @param timeValue This value represent the current elapsed time on the timer
     */
    void onTimeUpdate(int timeValue);

    /**
     * Called when the state of the timer is updated
     *
     * @param stateId This value identifies the current state of the timer
     */
    void onStateUpdate(int stateId);
}
