package es.ffgiraldez.hmr.android.executors;

import com.octo.android.robospice.SpiceManager;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import es.ffgiraldez.hmr.executors.Executor;
/**
 * @author Fernando Franco Girádez
 */
@Module(
        library = true
)
public class ExecutorModule {
    // ----------------------------------
    // PUBLIC API
    // ----------------------------------
    @Provides
    @Singleton
    public SpiceManager providesSpiceManager() {
        return new SpiceManager(BookService.class);
    }

    @Provides
    public Executor providesSpiceExecutor(final SpiceManager manager) {
        return new SpiceExecutor(manager);
    }

}
