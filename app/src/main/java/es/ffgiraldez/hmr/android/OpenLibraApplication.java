package es.ffgiraldez.hmr.android;

import android.app.Application;

import dagger.ObjectGraph;
import es.ffgiraldez.hmr.GraphInjector;
import es.ffgiraldez.hmr.Injector;
import es.ffgiraldez.hmr.Modules;
/**
 * @author Fernando Franco Giráldez
 */
public class OpenLibraApplication extends Application implements Injector {
    // ----------------------------------
    // ATTRIBUTES
    // ----------------------------------
    private GraphInjector injector;

    // ----------------------------------
    // OVERRIDES
    // ----------------------------------
    @Override
    public void onCreate() {
        super.onCreate();
        injector = new GraphInjector(ObjectGraph.create(Modules.app(this)));
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
