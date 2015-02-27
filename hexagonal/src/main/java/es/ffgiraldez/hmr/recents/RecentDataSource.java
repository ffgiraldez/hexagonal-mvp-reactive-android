package es.ffgiraldez.hmr.recents;

import es.ffgiraldez.hmr.books.BookClient;
import lombok.RequiredArgsConstructor;
import rx.Observable;
import rx.operators.OperatorIfThen;
/**
 * @author Fernando Franco Giráldez
 */
@RequiredArgsConstructor
public class RecentDataSource {
    // ----------------------------------
    // ATTRIBUTES
    // ----------------------------------
    private final RecentRepository repo;
    private final BookClient client;
    private Observable<RecentBooks> retrieveObservable = createRecentObservable();

    // ----------------------------------
    // PUBLIC API
    // ----------------------------------
    public Observable<RecentBooks> retrieve() {
        return retrieveObservable;
    }

    // ----------------------------------
    // PRIVATE API
    // ----------------------------------
    private Observable<RecentBooks> createRecentObservable() {
        Observable<RecentBooks> db = Observable.create(subscriber -> {
            subscriber.onNext(repo.retrieve());
            subscriber.onCompleted();
        });
        Observable<RecentBooks> net = Observable.create(subscriber -> {
            subscriber.onNext(client.recent());
            subscriber.onCompleted();
        });
        Observable<RecentBooks> cached = net.flatMap(books -> {
            repo.save(books);
            return db;
        });

        return Observable.create(
                new OperatorIfThen<>(() -> !repo.retrieve().isEmpty(), db, cached)
        );
    }
}
