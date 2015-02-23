package es.ffgiraldez.hmr.rest;
import com.google.gson.Gson;

import com.github.restdriver.clientdriver.ClientDriverRequest;
import com.github.restdriver.clientdriver.ClientDriverRule;
import com.github.restdriver.clientdriver.RestClientDriver;

import org.assertj.core.api.Condition;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

import retrofit.RestAdapter;

import static org.assertj.core.api.Assertions.assertThat;
/**
 * @author Fernando Franco Giráldez
 */
public class EndpointTest {
    // ----------------------------------
    // ATTRIBUTES
    // ----------------------------------
    private Endpoint api;
    @Rule
    public ClientDriverRule driver = new ClientDriverRule();

    // ----------------------------------
    // CONFIGURATION
    // ----------------------------------
    @Before
    public void setup() throws Exception{
        RestAdapter adapter = new RestAdapter.Builder()
                .setEndpoint(driver.getBaseUrl())
                .setConverter(new OpenLibraGsonConverter(new Gson()))
                .build();
        api = adapter.create(Endpoint.class);
    }

    // ----------------------------------
    // TESTS
    // ----------------------------------
    @Test
    public void testRecentBooks() throws Exception{
        //given
        InputStream in = getClass().getResourceAsStream("/last_week.json");
        driver.addExpectation(
                RestClientDriver.onRequestTo("/get/")
                        .withMethod(ClientDriverRequest.Method.GET)
                        .withAnyParams(),
                RestClientDriver.giveResponseAsBytes(in,"text/plain").withStatus(200)
        );

        //when
        List<BookResponse> books = api.recent();

        //then
        assertThat(books).isNotNull()
                .hasSize(10);
        BookResponse book = books.get(0);

        assertThat(book).isNotNull().is(new Condition<BookResponse>() {
            @Override
            public boolean matches(BookResponse value) {
                return value.author().length() > 0 &&
                        value.title().length() > 0 &&
                        value.categories().size() > 0;

            }
        });
    }
}
