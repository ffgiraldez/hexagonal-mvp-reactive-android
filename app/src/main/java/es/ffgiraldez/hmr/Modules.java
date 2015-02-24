package es.ffgiraldez.hmr;

import es.ffgiraldez.hmr.android.ActivityModule;
import es.ffgiraldez.hmr.android.ApplicationModule;
import es.ffgiraldez.hmr.android.OpenLibraActivity;
import es.ffgiraldez.hmr.android.OpenLibraApplication;
import es.ffgiraldez.hmr.android.books.BookModule;
import es.ffgiraldez.hmr.android.details.DetailsModule;
import es.ffgiraldez.hmr.android.navigation.AndroidNavigatorModule;
import es.ffgiraldez.hmr.android.persistence.PersistenceModule;
import es.ffgiraldez.hmr.android.recents.RecentModule;
/**
 * @author Fernando Franco Giráldez
 */
public class Modules {
    private Modules() {

    }
    // ----------------------------------
    // PUBLIC API
    // ----------------------------------
    public static Object[] app(OpenLibraApplication app) {
        return new Object[]{
            new BookModule(),
            new ApplicationModule(app),
            new PersistenceModule()
        };
    }

    public static Object[] activity(OpenLibraActivity activity) {
        return new Object[] {
            new ActivityModule(activity),
            new RecentModule(),
            new AndroidNavigatorModule(),
            new DetailsModule()
        };
    }
}
