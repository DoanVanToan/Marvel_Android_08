package com.it.hungvt.movieapp.data.source.local;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.it.hungvt.movieapp.data.model.Movie;
import com.it.hungvt.movieapp.data.source.FavoriteDataSource;
import java.util.ArrayList;
import java.util.List;
/* Implementation methods from FavoriteDataSource */

public class FavoriteLocalDataSource extends DatabaseHelper implements FavoriteDataSource {

    private static FavoriteLocalDataSource sDataSource;
    private SQLiteDatabase mSQLiteDatabase;

    public static FavoriteLocalDataSource getInstance(Context context) {

        if (sDataSource == null) {
            sDataSource = new FavoriteLocalDataSource(context);
        }
        return sDataSource;
    }

    private FavoriteLocalDataSource(Context context) {
        super(context);
    }

    private void openDatabase() {

        if (mSQLiteDatabase == null || !mSQLiteDatabase.isOpen()) {
            mSQLiteDatabase = getWritableDatabase();
        }
    }

    private void closeDatabase() {

        if (mSQLiteDatabase != null && mSQLiteDatabase.isOpen()) {
            mSQLiteDatabase.close();
        }
    }

    @Override
    public List<Movie> getMovies() {

        openDatabase();

        String sqlGetAllMovie = "SELECT * FROM "
                + MovieDataContract.MovieEntry.TABLE_NAME
                + " ORDER BY "
                + MovieDataContract.MovieEntry.COLUMN_TITLE
                + " ASC ";

        Cursor cursor =
                mSQLiteDatabase.query(MovieDataContract.MovieEntry.TABLE_NAME, null, null, null,
                        null, null, MovieDataContract.MovieEntry.COLUMN_TITLE);
        ArrayList<Movie> movies = new ArrayList<>();
        if (cursor == null || cursor.getCount() == 0) {
            closeDatabase();
            return movies;
        }

        cursor.moveToFirst();
        int columnIndexPosterPath =
                cursor.getColumnIndex(MovieDataContract.MovieEntry.COLUMN_POSTER_PATH);

        int columnIndexTitle = cursor.getColumnIndex(MovieDataContract.MovieEntry.COLUMN_TITLE);
        int columnIndexVoteAverage =
                cursor.getColumnIndex(MovieDataContract.MovieEntry.COLUMN_VOTE_AVERAGE);

        while (!cursor.isAfterLast()) {

            String posterPath = cursor.getString(columnIndexPosterPath);
            String title = cursor.getString(columnIndexTitle);
            Float voteAverage = cursor.getFloat(columnIndexVoteAverage);

            movies.add(new Movie(title, voteAverage, posterPath));

            cursor.moveToNext();
        }
        cursor.close();
        closeDatabase();
        return movies;
    }

    @Override
    public boolean insertMovie(Movie movie) {

        openDatabase();
        ContentValues values = new ContentValues();
        values.put(MovieDataContract.MovieEntry.COLUMN_MOVIE_ID, movie.getId());
        values.put(MovieDataContract.MovieEntry.COLUMN_POSTER_PATH, movie.getPosterPath());
        values.put(MovieDataContract.MovieEntry.COLUMN_TITLE, movie.getTitle());
        values.put(MovieDataContract.MovieEntry.COLUMN_VOTE_AVERAGE, movie.getVoteAverage());

        long id = mSQLiteDatabase.insert(MovieDataContract.MovieEntry.TABLE_NAME, null, values);
        closeDatabase();
        return id != -1;
    }

    @Override
    public boolean deleteMovie(Movie movie) {

        openDatabase();

        long id = mSQLiteDatabase.delete(MovieDataContract.MovieEntry.TABLE_NAME,
                MovieDataContract.MovieEntry.COLUMN_MOVIE_ID + "=?",
                new String[] { String.valueOf(movie.getId()) });

        closeDatabase();
        return id != -1;
    }
}
