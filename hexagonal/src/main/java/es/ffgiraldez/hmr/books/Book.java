package es.ffgiraldez.hmr.books;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import lombok.experimental.Builder;
/**
 * @author Fernando Franco Giráldez
 */
@Getter
@Accessors(fluent = true)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
public class Book {
    // ----------------------------------
    // ATTRIBUTES
    // ----------------------------------
    private String identifier;
    private String title;
    private String cover;
    private String description;
    private boolean saved;

    // ----------------------------------
    // CONSTRUCTOR
    // ----------------------------------
    @Builder
    Book(String identifier, String title, String cover, String description, boolean saved) {
        this.identifier = identifier;
        this.title = title;
        this.cover = cover;
        this.description = description;
        this.saved = saved;
    }
}
