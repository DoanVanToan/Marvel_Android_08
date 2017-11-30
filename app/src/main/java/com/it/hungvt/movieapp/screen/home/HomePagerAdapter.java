package com.it.hungvt.movieapp.screen.home;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import com.it.hungvt.movieapp.R;
import com.it.hungvt.movieapp.screen.movie.MovieFragment;
import com.it.hungvt.movieapp.utils.Constant;
import com.it.hungvt.movieapp.utils.TabTypeName;

import static com.it.hungvt.movieapp.utils.TabTypeName.NOW_PLAYING;
import static com.it.hungvt.movieapp.utils.TabTypeName.POPULAR;
import static com.it.hungvt.movieapp.utils.TabTypeName.TOP_RATE;
import static com.it.hungvt.movieapp.utils.TabTypeName.UP_COMING;

/**
 * Binding data on Tab layout in the Home screen.
 */
public class HomePagerAdapter extends FragmentPagerAdapter {
    public HomePagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(@TabTypeName int position) {
        switch (position) {
            case TOP_RATE:
                return MovieFragment.newInstance(TOP_RATE);

            case UP_COMING:
                return MovieFragment.newInstance(UP_COMING);

            case NOW_PLAYING:
                return MovieFragment.newInstance(NOW_PLAYING);

            case POPULAR:
                return MovieFragment.newInstance(POPULAR);

            default:
                return MovieFragment.newInstance(POPULAR);
        }
    }

    @Override
    public int getCount() {
        return Constant.FRAGMENT_NUMBER;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {

            case TOP_RATE:
                return String.valueOf(R.string.title_tab_top_rate);

            case UP_COMING:
                return String.valueOf(R.string.title_tab_top_up_coming);

            case NOW_PLAYING:
                return String.valueOf(R.string.title_tab_now_playing);

            case POPULAR:
                return String.valueOf(R.string.title_tab_popular);

            default:
                return String.valueOf(R.string.title_tab_top_rate);
        }
    }
}
