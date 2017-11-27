package com.it.hungvt.movieapp.data.source.local;

import android.provider.BaseColumns;
/* Define table name and columns */

public class MovieDataContract {

    public static class MovieEntry implements BaseColumns {

        public static final String TABLE_NAME = "tbl_movie";
        public static final String COLUMN_MOVIE_ID = "id";
        public static final String COLUMN_TITLE = "title";
        public static final String COLUMN_RELEASE_DATE = "release_date";
        public static final String COLUMN_VOTE_AVERAGE = "vote_average";
        public static final String COLUMN_POSTER_PATH = "poster_path";
    }
}
