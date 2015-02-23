package es.ffgiraldez.hmr.android.persistence;

import com.j256.ormlite.dao.RuntimeExceptionDao;

import es.ffgiraldez.hmr.books.Book;
import es.ffgiraldez.hmr.recents.RecentBooks;
import es.ffgiraldez.hmr.recents.RecentRepository;
import lombok.RequiredArgsConstructor;
import rx.Observable;
/**
 * @author Fernando Franco Giráldez
 */
@RequiredArgsConstructor
public class OrmRecentRepository implements RecentRepository {
    // ----------------------------------
    // ATTRIBUTES
    // ----------------------------------
    private final RuntimeExceptionDao<Book, String> dao;

    // ----------------------------------
    // INTERFACES IMPL
    // ----------------------------------
    @Override
    public RecentBooks retrieve() {
        return new RecentBooks(dao.queryForAll());
    }

    @Override
    public void save(RecentBooks books) {
        Observable.from(books)
                .filter(book -> dao.queryForId(book.identifier()) == null)
                .subscribe(dao::create);
    }
}
