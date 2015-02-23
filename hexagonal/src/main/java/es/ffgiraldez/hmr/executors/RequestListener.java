package es.ffgiraldez.hmr.executors;

/**
 * @author Fernando Franco Girádez
 */
public interface RequestListener<T> {
    // ----------------------------------
    // PUBLIC API
    // ----------------------------------
    void onSuccess(T result);
    void onFailure(RequestException exception);
}
