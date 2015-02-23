package es.ffgiraldez.hmr.android.persistence;

import com.octo.android.robospice.persistence.ObjectPersister;
import com.octo.android.robospice.persistence.exception.CacheLoadingException;

import java.util.List;

import es.ffgiraldez.hmr.android.OpenLibraApplication;
/**
 * @author Fernando Franco Giráldez
 */
public abstract class OpenlibraPersister<T> extends ObjectPersister<T> {
    // ----------------------------------
    // CONSTRUCTOR
    // ----------------------------------
    public OpenlibraPersister(OpenLibraApplication application, Class<T> clazz) {
        super(application, clazz);
        application.inject(this);
    }

    // ----------------------------------
    // OVERRIDES
    // ----------------------------------
    @Override
    public List<T> loadAllDataFromCache() throws CacheLoadingException {
        return null;
    }

    @Override
    public List<Object> getAllCacheKeys() {
        return null;
    }

    @Override
    public boolean removeDataFromCache(Object cacheKey) {
        return false;
    }

    @Override
    public void removeAllDataFromCache() {

    }

    @Override
    public long getCreationDateInCache(Object cacheKey) throws CacheLoadingException {
        return 0;
    }

    @Override
    public boolean isDataInCache(Object cacheKey, long maxTimeInCacheBeforeExpiry) {
        return false;
    }
}
