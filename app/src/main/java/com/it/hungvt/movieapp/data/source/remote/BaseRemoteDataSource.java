package com.it.hungvt.movieapp.data.source.remote;

import com.it.hungvt.movieapp.data.source.MovieDataSource;
import com.it.hungvt.movieapp.data.source.remote.api.service.MovieApi;
/* Define data generic for classes RemoteData */

public abstract class BaseRemoteDataSource implements MovieDataSource {

    MovieApi mMovieApi;

    public BaseRemoteDataSource(MovieApi movieApi) {

        mMovieApi = movieApi;
    }
}
