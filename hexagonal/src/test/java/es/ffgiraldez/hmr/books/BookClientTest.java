package es.ffgiraldez.hmr.books;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import es.ffgiraldez.hmr.recents.RecentBooks;
import es.ffgiraldez.hmr.rest.BookResponse;
import es.ffgiraldez.hmr.rest.Endpoint;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
public class BookClientTest {
    // ----------------------------------
    // ATTRIBUTES
    // ----------------------------------
    @Mock
    private Endpoint endpoint;

    @InjectMocks
    private BookClient client;

    // ----------------------------------
    // CONFIGURATION
    // ----------------------------------
    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }


    // ----------------------------------
    // TEST
    // ----------------------------------
    @Test
    public void testRecentsBook() {
        //given
        when(endpoint.recent()).thenReturn(stubResponse());

        //when
        RecentBooks recents = client.recent();

        //then
        assertThat(recents).isNotNull().isNotEmpty();
    }

    private List<BookResponse> stubResponse() {
        List<BookResponse> list = new ArrayList<>();
        list.add(BookResponse.builder().build());
        return list;
    }
}