package es.ffgiraldez.hmr.android.recents;

import dagger.Module;
import dagger.Provides;
import es.ffgiraldez.hmr.android.books.BookModule;
import es.ffgiraldez.hmr.android.executors.ExecutorModule;
import es.ffgiraldez.hmr.android.recents.ui.RecentActivity;
import es.ffgiraldez.hmr.android.recents.ui.RecentFragment;
import es.ffgiraldez.hmr.books.BookClient;
import es.ffgiraldez.hmr.executors.Executor;
import es.ffgiraldez.hmr.navigation.Navigator;
import es.ffgiraldez.hmr.recents.RecentInteractor;
import es.ffgiraldez.hmr.recents.RecentPresenter;
/**
 * @author Fernando Franco Giráldez
 */
@Module(
        includes = {
                BookModule.class,
                ExecutorModule.class,
        },
        complete = false,
        injects = {
            RecentActivity.class,
            RecentFragment.class
        }
)
public class RecentModule {

    // ----------------------------------
    // PUBLIC API
    // ----------------------------------
    @Provides
    public RecentPresenter providesPresenter(final RecentInteractor interactor, final Navigator navigator) {
        return new RecentPresenter(interactor, navigator);
    }

    @Provides
    public RecentInteractor providesInteractor(final Executor executor, final BookClient client) {
        return new RecentInteractor(executor, client);
    }
}
