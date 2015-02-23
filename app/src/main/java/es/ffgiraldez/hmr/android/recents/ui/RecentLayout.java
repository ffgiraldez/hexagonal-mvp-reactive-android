package es.ffgiraldez.hmr.android.recents.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.GridView;

import butterknife.ButterKnife;
import butterknife.InjectView;
import es.ffgiraldez.hmr.android.R;
import es.ffgiraldez.hmr.recents.RecentBooks;
import es.ffgiraldez.hmr.recents.RecentUserInterface;
import rx.Observable;
import rx.subjects.PublishSubject;
/**
 * @author Fernando Franco Giráldez
 */
public class RecentLayout extends FrameLayout implements RecentUserInterface {
    // ----------------------------------
    // ATTRIBUTES
    // ----------------------------------
    @InjectView(R.id.recent_grid)
    GridView grid;

    PublishSubject<String> clickSubject = PublishSubject.create();
    // ----------------------------------
    // CONSTRUCTOR
    // ----------------------------------
    public RecentLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public RecentLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    // ----------------------------------
    // OVERRIDES
    // ----------------------------------
    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        ButterKnife.inject(this);
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ButterKnife.reset(this);
    }

    // ----------------------------------
    // INTERFACES IMPL
    // ----------------------------------
    @Override
    public void initialize() {
        grid.setAdapter(new RecentAdapter(getContext()));
        grid.setOnItemClickListener((parent, view, position, id) -> {
            RecentItemLayout ui = (RecentItemLayout) view;
            clickSubject.onNext(ui.identifier());
        });
    }

    @Override
    public void show(RecentBooks books) {
        RecentAdapter adapter = (RecentAdapter) grid.getAdapter();
        adapter.swap(books);
    }

    @Override
    public Observable<String> onBookClick() {
        return clickSubject;
    }
}
