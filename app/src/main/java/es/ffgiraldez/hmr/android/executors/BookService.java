package es.ffgiraldez.hmr.android.executors;

import com.octo.android.robospice.SpiceService;
import com.octo.android.robospice.persistence.CacheManager;
import com.octo.android.robospice.persistence.exception.CacheCreationException;

import android.app.Application;

import es.ffgiraldez.hmr.android.OpenLibraApplication;
import es.ffgiraldez.hmr.android.persistence.RecentObjectPersister;
/**
 * @author Fernando Franco Giráldez
 */
public class BookService extends SpiceService {
    // ----------------------------------
    // OVERRIDES
    // ----------------------------------
    @Override
    public CacheManager createCacheManager(Application application) throws CacheCreationException {
        CacheManager manager = new CacheManager();
        manager.addPersister(new RecentObjectPersister((OpenLibraApplication) application));
        return manager;
    }
}
