package edu.luc.etl.cs313.android.simplestopwatch.model.state;

import edu.luc.etl.cs313.android.simplestopwatch.R;

/**
 * Concrete implementation of running state for timer state machine.
 */
class RunningState implements TimerState {

    public RunningState(final CountDownStateMachineStateView sm) {
        this.sm = sm;
    }

    private final CountDownStateMachineStateView sm;

    /**
     * Called when the start/stop button is pressed.
     */
    @Override
    public void onStartStop() {
        sm.actionStop();
        sm.actionReset();
        sm.toStoppedState();
    }

    /**
     * Called every second in a background thread. This function facilitates transitioning based on time passing.
     */
    @Override
    public void onTick() {
        if (sm.getTimeModel().getRuntime() > 0) {
            sm.actionDecrement();
        } else {
            sm.toBeepState();
        }
    }

    /**
     * Applies an update to the view for the running state.
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
        return R.string.RUNNING;
    }
}
