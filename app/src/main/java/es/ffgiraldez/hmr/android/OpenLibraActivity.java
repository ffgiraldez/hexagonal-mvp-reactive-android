package es.ffgiraldez.hmr.android;

import com.octo.android.robospice.SpiceManager;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;

import javax.inject.Inject;

import es.ffgiraldez.hmr.Injector;
import es.ffgiraldez.hmr.Modules;
/**
 * @author Fernando Franco Giráldez
 */
public abstract class OpenLibraActivity extends ActionBarActivity implements Injector{
    // ----------------------------------
    // ATTRIBUTES
    // ----------------------------------
    private Injector injector;
    @Inject
    SpiceManager manager;

    // ----------------------------------
    // LIFE CYCLE
    // ----------------------------------
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        injector = ((Injector) getApplication()).plus(Modules.activity(this));
        inject(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        manager.start(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (manager.isStarted()) {
            manager.shouldStop();
        }
    }

    // ----------------------------------
    // INTERFACES IMPL
    // ----------------------------------
    @Override
    public Injector plus(Object[] modules) {
        return injector.plus(modules);
    }

    @Override
    public void inject(Object toInject) {
        injector.inject(toInject);
    }
}
