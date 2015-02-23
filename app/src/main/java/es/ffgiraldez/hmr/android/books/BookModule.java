package es.ffgiraldez.hmr.android.books;

import com.google.gson.Gson;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import es.ffgiraldez.hmr.books.BookClient;
import es.ffgiraldez.hmr.rest.Endpoint;
import es.ffgiraldez.hmr.rest.OpenLibraGsonConverter;
import retrofit.RestAdapter;
/**
 * @author Fernando Franco Giráldez
 */
@Module(
        library = true
)
public class BookModule {
    // ----------------------------------
    // PUBLIC API
    // ----------------------------------
    @Provides
    @Singleton
    public Endpoint providesEnpoint() {
        return new RestAdapter.Builder()
                .setEndpoint("http://www.etnassoft.com/api/v1")
                .setConverter(new OpenLibraGsonConverter(new Gson())).build().create(Endpoint.class);
    }

    @Provides
    public BookClient providesClient(final Endpoint endpoint) {
        return new BookClient(endpoint);
    }
}
