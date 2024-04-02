package edu.luc.etl.cs313.android.simplestopwatch.model.clock;

import edu.luc.etl.cs313.android.simplestopwatch.common.Startable;
import edu.luc.etl.cs313.android.simplestopwatch.common.Stoppable;

/**
 * The active model of the internal clock that periodically emits tick events.
 * This interface extends the Startable and Stoppable interface,
 * Indicating that the clock model can be started and stopped, in addition,
 * It extends the TickSource interface, suggesting that the clock model servers
 * As a source of the tick event
 *
 * @author laufer
 */
public interface ClockModel extends Startable, Stoppable, TickSource { }
