package edu.luc.etl.cs313.android.simplestopwatch.android;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;
import edu.luc.etl.cs313.android.simplestopwatch.R;
import edu.luc.etl.cs313.android.simplestopwatch.common.TimerModelListener;
import edu.luc.etl.cs313.android.simplestopwatch.model.ConcreteTimerModelFacade;
import edu.luc.etl.cs313.android.simplestopwatch.model.TimerModelFacade;

import java.util.Locale;

/**
 * A thin adapter component for the stopwatch.
 *
 * @author laufer
 */
public class TimerAdapter extends Activity implements TimerModelListener {

    private static String TAG = "stopwatch-android-activity";

    /**
     * The state-based dynamic model.
     */
    private TimerModelFacade model;

    protected void setModel(final TimerModelFacade model) {
        this.model = model;
    }

    /**
     * This method is called when the activity is first created.
     *
     * @param savedInstanceState If the activity is being re-initialized after
     *                           previously being shut down then this Bundle contains the data it most
     *                           recently supplied in onSaveInstanceState
     */
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // inject dependency on view so this adapter receives UI events
        setContentView(R.layout.activity_main);
        // inject dependency on model into this so model receives UI events
        this.setModel(new ConcreteTimerModelFacade());
        // inject dependency on this into model to register for UI updates
        model.setModelListener(this);
    }

    /**
     * This method is called when the activity is first created.
     *
     * @param menu The options menu where items are placed.
     * @return always returns true
     */
    @Override
    public boolean onCreateOptionsMenu(final Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }

    /**
     * This method starts the activity when it is created and initializes the state machine.
     */
    @Override
    protected void onStart() {
        super.onStart();
        model.start();
    }

    /**
     * Updates the seconds the timer 88 UI.
     *
     * @param time number of seconds to display
     */
    public void onTimeUpdate(final int time) {
        // UI adapter responsibility to schedule incoming events on UI thread
        runOnUiThread(() -> {
            final TextView tvS = findViewById(R.id.seconds);
            final var locale = Locale.getDefault();
            tvS.setText(String.format(locale, "%02d", time));
        });
    }

    /**
     * Updates the state name in the UI.
     *
     * @param stateId the state id to display
     */
    public void onStateUpdate(final int stateId) {
        // UI adapter responsibility to schedule incoming events on UI thread
        runOnUiThread(() -> {
            final TextView stateName = findViewById(R.id.stateName);
            stateName.setText(getString(stateId));
        });
    }

    /**
     * This method is called when the stop button is pressed.
     * @param view the button view
     */
    public void onStartStop(final View view) {
        model.onStartStop();
    }

}
