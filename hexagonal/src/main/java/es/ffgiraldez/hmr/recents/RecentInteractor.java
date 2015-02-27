package es.ffgiraldez.hmr.recents;

import es.ffgiraldez.hmr.schedulers.SchedulerProvider;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import rx.Observable;
/**
 * @author Fernando Franco Giráldez
 */
@RequiredArgsConstructor
public class RecentInteractor {
    // ----------------------------------
    // ATTRIBUTES
    // ----------------------------------
    @NonNull
    private final RecentDataSource dataSource;
    private final SchedulerProvider schedulers;

    // ----------------------------------
    // PUBLIC API
    // ----------------------------------
    public Observable<RecentBooks> recent() {
        return dataSource.retrieve().cache().subscribeOn(schedulers.io());
    }
}
