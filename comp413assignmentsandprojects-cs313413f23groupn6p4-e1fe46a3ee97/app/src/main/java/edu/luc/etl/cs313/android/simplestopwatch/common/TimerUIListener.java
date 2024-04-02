package edu.luc.etl.cs313.android.simplestopwatch.common;

/**
 * A listener for stopwatch events coming from the UI.
 *
 * The method in this interface provides a callback for handling the Start/Stop
 * button click event from the UI
 *
 * @author laufer
 */
public interface TimerUIListener {
    /**
     * Called when the Start/Stop button is clicked on the UI
     */
    void onStartStop();
}
