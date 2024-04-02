package edu.luc.etl.cs313.android.simplestopwatch.model.clock;

/**
 * A listener for onTick events coming from the internal clock model.
 * The method in this interface provides a callback for handling the onTick event.
 *
 * @author laufer
 */
public interface TickListener {
    /**
     * Called when the onTick event occurs in the internal clock model
     */
    void onTick();
}
