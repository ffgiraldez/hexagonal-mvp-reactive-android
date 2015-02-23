package es.ffgiraldez.hmr.android.executors;

import com.octo.android.robospice.SpiceManager;
import com.octo.android.robospice.persistence.DurationInMillis;
import com.octo.android.robospice.request.CachedSpiceRequest;

import java.util.HashMap;
import java.util.Map;

import es.ffgiraldez.hmr.executors.Executor;
import es.ffgiraldez.hmr.executors.From;
import es.ffgiraldez.hmr.executors.ObserverRequestListener;
import es.ffgiraldez.hmr.executors.Request;
import rx.Observable;
import rx.subjects.PublishSubject;
/**
 * @author Fernando Franco Girádez
 */
public class SpiceExecutor implements Executor {
    // ----------------------------------
    // ATTRIBUTES
    // ----------------------------------
    private final SpiceManager manager;
    private final Map<From, Long> fromSelector = new HashMap<>();

    // ----------------------------------
    // CONSTRUCTOR
    // ----------------------------------
    public SpiceExecutor(SpiceManager manager) {
        this.manager = manager;
        fromSelector.put(From.INTERNET, DurationInMillis.ALWAYS_EXPIRED);
        fromSelector.put(From.CACHE, DurationInMillis.ALWAYS_RETURNED);
        fromSelector.put(From.BOTH, DurationInMillis.ONE_HOUR);
    }

    // ----------------------------------
    // INTERFACES IMPL
    // ----------------------------------
    @Override
    public <T> Observable<T> execute(Class<T> clazz, Request<T> request, From from) {
        PublishSubject<T> subject = PublishSubject.create();
        final CachedSpiceRequest<T> cachedSpiceRequest = new CachedSpiceRequest<>(
                new SpiceRequestWrapper<>(clazz, request), request.getClass(), fromSelector.get(from)
        );
        if (From.BOTH.equals(from)) {
            cachedSpiceRequest.setAcceptingDirtyCache(true);
        }
        manager.execute(cachedSpiceRequest, new RequestListenerWrapper<T>(new ObserverRequestListener<>(subject)));
        return subject.asObservable();
    }
}
