package es.ffgiraldez.hmr.android;

import android.app.Activity;

import dagger.Module;
import dagger.Provides;
/**
 * @author Fernando Franco Giráldez
 */
@Module(
        library = true
)
public class ActivityModule {
    // ----------------------------------
    // ATTRIBUTES
    // ----------------------------------
    private final OpenLibraActivity activity;

    // ----------------------------------
    // CONSTRUCTOR
    // ----------------------------------
    public ActivityModule(OpenLibraActivity activity) {
        this.activity = activity;
    }

    // ----------------------------------
    // PUBLIC API
    // ----------------------------------
    @Provides
    public Activity providesActivity() {
        return activity;
    }
}
