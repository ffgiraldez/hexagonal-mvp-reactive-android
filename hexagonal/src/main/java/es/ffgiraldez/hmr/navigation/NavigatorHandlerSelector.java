package es.ffgiraldez.hmr.navigation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * @author Fernando Franco Girádez
 */
public class NavigatorHandlerSelector {
    // ----------------------------------
    // ATTRIBUTES
    // ----------------------------------
    private final Map<Class<? extends Navigation>, NavigatorHandler> map;

    // ----------------------------------
    // CONSTRUCTOR
    // ----------------------------------
    protected NavigatorHandlerSelector(List<AbstractNavigatorHandler<? extends  Navigation>> handlers) {
        if (handlers == null) {
            handlers = new ArrayList<>();
        }
        map = new HashMap<>();
        for (AbstractNavigatorHandler<? extends  Navigation> handler : handlers) {
            map.put(handler.handlerClass(), handler);
        }
    }

    // ----------------------------------
    // PUBLIC API
    // ----------------------------------
    public NavigatorHandler from(Class<? extends Navigation> clazz) {
        NavigatorHandler handler = map.get(clazz);
        if (handler != null) {
            return handler;
        }
        return new IgnoredNavigatorHandler();
    }

    // ----------------------------------
    // PRIVATE API
    // ----------------------------------
    private static class IgnoredNavigatorHandler implements NavigatorHandler {
        @Override
        public void handle(Navigation navigation) {

        }
    }
}
