package es.ffgiraldez.hmr.android.recents.ui;

import android.os.Bundle;

import es.ffgiraldez.hmr.Injector;
import es.ffgiraldez.hmr.android.OpenLibraActivity;
import es.ffgiraldez.hmr.android.R;

public class RecentActivity extends OpenLibraActivity {
    // ----------------------------------
    // ATTRIBUTES
    // ----------------------------------
    private Injector injector;

    // ----------------------------------
    // LIFE CIRCLE
    // ----------------------------------
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recent_activity);
    }
}
