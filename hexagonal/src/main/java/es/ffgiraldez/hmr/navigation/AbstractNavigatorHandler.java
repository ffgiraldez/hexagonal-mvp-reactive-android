package es.ffgiraldez.hmr.navigation;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
/**
 * @author Fernando Franco Girádez
 */
@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
public abstract class AbstractNavigatorHandler<T extends Navigation> implements NavigatorHandler {
    // ----------------------------------
    // ATTRIBUTES
    // ----------------------------------
    private final Class<T> clazz;

    // ----------------------------------
    // PUBLIC API
    // ----------------------------------
    @Override
    @SuppressWarnings("unchecked")
    public void handle(Navigation navigation) {
        if (!clazz.equals(navigation.getClass())) {
            return;
        }
        open((T) navigation);
    }

    Class<T> handlerClass() {
        return clazz;
    }

    protected abstract void open(T navigation);
}
