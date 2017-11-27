package com.it.hungvt.movieapp.screen.home;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.view.Gravity;
import android.view.MenuItem;
import com.it.hungvt.movieapp.BR;
import com.it.hungvt.movieapp.R;

/**
 * Exposes the data to be used in the Home screen.
 */

public class HomeViewModel extends BaseObservable
        implements HomeContract.ViewModel, NavigationView.OnNavigationItemSelectedListener {

    private HomeContract.Presenter mPresenter;
    private int mGravity;



    public HomeViewModel() {
        mGravity = Gravity.END;
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
    public void setPresenter(HomeContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Bindable
    public int getGravity() {
        return mGravity;
    }

    public void setGravity(int gravity) {
        mGravity = gravity;
        notifyPropertyChanged(BR.gravity);
    }

    public void onNavigationClick() {
        mGravity = mGravity != Gravity.START ? Gravity.START : Gravity.END;
        notifyPropertyChanged(BR.gravity);
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {

            case R.id.nav_home:
                // TODO
                break;

            case R.id.nav_category:
                // TODO
                break;

            case R.id.nav_favorite:
                // TODO
                break;

            case R.id.nav_about_us:
                // TODO
                break;

            case R.id.nav_setting:
                // TODO

                break;
        }
        return true;
    }
}
