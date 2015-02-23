package es.ffgiraldez.hmr.android.executors;

import com.octo.android.robospice.request.SpiceRequest;
import com.octo.android.robospice.retry.DefaultRetryPolicy;

import es.ffgiraldez.hmr.executors.Request;
/**
 * @author Fernando Franco Girádez
 */
class SpiceRequestWrapper<T> extends SpiceRequest<T> {
    // ----------------------------------
    // ATTRIBUTES
    // ----------------------------------
    private final Request<T> request;

    // ----------------------------------
    // CONSTRUCTOR
    // ----------------------------------
    public SpiceRequestWrapper(Class<T> clazz, Request<T> request) {
        super(clazz);
        this.request = request;
        setRetryPolicy(new DefaultRetryPolicy(0, DefaultRetryPolicy.DEFAULT_DELAY_BEFORE_RETRY, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
    }

    // ----------------------------------
    // OVERRIDES
    // ----------------------------------
    @Override
    public T loadDataFromNetwork() throws Exception {
        return request.run();
    }
}
