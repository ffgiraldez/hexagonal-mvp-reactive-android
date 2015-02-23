package es.ffgiraldez.hmr.android.details.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import es.ffgiraldez.hmr.android.OpenLibraFragment;
import es.ffgiraldez.hmr.android.R;
/**
 * @author Fernando Franco Giráldez
 */
public class DetailsFragment extends OpenLibraFragment {
    // ----------------------------------
    // LIFE CYCLE
    // ----------------------------------
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.details_fragment, container, false);
    }
}
