package com.it.hungvt.movieapp;

/* Define methods generic for classes ViewModel */
public interface BaseViewModel<T extends BasePresenter> {

    void onStart();

    void onStop();

    void setPresenter(T presenter);
}
