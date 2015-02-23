package es.ffgiraldez.hmr.android;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;

import butterknife.ButterKnife;
import es.ffgiraldez.hmr.Injector;
/**
 * @author Fernando Franco Giráldez
 */
public class OpenLibraFragment extends Fragment {
    // ----------------------------------
    // LIFE CYCLE
    // ----------------------------------
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        ButterKnife.inject(this, view);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        getInjector().inject(this);
    }

    // ----------------------------------
    // PUBLIC API
    // ----------------------------------
    public Injector getInjector() {
        return (Injector) getActivity();
    }
}
