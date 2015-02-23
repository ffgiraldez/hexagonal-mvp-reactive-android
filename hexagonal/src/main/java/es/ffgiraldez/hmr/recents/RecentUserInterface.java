package es.ffgiraldez.hmr.recents;

import rx.Observable;
/**
 * @author Fernando Franco Giráldez
 */
public interface RecentUserInterface {
    // ----------------------------------
    // PUBLIC API
    // ----------------------------------
    void initialize();

    void show(RecentBooks books);

    Observable<String> onBookClick();

}
