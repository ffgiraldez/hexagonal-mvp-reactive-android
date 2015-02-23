package es.ffgiraldez.hmr.details;

import es.ffgiraldez.hmr.navigation.Navigation;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Accessors;
/**
 * @author Fernando Franco Giráldez
 */
@RequiredArgsConstructor
@Getter
@Accessors(fluent = true)
public class DetailsNavigation implements Navigation {
    // ----------------------------------
    // ATTRIBUTES
    // ----------------------------------
    private final String identifier;
}