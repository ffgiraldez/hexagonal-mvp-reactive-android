package es.ffgiraldez.hmr.executors;

/**
 * @author Fernando Franco Girádez
 */
public interface Request<T> {
    // ----------------------------------
    // PUBLIC API
    // ----------------------------------
    T run();
}
