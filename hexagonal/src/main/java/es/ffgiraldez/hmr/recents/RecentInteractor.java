package es.ffgiraldez.hmr.recents;

import es.ffgiraldez.hmr.books.BookClient;
import es.ffgiraldez.hmr.executors.Executor;
import es.ffgiraldez.hmr.executors.From;
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
    private final Executor executor;
    private final BookClient client;

    // ----------------------------------
    // PUBLIC API
    // ----------------------------------
    public Observable<RecentBooks> recent() {
        return executor.execute(RecentBooks.class, new RecentRequest(client), From.BOTH);
    }
}
