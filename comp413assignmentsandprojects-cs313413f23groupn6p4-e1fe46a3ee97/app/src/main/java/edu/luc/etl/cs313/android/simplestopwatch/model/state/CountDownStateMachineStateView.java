package edu.luc.etl.cs313.android.simplestopwatch.model.state;

import edu.luc.etl.cs313.android.simplestopwatch.model.time.TimeModel;

/**
 * The restricted view states have of their surrounding state machine.
 * This is a client-specific interface in Peter Coad's terminology.
 *
 * This interface defines methods that a state in the countdown state machine
 * can use to interact with the surrounding state machine
 *
 * @author laufer
 */
interface CountDownStateMachineStateView {


    /**
     * Gets the TimeModel associated with the state view
     *
     * @return The TimeModel associated with the state view
     */
    TimeModel getTimeModel();

    //From here the transitions to each state

    /**
     *  Transition to the Running state
     */
    // transitions
    void toRunningState();

    /**
     * Transition to the Stopped state
     */
    void toStoppedState();

    /**
     * Transition to the Increment state
     */
    void toIncrementState();

    /**
     * Initializes the state
     */
    // actions
    void actionInit();

    /**
     * Start the timer
     */
    void actionStart();

    /**
     * Stops the timer
     */
    void actionStop();

    /**
     * Increments the timer value
     */
    void actionIncrement();

    /**
     * Decrements the timer value
     */
    void actionDecrement();

    /**
     * Updates the view
     */
    void actionUpdateView();

    /**
     * Resets the state
     */
    void actionReset();

    /**
     * Triggers the beep action
     */
    void actionBeep();

    // state-dependent UI updates
    /**
     * Updates the UI for runtime during beeping
     */
    void updateUIRuntime();

    /**
     * Updates the UI for timer
     */
    void updateUITimer();

    /**
     * Transition to the Beep state
     */
    void toBeepState();
}
