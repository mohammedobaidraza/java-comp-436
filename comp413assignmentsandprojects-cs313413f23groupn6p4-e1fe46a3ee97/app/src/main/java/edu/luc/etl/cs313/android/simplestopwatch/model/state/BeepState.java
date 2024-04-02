package edu.luc.etl.cs313.android.simplestopwatch.model.state;

import edu.luc.etl.cs313.android.simplestopwatch.R;

/**
 * Beeping/Alarming state of the timer state machine.
 */
class BeepState implements TimerState {

    public BeepState(final CountDownStateMachineStateView sm) {
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
        sm.actionBeep();
    }

    /**
     * Applies an update to the view for the beeping state.
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
        return R.string.BEEPING;
    }
}
