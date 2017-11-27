package com.it.hungvt.movieapp.screen.home;

import com.it.hungvt.movieapp.BasePresenter;
import com.it.hungvt.movieapp.BaseViewModel;

/**
 * This specifies the contract between the view and the presenter.
 */
interface HomeContract {
    /**
     * View.
     */
    interface ViewModel extends BaseViewModel<Presenter> {
    }

    /**
     * Presenter.
     */
    interface Presenter extends BasePresenter {
    }
}
