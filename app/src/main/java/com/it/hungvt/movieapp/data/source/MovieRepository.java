package com.it.hungvt.movieapp.data.source;

import com.it.hungvt.movieapp.data.model.Movie;
import com.it.hungvt.movieapp.data.source.remote.MovieRemoteDataSource;
import io.reactivex.Observable;
import java.util.List;
/* Provider repository to work with Movie */

public class MovieRepository implements MovieDataSource {

    private MovieRemoteDataSource mMovieRemoteDataSource;

    public MovieRepository(MovieRemoteDataSource remoteDataSource) {
        mMovieRemoteDataSource = remoteDataSource;
    }

    @Override
    public Observable<List<Movie>> getPopular(String apiKey, int page) {
        return mMovieRemoteDataSource.getPopular(apiKey, page);
    }

    @Override
    public Observable<List<Movie>> getNowPlaying(String apiKey, int page) {
        return mMovieRemoteDataSource.getNowPlaying(apiKey, page);
    }

    @Override
    public Observable<List<Movie>> getUpcoming(String apiKey, int page) {
        return mMovieRemoteDataSource.getUpcoming(apiKey, page);
    }

    @Override
    public Observable<List<Movie>> getTopRate(String apiKey, int page) {
        return mMovieRemoteDataSource.getTopRate(apiKey, page);
    }

    @Override
    public Observable<Movie> getDetail(int id, String apiKey) {
        return mMovieRemoteDataSource.getDetail(id, apiKey);
    }

    @Override
    public Observable<String> getVideoTrailer(int id, String apiKey) {
        return mMovieRemoteDataSource.getVideoTrailer(id, apiKey);
    }
}
