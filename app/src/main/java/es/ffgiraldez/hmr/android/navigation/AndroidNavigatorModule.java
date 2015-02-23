package es.ffgiraldez.hmr.android.navigation;

import android.app.Activity;

import dagger.Module;
import dagger.Provides;
import es.ffgiraldez.hmr.navigation.Navigator;

/**
 * @author Fernando Franco Girádez
 */
@Module(
        library = true,
        complete = false
)
public class AndroidNavigatorModule {
    // ----------------------------------
    // PUBLIC API
    // ----------------------------------
    @Provides
    public Navigator providesNavigator(final ActivityHandlerSelector selector) {
        return new Navigator(selector);
    }

    @Provides
    public ActivityHandlerSelector providesActivitySelector(final Activity activity) {
        return new ActivityHandlerSelector(activity);
    }
}
