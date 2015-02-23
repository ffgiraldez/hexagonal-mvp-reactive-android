package es.ffgiraldez.hmr.android.executors;

import com.octo.android.robospice.persistence.exception.SpiceException;
import com.octo.android.robospice.request.listener.RequestListener;

import es.ffgiraldez.hmr.executors.RequestException;
import lombok.RequiredArgsConstructor;
/**
 * @author Fernando Franco Girádez
 */
@RequiredArgsConstructor
class RequestListenerWrapper<T> implements RequestListener<T> {
    // ----------------------------------
    // ATTRIBUTES
    // ----------------------------------
    private final es.ffgiraldez.hmr.executors.RequestListener<T> listener;

    // ----------------------------------
    // INTERFACES IMPL
    // ----------------------------------
    @Override
    public void onRequestFailure(SpiceException spiceException) {
        listener.onFailure(new RequestException(spiceException.getCause()));
    }

    @Override
    public void onRequestSuccess(T result) {
        listener.onSuccess(result);
    }
}
