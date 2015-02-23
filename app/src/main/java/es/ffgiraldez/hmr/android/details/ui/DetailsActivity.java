package es.ffgiraldez.hmr.android.details.ui;

import android.os.Bundle;

import es.ffgiraldez.hmr.android.OpenLibraActivity;
import es.ffgiraldez.hmr.android.R;
/**
 * @author Fernando Franco Giráldez
 */
public class DetailsActivity extends OpenLibraActivity {
    // ----------------------------------
    // LIFE CYCLE
    // ----------------------------------
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.details_activity);
    }
}
