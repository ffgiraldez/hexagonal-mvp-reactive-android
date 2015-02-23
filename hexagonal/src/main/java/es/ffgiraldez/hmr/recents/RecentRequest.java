package es.ffgiraldez.hmr.recents;

import es.ffgiraldez.hmr.books.BookClient;
import es.ffgiraldez.hmr.executors.Request;
import lombok.RequiredArgsConstructor;
/**
 * @author Fernando Franco Giráldez
 */
@RequiredArgsConstructor
public class RecentRequest implements Request<RecentBooks> {
    // ----------------------------------
    // ATTRIBUTES
    // ----------------------------------
    private final BookClient client;

    // ----------------------------------
    // INTERFACES IMPL
    // ----------------------------------
    @Override
    public RecentBooks run() {
        return client.recent();
    }
}
