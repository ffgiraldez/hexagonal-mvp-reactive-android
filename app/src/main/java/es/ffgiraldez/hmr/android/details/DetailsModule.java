package es.ffgiraldez.hmr.android.details;

import dagger.Module;
import es.ffgiraldez.hmr.android.books.BookModule;
import es.ffgiraldez.hmr.android.details.ui.DetailsActivity;
import es.ffgiraldez.hmr.android.details.ui.DetailsFragment;
/**
 * @author Fernando Franco Giráldez
 */
@Module(
        includes = {
            BookModule.class
        },
        complete = false,
        library = true,
        injects = {
                DetailsActivity.class,
                DetailsFragment.class
        }
)
public class DetailsModule {
}
