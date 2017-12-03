package com.it.hungvt.movieapp.screen.detail;

import com.it.hungvt.movieapp.BasePresenter;
import com.it.hungvt.movieapp.BaseViewModel;
import com.it.hungvt.movieapp.data.model.Movie;

/**
 * This specifies the contract between the view and the presenter.
 */
interface DetailContract {
    /**
     * View.
     */
    interface ViewModel extends BaseViewModel<Presenter> {
        void getMovieSuccess(Movie movie);

        void getMovieFailure(String message);

        void getTrailerSuccess(String urlVideo);

        void getTrailerFailure(String message);
    }

    /**
     * Presenter.
     */
    interface Presenter extends BasePresenter {
        void getMovie(int id);

        void getVideoTrailer(int id);
    }
}
