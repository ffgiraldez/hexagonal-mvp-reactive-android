package es.ffgiraldez.hmr.android.recents.ui;

import android.os.Bundle;

import es.ffgiraldez.hmr.android.OpenLibraActivity;
import es.ffgiraldez.hmr.android.R;

public class RecentActivity extends OpenLibraActivity {
    // ----------------------------------
    // LIFE CIRCLE
    // ----------------------------------
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recent_activity);
    }
}
