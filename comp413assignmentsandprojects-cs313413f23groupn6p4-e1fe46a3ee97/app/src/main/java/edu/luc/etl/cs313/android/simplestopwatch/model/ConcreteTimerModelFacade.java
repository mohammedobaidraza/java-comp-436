package edu.luc.etl.cs313.android.simplestopwatch.model;

import edu.luc.etl.cs313.android.simplestopwatch.common.TimerModelListener;
import edu.luc.etl.cs313.android.simplestopwatch.model.clock.ClockModel;
import edu.luc.etl.cs313.android.simplestopwatch.model.clock.DefaultClockModel;
import edu.luc.etl.cs313.android.simplestopwatch.model.state.DefaulTimerStateMachine;
import edu.luc.etl.cs313.android.simplestopwatch.model.state.TimerStateMachine;
import edu.luc.etl.cs313.android.simplestopwatch.model.time.DefaultTimeModel;
import edu.luc.etl.cs313.android.simplestopwatch.model.time.TimeModel;

/**
 * An implementation of the model facade. This class is used to
 * provide an abstraction over the state machine, clock, and time keeping component.
 *
 * @author Manny
 */
public class ConcreteTimerModelFacade implements TimerModelFacade {

    private final TimerStateMachine stateMachine;

    private final ClockModel clockModel;

    private final TimeModel timeModel;

    public ConcreteTimerModelFacade() {
        timeModel = new DefaultTimeModel();
        clockModel = new DefaultClockModel();
        stateMachine = new DefaulTimerStateMachine(timeModel, clockModel);
        clockModel.setTickListener(stateMachine);
    }

    /**
     * Initializes the state machine.
     */
    @Override
    public void start() {
        stateMachine.actionInit();
    }

    /**
     * Set the model listener that performs UI updates.
     *
     * @param listener the time model listener to set.
     */
    @Override
    public void setModelListener(final TimerModelListener listener) {
        stateMachine.setModelListener(listener);
    }

    /**
     * Facade for start/stop button of timer state machine.
     */
    @Override
    public void onStartStop() {
        stateMachine.onStartStop();
    }
}
