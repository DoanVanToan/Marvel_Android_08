package com.it.hungvt.movieapp.utils.binding;

import android.databinding.BindingAdapter;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.widget.ImageView;
import android.widget.Toast;
import com.bumptech.glide.Glide;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;
import com.it.hungvt.movieapp.BuildConfig;
import com.it.hungvt.movieapp.utils.Constant;
import com.it.hungvt.movieapp.utils.LayoutManagerUtils;
/* Define methods to binding data */

public class BindingUtils {

    @BindingAdapter("drawerState")
    public static void drawerState(DrawerLayout drawerLayout, int gravity) {

        if (gravity == Gravity.START) {
            drawerLayout.openDrawer(gravity);
        } else {
            drawerLayout.closeDrawers();
        }
    }

    @BindingAdapter({ "viewPager" })
    public static void setViewPagerTabs(TabLayout view, ViewPager pagerView) {
        view.setupWithViewPager(pagerView);
    }

    @BindingAdapter("navigationListener")
    public static void setNavigationListener(NavigationView navigationView,
            NavigationView.OnNavigationItemSelectedListener listener) {
        navigationView.setNavigationItemSelectedListener(listener);
    }

    @BindingAdapter({ "setImage" })
    public static void setImageView(ImageView imageView, String url) {
        String imageUrl = Constant.BASE_POSTER_PATH + url;
        Glide.with(imageView.getContext()).load(imageUrl).into(imageView);
    }

    @BindingAdapter("pagerAdapter")
    public static void setPagerAdapter(ViewPager viewPager, FragmentPagerAdapter pagerAdapter) {
        viewPager.setAdapter(pagerAdapter);
    }

    @BindingAdapter("recyclerAdapter")
    public static void setAdapterForRecyclerView(RecyclerView view, RecyclerView.Adapter adapter) {

        view.setAdapter(adapter);
    }

    @BindingAdapter("layoutManager")
    public static void setLayoutManager(RecyclerView recyclerView,
            LayoutManagerUtils.LayoutManager layoutManager) {
        recyclerView.setLayoutManager(layoutManager.layout(recyclerView));
    }

    @BindingAdapter("scrollListener")
    public static void setScrollListener(RecyclerView recyclerView,
            RecyclerView.OnScrollListener scrollListener) {

        recyclerView.addOnScrollListener(scrollListener);
    }

    @BindingAdapter("keyVideoTrailer")
    public static void setKeyVideoTrailer(YouTubePlayerView youTubePlayerView,
            String keyVideoTrailer) {

        if (keyVideoTrailer == null) {
            return;
        }

        youTubePlayerView.initialize(BuildConfig.API_KEY_YOUTUBE,
                new YouTubePlayer.OnInitializedListener() {
                    @Override
                    public void onInitializationSuccess(YouTubePlayer.Provider provider,
                            YouTubePlayer youTubePlayer, boolean b) {

                        if (!b) {
                            youTubePlayer.cueVideo(keyVideoTrailer);
                        }
                    }

                    @Override
                    public void onInitializationFailure(YouTubePlayer.Provider provider,
                            YouTubeInitializationResult youTubeInitializationResult) {
                        Toast.makeText(youTubePlayerView.getContext(),
                                youTubeInitializationResult.toString(), Toast.LENGTH_LONG).show();
                    }
                });
    }
}
