package edu.luc.etl.cs313.android.simplestopwatch.model.state;

import edu.luc.etl.cs313.android.simplestopwatch.common.TimerModelSource;
import edu.luc.etl.cs313.android.simplestopwatch.common.TimerUIListener;
import edu.luc.etl.cs313.android.simplestopwatch.model.clock.TickListener;

/**
 * The state machine for the state-based dynamic model of the stopwatch.
 * This interface is part of the State pattern.
 * Combines functionality from TimerUIListener, TickListener, TimerModelSource,
 * and CountDownStateMachineStateView interfaces
 * Represents the interface for the state machine controlling the timer's dynamic model
 *
 * @author laufer
 */
public interface TimerStateMachine extends TimerUIListener, TickListener, TimerModelSource, CountDownStateMachineStateView {
}
