package es.ffgiraldez.hmr.executors;

import rx.Observable;
/**
 * @author Fernando Franco Girádez
 */
public interface Executor {
    // ----------------------------------
    // PUBLIC API
    // ----------------------------------
    <T> Observable<T> execute(Class<T> clazz, Request<T> request, From from);
}
