package edu.luc.etl.cs313.android.simplestopwatch.model.state;

import edu.luc.etl.cs313.android.simplestopwatch.R;

/**
 * Concrete implementation of Increment state for timer state machine.
 */
public class IncrementState implements TimerState {
    /*
     * The number of times the timer has been incremented, i.e., the number of 'visits' to this state.
     *  This is used to determine whether the timer should transition to the
     * running state.
     */
    private int visits = 0;
    /*
     * The minimum number of times the timer has been incremented before
     * the timer transitions to the running state.
     */
    public static final int MIN_VISITS = 3;
    /*
     * The maximum number of times the timer has been incremented before
     * the timer transitions to the running state.
     */
    public static final int MAX_VISITS = 99;
    private final CountDownStateMachineStateView sm;

    public IncrementState(final CountDownStateMachineStateView sm) {
        this.sm = sm;
    }

    /**
     * Called when the start/stop button is pressed.
     */
    @Override
    public void onStartStop() {
        visits = 0;
        sm.actionIncrement();
        sm.toIncrementState();
    }

    /**
     * Called every second in a background thread. This function facilitates transitioning based on time passing.
     */
    @Override
    public void onTick() {
        if (visits >= MIN_VISITS || sm.getTimeModel().getRuntime() >= MAX_VISITS) {
            visits = 0;
            /*
             * This beep is here to meet the requirement of beeping
             * before the timer transitions to the running state.
             */
            sm.actionBeep();
            sm.toRunningState();
            sm.actionUpdateView();
        } else {
            visits++;
        }
    }

    /**
     * Applies an update to the view for the increment state.
     */
    @Override
    public void updateView() {
        sm.updateUIRuntime();
    }

    /**
     * Returns the id of the state.
     *
     * @return state id
     */
    @Override
    public int getId() {
        return R.string.INCREMENT;
    }
}
