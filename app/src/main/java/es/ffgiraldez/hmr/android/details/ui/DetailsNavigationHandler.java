package es.ffgiraldez.hmr.android.details.ui;

import android.app.Activity;
import android.content.Intent;

import es.ffgiraldez.hmr.details.DetailsNavigation;
import es.ffgiraldez.hmr.navigation.AbstractNavigatorHandler;
import es.ffgiraldez.hmr.navigation.Navigation;
/**
 * @author Fernando Franco Giráldez
 */
public class DetailsNavigationHandler extends AbstractNavigatorHandler<DetailsNavigation> {
    // ----------------------------------
    // ATTRIBUTES
    // ----------------------------------
    private final Activity activity;

    // ----------------------------------
    // CONSTRUCTOR
    // ----------------------------------
    public DetailsNavigationHandler(Activity activity) {
        super(DetailsNavigation.class);
        this.activity = activity;
    }

    // ----------------------------------
    // OVERRIDES
    // ----------------------------------
    @Override
    public void open(DetailsNavigation navigation) {
        Intent intent = new Intent(activity, DetailsActivity.class);
        intent.putExtra(Navigation.EXTRA_BOOK_ID, navigation.identifier());
        activity.startActivity(intent);
    }
}
