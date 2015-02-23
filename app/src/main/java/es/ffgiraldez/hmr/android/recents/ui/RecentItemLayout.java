package es.ffgiraldez.hmr.android.recents.ui;

import com.squareup.picasso.Picasso;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.ButterKnife;
import butterknife.InjectView;
import es.ffgiraldez.hmr.android.R;
import es.ffgiraldez.hmr.books.Book;
/**
 * @author Fernando Franco Giráldez
 */
public class RecentItemLayout extends CardView implements RecentItemUserInterface {
    // ----------------------------------
    // ATTRIBUTES
    // ----------------------------------
    @InjectView(R.id.book_title)
    TextView title;
    @InjectView(R.id.book_cover)
    ImageView cover;

    String identifier;

    // ----------------------------------
    // CONSTRUCTOR
    // ----------------------------------
    public RecentItemLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public RecentItemLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    // ----------------------------------
    // LIFE CYCLE
    // ----------------------------------
    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        ButterKnife.inject(this);
    }

    // ----------------------------------
    // INTERFACES IMPL
    // ----------------------------------
    @Override
    public void bind(Book book) {
        identifier = book.identifier();
        title.setText(book.title());
        Picasso.with(getContext()).load(book.cover()).into(cover);
    }

    @Override
    public String identifier() {
        return identifier;
    }
}
