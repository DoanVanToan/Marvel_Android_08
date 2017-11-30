package com.it.hungvt.movieapp.screen.home;

import com.it.hungvt.movieapp.data.source.MovieRepository;

/**
 * Listens to user actions from the UI ({@link HomeActivity}), retrieves the data and updates
 * the UI as required.
 */
public class HomePresenter implements HomeContract.Presenter {
    private static final String TAG = HomePresenter.class.getName();

    private HomeContract.ViewModel mViewModel;
    private MovieRepository mMovieRepository;

    public HomePresenter(HomeContract.ViewModel viewModel, MovieRepository movieRepository) {
        mViewModel = viewModel;
        mMovieRepository = movieRepository;
    }

    @Override
    public void onStart() {
    }

    @Override
    public void onStop() {
    }
}
