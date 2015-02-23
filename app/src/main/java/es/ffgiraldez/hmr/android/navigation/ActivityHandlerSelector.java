package es.ffgiraldez.hmr.android.navigation;

import android.app.Activity;

import java.util.Arrays;

import es.ffgiraldez.hmr.android.details.ui.DetailsNavigationHandler;
import es.ffgiraldez.hmr.navigation.NavigatorHandlerSelector;
/**
 * @author Fernando Franco Girádez
 */
public class ActivityHandlerSelector extends NavigatorHandlerSelector {
    // ----------------------------------
    // CONSTRUCTOR
    // ----------------------------------
    public ActivityHandlerSelector(Activity activity) {
        super(Arrays.asList(
            new DetailsNavigationHandler(activity)
        ));
    }
}
