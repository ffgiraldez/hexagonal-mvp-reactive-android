package es.ffgiraldez.hmr.recents;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicReference;

import es.ffgiraldez.hmr.books.Book;
import es.ffgiraldez.hmr.books.BookClient;
import rx.schedulers.Schedulers;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
public class RecentDataSourceTest {

    private static final RecentBooks NON_EMPTY_BOOKS = new RecentBooks(
            Arrays.asList(
                    Book.builder().title("lorem impsum title").build()
            )
    );

    private static final RecentBooks EMPTY_BOOKS = new RecentBooks(new ArrayList<>());
    private static final int CHECK_EMTPY_AND_RETURNS_TIMES = 2;
    private static final int NETWORK_TIMES = 1;

    RecentDataSource dataSource;
    @Mock
    RecentRepository repo;
    @Mock
    BookClient client;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        dataSource = new RecentDataSource(repo, client);
    }

    @Test
    public void shouldNotCallNetworkIfCacheIsNotEmpty() {
        given(repo.retrieve()).willReturn(NON_EMPTY_BOOKS);

        dataSource.retrieve().subscribeOn(Schedulers.immediate()).subscribe();

        verify(repo, times(CHECK_EMTPY_AND_RETURNS_TIMES)).retrieve();
    }

    @Test
    public void shouldCallNetworkIfCacheIsEmpty() {
        given(repo.retrieve()).willReturn(EMPTY_BOOKS);

        dataSource.retrieve().subscribeOn(Schedulers.immediate()).subscribe();

        verify(client, times(NETWORK_TIMES)).recent();
    }

    @Test
    public void shouldStoreDataIfNetworkIsCalled() {
        given(repo.retrieve()).willReturn(EMPTY_BOOKS);
        given(client.recent()).willReturn(NON_EMPTY_BOOKS);

        dataSource.retrieve().subscribeOn(Schedulers.immediate()).subscribe();

        verify(repo).save(any());
    }

    @Test
    public void shouldReturnSavedDataIfNetworkIsCalled() {
        given(repo.retrieve()).willReturn(EMPTY_BOOKS, NON_EMPTY_BOOKS);
        given(client.recent()).willReturn(NON_EMPTY_BOOKS);

        final AtomicReference<RecentBooks> reference = new AtomicReference<>();
        dataSource.retrieve().subscribeOn(Schedulers.immediate()).subscribe(reference::set);

        assertThat(reference.get()).isEqualTo(NON_EMPTY_BOOKS);
    }
}