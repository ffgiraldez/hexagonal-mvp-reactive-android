package es.ffgiraldez.hmr;

import dagger.ObjectGraph;
import lombok.RequiredArgsConstructor;
/**
 * @author Fernando Franco Giráldez
 */
@RequiredArgsConstructor
public class GraphInjector implements Injector {
    // ----------------------------------
    // ATTRIBUTES
    // ----------------------------------
    private final ObjectGraph graph;

    // ----------------------------------
    // INTERFACES IMPL
    // ----------------------------------
    @Override
    public Injector plus(Object[] modules) {
        return new GraphInjector(graph.plus(modules));
    }

    @Override
    public void inject(Object toInject) {
        graph.inject(toInject);
    }
}
