package edu.luc.etl.cs313.android.simplestopwatch.model.time;

import static edu.luc.etl.cs313.android.simplestopwatch.common.Constants.SEC_PER_HOUR;
import static edu.luc.etl.cs313.android.simplestopwatch.common.Constants.SEC_PER_TICK;

/**
 * An implementation of the timer data model. This class is used for
 * keeping track of the time for the timer.
 */
public class DefaultTimeModel implements TimeModel {
    private int runningTime = 0;

    /**
     * Reset the runtime to zero.
     */
    @Override
    public void resetRuntime() {
        runningTime = 0;
    }

    /**
     * Increment the runtime by one second.
     */
    @Override
    public void incrementRuntime() {
        runningTime = (runningTime + SEC_PER_TICK) % SEC_PER_HOUR;
    }

    /**
     * Decrement the runtime by one second.
     */
    public void decrementRuntime() {
        runningTime = (runningTime - SEC_PER_TICK) % SEC_PER_HOUR;
    }

    /**
     * Get the current runtime.
     *
     * @return the current runtime in seconds.
     */
    @Override
    public int getRuntime() {
        return runningTime;
    }


}