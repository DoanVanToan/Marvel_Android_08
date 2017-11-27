package com.it.hungvt.movieapp.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;
/* Mapping data Model form Json return */
public class MovieResponse {
    @SerializedName("results")
    @Expose
    private List<Movie> mMovies;

    public MovieResponse() {
    }

    public MovieResponse(List<Movie> movies) {
        mMovies = movies;
    }

    public List<Movie> getMovies() {
        return mMovies;
    }

    public void setMovies(List<Movie> movies) {
        mMovies = movies;
    }
}
