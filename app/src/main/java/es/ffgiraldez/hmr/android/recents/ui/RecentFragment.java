package es.ffgiraldez.hmr.android.recents.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import javax.inject.Inject;

import butterknife.InjectView;
import es.ffgiraldez.hmr.android.OpenLibraFragment;
import es.ffgiraldez.hmr.android.R;
import es.ffgiraldez.hmr.recents.RecentPresenter;
import es.ffgiraldez.hmr.recents.RecentUserInterface;
/**
 * @author Fernando Franco Giráldez
 */
public class RecentFragment extends OpenLibraFragment {
    // ----------------------------------
    // ATTRIBUTES
    // ----------------------------------
    @InjectView(R.id.recent_ui)
    RecentUserInterface ui;
    @Inject
    RecentPresenter presenter;

    // ----------------------------------
    // LIFE CYCLE
    // ----------------------------------
    @Override
    public View onCreateView(
            LayoutInflater inflater,
            @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState
    ){
        return inflater.inflate(R.layout.some_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ui.initialize();
        presenter.initialize(ui);
    }

    @Override
    public void onStart() {
        super.onStart();
        presenter.load();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        presenter.reset();
    }
}
