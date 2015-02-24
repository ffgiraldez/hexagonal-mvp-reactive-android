package es.ffgiraldez.hmr.android.recents;

import dagger.Module;
import dagger.Provides;
import es.ffgiraldez.hmr.android.books.BookModule;
import es.ffgiraldez.hmr.android.recents.ui.RecentActivity;
import es.ffgiraldez.hmr.android.recents.ui.RecentFragment;
import es.ffgiraldez.hmr.books.BookClient;
import es.ffgiraldez.hmr.navigation.Navigator;
import es.ffgiraldez.hmr.recents.RecentDataSource;
import es.ffgiraldez.hmr.recents.RecentInteractor;
import es.ffgiraldez.hmr.recents.RecentPresenter;
import es.ffgiraldez.hmr.recents.RecentRepository;
import rx.android.schedulers.AndroidSchedulers;
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
    public RecentPresenter providesPresenter(final RecentInteractor interactor, final Navigator navigator) {
        return new RecentPresenter(interactor, navigator, AndroidSchedulers.mainThread());
    }

    @Provides
    public RecentInteractor providesInteractor(final RecentDataSource dataSource) {
        return new RecentInteractor(dataSource);
    }

    @Provides RecentDataSource providesRecentDataSource(final RecentRepository repo, final BookClient client) {
        return new RecentDataSource(repo, client);
    }
}
