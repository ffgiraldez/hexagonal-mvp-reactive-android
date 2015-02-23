package es.ffgiraldez.hmr.android;

import android.content.Context;

import dagger.Module;
import dagger.Provides;
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
}
