package es.ffgiraldez.hmr.android;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import es.ffgiraldez.hmr.android.schedulers.AndroidSchedulerProvider;
import es.ffgiraldez.hmr.schedulers.SchedulerProvider;
/**
 * @author Fernando Franco Giráldez
 */
@Module(
        library = true
)
public class ApplicationModule {
    // ----------------------------------
    // ATTRIBUTES
    // ----------------------------------
    private final Context ctx;

    // ----------------------------------
    // CONSTRUCTOR
    // ----------------------------------
    public ApplicationModule(Context ctx) {
        this.ctx = ctx;
    }

    // ----------------------------------
    // PUBLIC API
    // ----------------------------------
    @Provides
    public Context providesContext() {
        return  ctx;
    }

    @Provides
    @Singleton
    public SchedulerProvider providesScheduler() {
        return new AndroidSchedulerProvider();
    }
}
