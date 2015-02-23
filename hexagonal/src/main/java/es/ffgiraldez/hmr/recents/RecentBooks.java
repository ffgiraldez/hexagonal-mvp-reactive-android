package es.ffgiraldez.hmr.recents;

import java.util.AbstractList;
import java.util.List;

import es.ffgiraldez.hmr.books.Book;
import lombok.RequiredArgsConstructor;
/**
 * @author Fernando Franco Giráldez
 */
@RequiredArgsConstructor
public class RecentBooks  extends AbstractList<Book>{
    // ----------------------------------
    // ATTRIBUTES
    // ----------------------------------
    private final List<Book> list;

    // ----------------------------------
    // PUBLIC API
    // ----------------------------------
    public Book get(int location) {
        return list.get(location);
    }

    public int size() {
        return list.size();
    }
}
