package es.ffgiraldez.hmr.android.persistence;

import com.octo.android.robospice.persistence.exception.CacheLoadingException;
import com.octo.android.robospice.persistence.exception.CacheSavingException;

import javax.inject.Inject;

import es.ffgiraldez.hmr.android.OpenLibraApplication;
import es.ffgiraldez.hmr.recents.RecentBooks;
import es.ffgiraldez.hmr.recents.RecentRepository;
/**
 * @author Fernando Franco Giráldez
 */
public class RecentObjectPersister extends OpenlibraPersister<RecentBooks> {
    // ----------------------------------
    // ATTRIBUTES
    // ----------------------------------
    @Inject
    RecentRepository repo;

    // ----------------------------------
    // CONSTRUCTOR
    // ----------------------------------
    public RecentObjectPersister(OpenLibraApplication application) {
        super(application, RecentBooks.class);
    }

    // ----------------------------------
    // OVERRIDES
    // ----------------------------------
    @Override
    public RecentBooks loadDataFromCache(Object cacheKey, long maxTimeInCache) throws CacheLoadingException {
        RecentBooks recentBooks = repo.retrieve();
        return !recentBooks.isEmpty() ? recentBooks : null;
    }

    @Override
    public RecentBooks saveDataToCacheAndReturnData(RecentBooks data, Object cacheKey) throws CacheSavingException {
        repo.save(data);
        return repo.retrieve();
    }
}
