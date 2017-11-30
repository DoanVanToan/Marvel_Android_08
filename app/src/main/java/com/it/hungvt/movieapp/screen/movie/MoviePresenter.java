package com.it.hungvt.movieapp.screen.movie;

import com.it.hungvt.movieapp.BuildConfig;
import com.it.hungvt.movieapp.data.model.Movie;
import com.it.hungvt.movieapp.data.source.MovieRepository;
import com.it.hungvt.movieapp.utils.TabTypeName;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;
import java.util.List;

import static com.it.hungvt.movieapp.utils.TabTypeName.NOW_PLAYING;
import static com.it.hungvt.movieapp.utils.TabTypeName.POPULAR;
import static com.it.hungvt.movieapp.utils.TabTypeName.TOP_RATE;
import static com.it.hungvt.movieapp.utils.TabTypeName.UP_COMING;

/**
 * Listens to user actions from the UI ({@link MovieFragment}), retrieves the data and updates
 * the UI as required.
 */
public class MoviePresenter implements MovieContract.Presenter {
    private static final String TAG = MoviePresenter.class.getName();

    private final MovieContract.ViewModel mViewModel;
    private MovieRepository mMovieRepository;
    private CompositeDisposable mCompositeDisposable;

    public MoviePresenter(MovieContract.ViewModel viewModel, MovieRepository movieRepository) {
        mViewModel = viewModel;
        mMovieRepository = movieRepository;
        mCompositeDisposable = new CompositeDisposable();
    }

    @Override
    public void onStart() {
    }

    @Override
    public void onStop() {
        mCompositeDisposable.dispose();
    }

    @Override
    public void loadMovieFromApi(@TabTypeName int categoryId, int page) {


        Observable<List<Movie>> observable = null;
        switch (categoryId) {

            case TOP_RATE:
                observable = mMovieRepository.getTopRate(BuildConfig.API_KEY_MOVIE, page);
                break;

            case UP_COMING:
                observable = mMovieRepository.getUpcoming(BuildConfig.API_KEY_MOVIE, page);
                break;

            case NOW_PLAYING:
                observable = mMovieRepository.getNowPlaying(BuildConfig.API_KEY_MOVIE, page);
                break;

            case POPULAR:
                observable = mMovieRepository.getPopular(BuildConfig.API_KEY_MOVIE, page);
                break;
        }

        mCompositeDisposable.add(observable.subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableObserver<List<Movie>>() {
                    @Override
                    public void onNext(List<Movie> movies) {
                        mViewModel.loadMovieSuccess(movies);
                    }

                    @Override
                    public void onError(Throwable e) {
                        mViewModel.loadMovieFailed(e.getMessage());

                    }

                    @Override
                    public void onComplete() {

                    }
                }));
    }
}
