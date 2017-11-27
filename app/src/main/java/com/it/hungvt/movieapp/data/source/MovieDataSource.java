package com.it.hungvt.movieapp.data.source;

import com.it.hungvt.movieapp.data.model.Movie;
import io.reactivex.Observable;
import java.util.List;


/* Define methods work with Favorite Movie Remote */

public interface MovieDataSource {

    Observable<List<Movie>> getPopular(String apiKey, int page);

    Observable<List<Movie>> getNowPlaying(String apiKey, int page);

    Observable<List<Movie>> getUpcoming(String apiKey, int page);

    Observable<List<Movie>> getTopRate(String apiKey, int page);

    Observable<Movie> getDetail(int id, String apiKey);

    Observable<String> getVideoTrailer(int id, String apiKey);
}
