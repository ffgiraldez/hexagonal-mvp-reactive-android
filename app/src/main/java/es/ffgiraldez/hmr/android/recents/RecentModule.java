package es.ffgiraldez.hmr.android.recents;

import dagger.Module;
import dagger.Provides;
import es.ffgiraldez.hmr.android.books.BookModule;
import es.ffgiraldez.hmr.android.recents.ui.RecentActivity;
import es.ffgiraldez.hmr.android.recents.ui.RecentFragment;
import es.ffgiraldez.hmr.navigation.Navigator;
import es.ffgiraldez.hmr.recents.RecentDataSource;
import es.ffgiraldez.hmr.recents.RecentInteractor;
import es.ffgiraldez.hmr.recents.RecentPresenter;
import es.ffgiraldez.hmr.schedulers.SchedulerProvider;
/**
 * @author Fernando Franco Giráldez
 */
@Module(
        includes = {
                BookModule.class
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
    public RecentPresenter providesPresenter(final RecentInteractor interactor, final Navigator navigator, final SchedulerProvider schedulers) {
        return new RecentPresenter(interactor, navigator, schedulers);
    }

    @Provides
    public RecentInteractor providesInteractor(final RecentDataSource dataSource, final SchedulerProvider schedulers) {
        return new RecentInteractor(dataSource, schedulers);
    }


}
