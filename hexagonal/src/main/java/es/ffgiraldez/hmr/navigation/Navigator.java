package es.ffgiraldez.hmr.navigation;

import lombok.RequiredArgsConstructor;
/**
 * @author Fernando Franco Girádez
 */
@RequiredArgsConstructor
public class Navigator {
    // ----------------------------------
    // ATTRIBUTES
    // ----------------------------------
    private final NavigatorHandlerSelector selector;

    // ----------------------------------
    // PUBLIC API
    // ----------------------------------
    public void to(Navigation navigation) {
        NavigatorHandler handler = selector.from(navigation.getClass());
        handler.handle(navigation);
    }
}
