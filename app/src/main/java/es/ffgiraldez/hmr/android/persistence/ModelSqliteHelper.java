package es.ffgiraldez.hmr.android.persistence;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.sql.SQLException;

import es.ffgiraldez.hmr.android.R;
import es.ffgiraldez.hmr.books.Book;

/**
 * @author Fernando Franco Girádez
 */
public class ModelSqliteHelper extends OrmLiteSqliteOpenHelper {
    // ----------------------------------
    // CONSTANTS
    // ----------------------------------
    private static final String TAG = ModelSqliteHelper.class.getSimpleName();
    private static final String DATABASE_NAME = "youtubers.db";
    private static final int DATABASE_VERSION = 1;

    // ----------------------------------
    // CONSTRUCTOR
    // ----------------------------------
    public ModelSqliteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION, R.raw.ormlite_config);
    }

    // ----------------------------------
    // OVERRIDES
    // ----------------------------------
    @Override
    public void onCreate(SQLiteDatabase database, ConnectionSource connectionSource) {
        try {
            Log.v(TAG, "Dropping tables...");
            TableUtils.dropTable(connectionSource, Book.class, true);

            Log.v(TAG, "Creating tables...");
            TableUtils.createTable(connectionSource, Book.class);
        } catch (SQLException e) {
            Log.e(TAG, "Error creating database :(",e );
        }


    }

    @Override
    public void onUpgrade(SQLiteDatabase database, ConnectionSource connectionSource, int oldVersion, int newVersion) {
        Log.d(TAG, String.format("upgrading database from: %d to: %d", oldVersion, newVersion));
    }
}
