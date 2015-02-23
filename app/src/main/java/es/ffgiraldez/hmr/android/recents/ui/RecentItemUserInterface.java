package es.ffgiraldez.hmr.android.recents.ui;

import es.ffgiraldez.hmr.books.Book;
/**
 * @author Fernando Franco Giráldez
 */
public interface RecentItemUserInterface {
    // ----------------------------------
    // PUBLIC API
    // ----------------------------------
    void bind(Book book);
    String identifier();

}
