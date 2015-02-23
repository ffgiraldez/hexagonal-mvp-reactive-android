package es.ffgiraldez.hmr;

/**
 * @author Fernando Franco Giráldez
 */
public interface Injector {
    // ----------------------------------
    // PUBLIC API
    // ----------------------------------
    Injector plus(Object[] modules);

    void inject(Object toInject);
}
