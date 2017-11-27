package com.it.hungvt.movieapp.data.source;

import com.it.hungvt.movieapp.data.model.Movie;
import java.util.List;

/* Define methods work with Favorite Movie */
public interface FavoriteDataSource {

    List<Movie> getMovies();

    boolean insertMovie(Movie movie);

    boolean deleteMovie(Movie movie);
}
