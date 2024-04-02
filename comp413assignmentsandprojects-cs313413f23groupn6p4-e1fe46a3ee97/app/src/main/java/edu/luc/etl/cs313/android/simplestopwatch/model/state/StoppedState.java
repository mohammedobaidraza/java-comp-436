package edu.luc.etl.cs313.android.simplestopwatch.model.state;

import edu.luc.etl.cs313.android.simplestopwatch.R;

/**
 * Concrete implementation of stopped state for timer state machine.
 */
class StoppedState implements TimerState {

    public StoppedState(final CountDownStateMachineStateView sm) {
        this.sm = sm;
    }

    private final CountDownStateMachineStateView sm;

    /**
     * Called when the start/stop button is pressed.
     */
    @Override
    public void onStartStop() {
        sm.actionStart();
        sm.toIncrementState();
    }

    /**
     * Called every second in a background thread. This function facilitates transitioning based on time passing.
     */
    @Override
    public void onTick() {
        throw new UnsupportedOperationException("background tick should've been killed");
    }

    /**
     * Applies an update to the view for the stopped state.
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
        return R.string.STOPPED;
    }
}
