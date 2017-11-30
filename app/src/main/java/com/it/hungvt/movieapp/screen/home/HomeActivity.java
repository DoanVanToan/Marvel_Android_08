package com.it.hungvt.movieapp.screen.home;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import com.it.hungvt.movieapp.R;
import com.it.hungvt.movieapp.data.source.MovieRepository;
import com.it.hungvt.movieapp.data.source.remote.MovieRemoteDataSource;
import com.it.hungvt.movieapp.data.source.remote.api.service.MovieServiceClient;
import com.it.hungvt.movieapp.databinding.ActivityHomeBinding;
import com.it.hungvt.movieapp.BaseActivity;

/**
 * Home Screen.
 */
public class HomeActivity extends BaseActivity {

    private HomeContract.ViewModel mViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MovieRepository movieRepository =
                new MovieRepository(new MovieRemoteDataSource(MovieServiceClient.getInstance()));

        mViewModel = new HomeViewModel(this, getSupportFragmentManager());

        HomeContract.Presenter presenter = new HomePresenter(mViewModel, movieRepository);
        mViewModel.setPresenter(presenter);

        ActivityHomeBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_home);
        binding.setViewModel((HomeViewModel) mViewModel);
    }

    @Override
    protected void onStart() {
        super.onStart();
        mViewModel.onStart();
    }

    @Override
    protected void onStop() {
        mViewModel.onStop();
        super.onStop();
    }
}
