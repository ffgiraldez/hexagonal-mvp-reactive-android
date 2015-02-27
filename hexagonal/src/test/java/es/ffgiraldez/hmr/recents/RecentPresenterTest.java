package es.ffgiraldez.hmr.recents;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import es.ffgiraldez.hmr.details.DetailsNavigation;
import es.ffgiraldez.hmr.navigation.Navigation;
import es.ffgiraldez.hmr.navigation.Navigator;
import es.ffgiraldez.hmr.schedulers.RxSchedulerProvider;
import rx.Observable;
import rx.subjects.PublishSubject;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Matchers.isNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
public class RecentPresenterTest {
    // ----------------------------------
    // ATTRIBUTES
    // ----------------------------------
    RecentPresenter presenter;

    @Mock
    RecentUserInterface ui;
    @Mock
    RecentInteractor interactor;
    @Mock
    Navigator navigator;

    PublishSubject<String> click = PublishSubject.create();

    // ----------------------------------
    // CONFIGURATION
    // ----------------------------------
    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        when(ui.onBookClick()).thenReturn(click);

        presenter = new RecentPresenter(interactor, navigator, new RxSchedulerProvider());
        presenter.initialize(ui);

    }

    // ----------------------------------
    // TESTS
    // ----------------------------------
    @Test
    public void testPresenterStartRecentObservableOnStart() {
        //given
        when(interactor.recent()).thenReturn(Observable.empty());

        //when
        presenter.load();

        //then
        verify(interactor, times(1)).recent();
    }

    @Test
    public void testPresenterNotifyUIonRecentObservableComplete() {
        //given
        PublishSubject<RecentBooks> subject = PublishSubject.create();
        when(interactor.recent()).thenReturn(subject);


        //when
        presenter.load();
        subject.onNext(null);

        //then
        verify(ui, times(1)).show(isNull(RecentBooks.class));
    }

    @Test
    public void testNavigateToDetailsWhenBookClick() {
        //given
        ArgumentCaptor<Navigation> argumentCaptor = ArgumentCaptor.forClass(Navigation.class);

        //when
        click.onNext("123");

        //then
        verify(navigator, times(1)).to(argumentCaptor.capture());
        assertThat(argumentCaptor.getValue()).isNotNull().isInstanceOf(DetailsNavigation.class);

    }
}