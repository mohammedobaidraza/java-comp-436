package edu.luc.etl.cs313.android.simplestopwatch.model.state;

import edu.luc.etl.cs313.android.simplestopwatch.common.TimerUIListener;
import edu.luc.etl.cs313.android.simplestopwatch.model.clock.TickListener;

/**
 * A state in a state machine. This interface is part of the State pattern.
 * Represents the common interface for different states in the timer state machine
 *Extends TimerUIListener and TickListener interfaces to handle UI and tick events
 * Includes methods for updating the view associated with the current state and retrieving the state ID
 *
 * @author laufer
 */
interface TimerState extends TimerUIListener, TickListener {
    /**
     * Updates the view associated with the current sate
     * Invokes the method to update the UI runtime based on the current state
     */
    void updateView();

    /**
     * Gets the ID for the current state
     * @return The resource ID associated with the current state
     */
    int getId();
}
