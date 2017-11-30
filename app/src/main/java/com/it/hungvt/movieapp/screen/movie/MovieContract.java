package com.it.hungvt.movieapp.screen.movie;

import com.it.hungvt.movieapp.BasePresenter;
import com.it.hungvt.movieapp.BaseViewModel;
import com.it.hungvt.movieapp.data.model.Movie;
import com.it.hungvt.movieapp.utils.TabTypeName;
import java.util.List;

/**
 * This specifies the contract between the view and the presenter.
 */
interface MovieContract {
    /**
     * View.
     */
    interface ViewModel extends BaseViewModel<Presenter> {

        void loadMovieSuccess(List<Movie> movies);

        void loadMovieFailed(String message);
    }

    /**
     * Presenter.
     */
    interface Presenter extends BasePresenter {

        void loadMovieFromApi(@TabTypeName int categoryId, int page);
    }
}
