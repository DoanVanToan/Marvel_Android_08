package com.it.hungvt.movieapp.data.source.remote;

import com.it.hungvt.movieapp.data.model.Movie;
import com.it.hungvt.movieapp.data.model.MovieResponse;
import com.it.hungvt.movieapp.data.source.remote.api.service.MovieApi;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import java.util.List;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

/* Define methods to work with Movie Remote */

public class MovieRemoteDataSource extends BaseRemoteDataSource {

    public MovieRemoteDataSource(MovieApi movieApi) {
        super(movieApi);
    }

    @Override
    public Observable<List<Movie>> getPopular(String apiKey, int page) {
        return mMovieApi.getPopular(apiKey, page).map(new Function<MovieResponse, List<Movie>>() {
            @Override
            public List<Movie> apply(MovieResponse movieResponse) throws Exception {
                return movieResponse.getMovies();
            }
        });
    }

    @Override
    public Observable<List<Movie>> getNowPlaying(String apiKey, int page) {
        return mMovieApi.getNowPlaying(apiKey, page)
                .map(new Function<MovieResponse, List<Movie>>() {
                    @Override
                    public List<Movie> apply(MovieResponse movieResponse) throws Exception {
                        return movieResponse.getMovies();
                    }
                });
    }

    @Override
    public Observable<List<Movie>> getUpcoming(String apiKey, int page) {
        return mMovieApi.getUpcoming(apiKey, page).map(new Function<MovieResponse, List<Movie>>() {
            @Override
            public List<Movie> apply(MovieResponse movieResponse) throws Exception {
                return movieResponse.getMovies();
            }
        });
    }

    @Override
    public Observable<List<Movie>> getTopRate(String apiKey, int page) {
        return mMovieApi.getTopRate(apiKey, page).map(new Function<MovieResponse, List<Movie>>() {
            @Override
            public List<Movie> apply(MovieResponse movieResponse) throws Exception {
                return movieResponse.getMovies();
            }
        });
    }

    @Override
    public Observable<Movie> getDetail(int id, String apiKey) {
        return mMovieApi.getDetail(id, apiKey);
    }

    @Override
    public Observable<String> getVideoTrailer(int id, String apiKey) {
        return mMovieApi.getVideoTrailer(id, apiKey).map(new Function<JsonObject, String>() {
            @Override
            public String apply(JsonObject jsonObject) throws Exception {

                JsonArray videos = jsonObject.getAsJsonArray("results");
                JsonObject video = videos.get(0).getAsJsonObject();
                return video.get("key").getAsString();
            }
        });
    }
}
