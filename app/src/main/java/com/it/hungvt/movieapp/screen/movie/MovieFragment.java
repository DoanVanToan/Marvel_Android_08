package com.it.hungvt.movieapp.screen.movie;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.it.hungvt.movieapp.R;
import com.it.hungvt.movieapp.data.source.MovieRepository;
import com.it.hungvt.movieapp.data.source.remote.MovieRemoteDataSource;
import com.it.hungvt.movieapp.data.source.remote.api.service.MovieServiceClient;
import com.it.hungvt.movieapp.databinding.FragmentMovieBinding;
import com.it.hungvt.movieapp.BaseFragment;
import com.it.hungvt.movieapp.utils.Constant;
import com.it.hungvt.movieapp.utils.TabTypeName;

/**
 * Movie Screen.
 */
public class MovieFragment extends BaseFragment {

    private MovieContract.ViewModel mViewModel;
    private int mCategoryId;
    private MovieRepository mMovieRepository;

    public static MovieFragment newInstance(@TabTypeName int categoryId) {
        MovieFragment movieFragment = new MovieFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(Constant.BUNDLE_MOVIE, categoryId);
        movieFragment.setArguments(bundle);
        return movieFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mMovieRepository =
                new MovieRepository(new MovieRemoteDataSource(MovieServiceClient.getInstance()));
        mCategoryId = getArguments().getInt(Constant.BUNDLE_MOVIE);
        mViewModel = new MovieViewModel(getContext(), mCategoryId);
        MovieContract.Presenter presenter = new MoviePresenter(mViewModel, mMovieRepository);
        mViewModel.setPresenter(presenter);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {

        FragmentMovieBinding binding =
                DataBindingUtil.inflate(inflater, R.layout.fragment_movie, container, false);
        binding.setViewModel((MovieViewModel) mViewModel);
        return binding.getRoot();
    }

    @Override
    public void onStart() {
        super.onStart();
        mViewModel.onStart();
    }

    @Override
    public void onStop() {
        mViewModel.onStop();
        super.onStop();
    }
}
