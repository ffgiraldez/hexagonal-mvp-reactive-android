package es.ffgiraldez.hmr.recents;

import lombok.RequiredArgsConstructor;
import rx.Observable;
import rx.schedulers.Schedulers;
/**
 * @author Fernando Franco Giráldez
 */
@RequiredArgsConstructor
public class RecentInteractor {
    // ----------------------------------
    // ATTRIBUTES
    // ----------------------------------
    private final RecentDataSource dataSource;

    // ----------------------------------
    // PUBLIC API
    // ----------------------------------
    public Observable<RecentBooks> recent() {
        return dataSource.retrieve().subscribeOn(Schedulers.io());
    }
}
