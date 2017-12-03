package com.it.hungvt.movieapp.screen.detail;

import android.content.Context;
import android.content.Intent;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.widget.Toast;
import com.it.hungvt.movieapp.data.model.Movie;
import com.it.hungvt.movieapp.BR;
import com.it.hungvt.movieapp.screen.home.HomeActivity;

/**
 * Exposes the data to be used in the Detail screen.
 */

public class DetailViewModel extends BaseObservable implements DetailContract.ViewModel {

    private DetailContract.Presenter mPresenter;
    private Context mContext;
    private Movie mMovie;
    private String mKeyVideoTrailer;

    public DetailViewModel(Context context, Movie movie) {
        mContext = context;
        mMovie = movie;
    }

    @Override
    public void onStart() {
        mPresenter.onStart();
    }

    @Override
    public void onStop() {
        mPresenter.onStop();
    }

    @Override
    public void setPresenter(DetailContract.Presenter presenter) {
        mPresenter = presenter;
        mPresenter.getMovie(mMovie.getId());
        mPresenter.getVideoTrailer(mMovie.getId());
    }

    @Override
    public void getMovieSuccess(Movie movie) {

    }

    @Override
    public void getMovieFailure(String message) {

    }

    @Override
    public void getTrailerSuccess(String urlVideo) {
        setKeyVideoTrailer(mKeyVideoTrailer);
    }

    @Override
    public void getTrailerFailure(String message) {

        Toast.makeText(mContext, message, Toast.LENGTH_LONG).show();
    }

    public void onBackPress() {
        // TODO
    }

    public void onClicked() {
        // TODO
    }

    @Bindable
    public Movie getMovie() {
        return mMovie;
    }

    public void setMovie(Movie movie) {
        mMovie = movie;
        notifyPropertyChanged(BR.movie);
    }

    @Bindable
    public String getKeyVideoTrailer() {
        return mKeyVideoTrailer;
    }

    public void setKeyVideoTrailer(String keyVideoTrailer) {
        this.mKeyVideoTrailer = keyVideoTrailer;
        notifyPropertyChanged(BR.keyVideoTrailer);
    }
}
