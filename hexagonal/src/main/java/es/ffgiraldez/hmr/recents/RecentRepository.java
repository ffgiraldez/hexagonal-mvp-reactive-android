package es.ffgiraldez.hmr.recents;

/**
 * @author Fernando Franco Giráldez
 */
public interface RecentRepository {
    // ----------------------------------
    // PUBLIC API
    // ----------------------------------
    RecentBooks retrieve();
    void save(RecentBooks books);
}
