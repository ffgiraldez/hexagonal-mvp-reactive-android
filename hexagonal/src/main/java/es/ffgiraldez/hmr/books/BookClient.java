package es.ffgiraldez.hmr.books;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

import es.ffgiraldez.hmr.recents.RecentBooks;
import es.ffgiraldez.hmr.rest.Endpoint;
import lombok.RequiredArgsConstructor;
import rx.Observable;
/**
 * @author Fernando Franco Giráldez
 */
@RequiredArgsConstructor
public class BookClient {
    // ----------------------------------
    // ATTRIBUTES
    // ----------------------------------
    private final Endpoint endpoint;

    // ----------------------------------
    // PUBLIC API
    // ----------------------------------
    public RecentBooks recent() {
        AtomicReference<List<Book>> reference = new AtomicReference<>();
        Observable.from(endpoint.recent())
                .map(response ->
                                Book.builder()
                                        .identifier(response.identifier())
                                        .title(response.title())
                                        .cover(response.cover())
                                        .description(response.description())
                                        .build()
                ).toList()
                .subscribe(reference::set);
        return new RecentBooks(reference.get());
    }
}
