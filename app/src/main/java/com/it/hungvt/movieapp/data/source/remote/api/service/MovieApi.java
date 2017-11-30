package com.it.hungvt.movieapp.data.source.remote.api.service;

import com.it.hungvt.movieapp.data.model.Movie;
import com.it.hungvt.movieapp.data.model.MovieResponse;
import io.reactivex.Observable;
import com.google.gson.JsonObject;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
/* Define api interface */

public interface MovieApi {

    @GET("movie/top_rated")
    Observable<MovieResponse> getTopRate(@Query("api_key") String apiKey, @Query("page") int page);

    @GET("movie/upcoming")
    Observable<MovieResponse> getUpcoming(@Query("api_key") String apiKey, @Query("page") int page);

    @GET("movie/now_playing")
    Observable<MovieResponse> getNowPlaying(@Query("api_key") String apiKey,
            @Query("page") int page);

    @GET("movie/popular")
    Observable<MovieResponse> getPopular(@Query("api_key") String apiKey, @Query("page") int page);

    @GET("movie/{id}")
    Observable<Movie> getDetail(@Path("id") int id, @Query("api_key") String apiKey);

    @GET("movie/{id}/videos")
    Observable<JsonObject> getVideoTrailer(@Path("id") int id, @Query("api_key") String apiKey);
}
