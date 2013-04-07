/**
 * File: KahunaSdk.java
 * Created: 4/7/13
 * Author: Viacheslav Panasenko
 */
package com.breezy.android;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.breezy.android.R;

/**
 * KahunaSampleActivity
 * Sample activity using Kahuna SDK.
 */
public class KahunaSampleActivity extends Activity
{
    private static final String KAHUNA_API_KEY = "YOUR_API_KEY";

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        // Initialize Kahuna SDK and send start event (should be done once per application start).
        KahunaSdk sdk = KahunaSdk.getInstance();
        sdk.initSdk(this, KAHUNA_API_KEY);
        sdk.sendEvent(KahunaSdk.KahunaEvents.START);
    }

    @Override
    protected void onResume()
    {
        super.onResume();

        // Send predefined event, e.g. entering activity
        KahunaSdk.getInstance().sendEvent(KahunaSdk.KahunaEvents.KAHUNA_SAMPLE_ACTIVITY);
    }

    /**
     * Called when send event button is clicked.
     * @param v Reference to the parent view (send event button).
     */
    public void onSendEvent(View v)
    {
        Button sendEvent = (Button) v;
        KahunaSdk.getInstance().sendEvent(sendEvent.getText().toString() + " clicked");
    }
}
