package es.ffgiraldez.hmr.android.persistence;

/**
 * @author Fernando Franco Girádez
 */
public class Persistence {
    // ----------------------------------
    // CONSTANTS
    // ----------------------------------
    public static final int DATABASE_VERSION = 1;

    // ----------------------------------
    // CONSTRUCTOR
    // ----------------------------------
    private Persistence() {}

    // ----------------------------------
    // INNER CLASSES & INTERFACES
    // ----------------------------------
    public static final class Books {
        public static class Columns {
            public static final String IDENTIFIER = "identifier";
            public static final String TITLE = "title";
            public static final String COVER= "cover";
            public static final String DESCRIPTION= "description";
            public static final String SAVED = "saved";

        }
    }
}
