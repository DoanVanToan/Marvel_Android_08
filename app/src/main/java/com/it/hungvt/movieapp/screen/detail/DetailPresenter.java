package com.it.hungvt.movieapp.screen.detail;

import com.it.hungvt.movieapp.BuildConfig;
import com.it.hungvt.movieapp.data.model.Movie;
import com.it.hungvt.movieapp.data.source.MovieRepository;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

/**
 * Listens to user actions from the UI ({@link DetailActivity}), retrieves the data and updates
 * the UI as required.
 */
public class DetailPresenter implements DetailContract.Presenter {
    private static final String TAG = DetailPresenter.class.getName();

    private final DetailContract.ViewModel mViewModel;
    private MovieRepository mMovieRepository;
    private CompositeDisposable mCompositeDisposable;

    public DetailPresenter(DetailContract.ViewModel viewModel, MovieRepository movieRepository) {
        mViewModel = viewModel;
        mMovieRepository = movieRepository;
    }

    @Override
    public void onStart() {
    }

    @Override
    public void onStop() {
        mCompositeDisposable.dispose();
    }

    @Override
    public void getMovie(int id) {

        mCompositeDisposable.add(mMovieRepository.getDetail(id, BuildConfig.API_KEY_MOVIE)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .subscribeWith(new DisposableObserver<Movie>() {
                    @Override
                    public void onNext(Movie movie) {
                        mViewModel.getMovieSuccess(movie);
                    }

                    @Override
                    public void onError(Throwable e) {
                        mViewModel.getMovieFailure(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                }));
    }

    @Override
    public void getVideoTrailer(int id) {

        mCompositeDisposable.add(mMovieRepository.getVideoTrailer(id, BuildConfig.API_KEY_MOVIE)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .subscribeWith(new DisposableObserver<String>() {
                    @Override
                    public void onNext(String s) {

                        mViewModel.getTrailerSuccess(s);
                    }

                    @Override
                    public void onError(Throwable e) {

                        mViewModel.getTrailerFailure(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                }));
    }
}
