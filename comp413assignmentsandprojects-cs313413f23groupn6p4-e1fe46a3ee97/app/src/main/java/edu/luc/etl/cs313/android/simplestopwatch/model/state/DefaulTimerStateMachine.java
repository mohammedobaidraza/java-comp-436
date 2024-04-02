package edu.luc.etl.cs313.android.simplestopwatch.model.state;

import android.media.AudioManager;
import android.media.ToneGenerator;
import edu.luc.etl.cs313.android.simplestopwatch.common.TimerModelListener;
import edu.luc.etl.cs313.android.simplestopwatch.model.clock.ClockModel;
import edu.luc.etl.cs313.android.simplestopwatch.model.time.TimeModel;

/**
 * An implementation of the state machine for the stopwatch.
 *
 * @author laufer
 */
public class DefaulTimerStateMachine implements TimerStateMachine {

    public DefaulTimerStateMachine(final TimeModel timeModel, final ClockModel clockModel) {
        this.timeModel = timeModel;
        this.clockModel = clockModel;
    }

    private final TimeModel timeModel;

    private final ClockModel clockModel;

    /**
     * The internal state of this adapter component. Required for the State pattern.
     */
    private TimerState state;

    @Override
    public TimeModel getTimeModel() {
        return timeModel;
    }


    /**
     * Set the state of the state machine. Required for the State pattern.
     *
     * @param state Initialized state object
     */
    protected void setState(final TimerState state) {
        this.state = state;
        listener.onStateUpdate(state.getId());
    }

    private TimerModelListener listener;

    /**
     * Set the listener for UI events.
     *
     * @param listener Time model listener that passes updates to the UI thread.
     */
    @Override
    public void setModelListener(final TimerModelListener listener) {
        this.listener = listener;
    }

    // forward event uiUpdateListener methods to the current state
    // these must be synchronized because events can come from the
    // UI thread or the timer thread

    /**
     * Calls the current state's onStartStop method.
     */
    @Override
    public synchronized void onStartStop() {
        state.onStartStop();
    }

    /**
     * Calls the current state's onTick method.'
     */
    @Override
    public synchronized void onTick() {
        state.onTick();
    }

    /**
     * Calls the current state's onTimeUpdate method.
     */
    @Override
    public void updateUIRuntime() {
        listener.onTimeUpdate(timeModel.getRuntime());
    }

    @Override
    /**
     * TODO: This method is firing more than once, causing a new thread to be created, which then results in
     * in the clock UI to decrement faster than a second.
     */
    public void updateUITimer() {
        listener.onTimeUpdate(timeModel.getRuntime());
    }

    // known states
    private final TimerState STOPPED = new StoppedState(this);
    private final TimerState RUNNING = new RunningState(this);
    private final TimerState INCREMENT = new IncrementState(this);
    private final TimerState BEEP = new BeepState(this);

    /**
     * Transition to the Running state.
     */
    @Override
    public void toRunningState() {
        setState(RUNNING);
    }

    /**
     * Transition to the Stopped state.
     */
    @Override
    public void toStoppedState() {
        setState(STOPPED);
    }

    /**
     * Transition to the Increment state.
     */
    @Override
    public void toIncrementState() {
        setState(INCREMENT);
    }

    /**
     * Transition to the Beep state.
     */
    @Override
    public void toBeepState() {
        setState(BEEP);
    }

    /**
     * Entry point to the state machine.
     */
    @Override
    public void actionInit() {
        toStoppedState();
    }

    /**
     * Start the clock model.
     */
    @Override
    public void actionStart() {
        clockModel.start();
    }

    /**
     * Stop the clock model.
     */
    @Override
    public void actionStop() {
        clockModel.stop();
    }

    /**
     * Increment the clock model's run time and update the view.
     */
    @Override
    public void actionIncrement() {
        timeModel.incrementRuntime();
        actionUpdateView();
    }

    /**
     * Decrement the clock model's run time and update the view.
     */
    @Override
    public void actionDecrement() {
        timeModel.decrementRuntime();
        actionUpdateView();
    }

    /**
     * Reset the clock model's run time and update the view.
     */
    @Override
    public void actionReset() {
        timeModel.resetRuntime();
        actionUpdateView();
    }

    /**
     * Produce a beep sound. Typically used when transitioning to or in the Beep state.
     */
    @Override
    public void actionBeep() {
        var volume = 100;
        var duration = 1000;
        var beepSound = new ToneGenerator(AudioManager.STREAM_MUSIC, volume);
        beepSound.startTone(ToneGenerator.TONE_CDMA_PIP, duration);
        beepSound.stopTone();
    }

    /**
     * Update the UI.
     */
    @Override
    public void actionUpdateView() {
        state.updateView();
    }

}
