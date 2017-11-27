package com.it.hungvt.movieapp;



public interface BaseViewModel<T extends BasePresenter> {

    void onStart();

    void onStop();

    void setPresenter(T presenter);
}
