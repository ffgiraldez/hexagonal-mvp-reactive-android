package es.ffgiraldez.hmr.android.recents.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;

import es.ffgiraldez.hmr.android.R;
import es.ffgiraldez.hmr.books.Book;
import es.ffgiraldez.hmr.recents.RecentBooks;
/**
 * @author Fernando Franco Giráldez
 */
public class RecentAdapter extends BaseAdapter {
    // ----------------------------------
    // ATTRIBUTES
    // ----------------------------------
    RecentBooks books;
    final LayoutInflater inflater;

    // ----------------------------------
    // CONSTRUCTOR
    // ----------------------------------
    public RecentAdapter(Context ctx) {
        this.inflater = LayoutInflater.from(ctx);
        this.books = new RecentBooks(new ArrayList<>());
    }

    @Override
    public int getCount() {
        return books.size();
    }

    @Override
    public Object getItem(int position) {
        return books.get(position);
    }

    @Override
    public long getItemId(int position) {
        return Long.parseLong(getBook(position).identifier());
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        RecentItemLayout item = (RecentItemLayout) convertView;
        if (convertView == null) {
            item = (RecentItemLayout) inflater.inflate(R.layout.recent_item, parent, false);
        }
        item.bind(getBook(position));
        return item;
    }

    // ----------------------------------
    // PUBLIC API
    // ----------------------------------
    public void swap(RecentBooks books) {
        this.books = books;
        notifyDataSetChanged();
    }

    // ----------------------------------
    // PRIVATE API
    // ----------------------------------
    private Book getBook(int position) {
        return (Book) getItem(position);
    }


}
