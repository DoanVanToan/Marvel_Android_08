package com.it.hungvt.movieapp.utils.binding;

import android.databinding.BindingAdapter;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.view.Gravity;
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

    @BindingAdapter({ "navigationListener" })
    public static void setNavigationListener(NavigationView navigationView,
            NavigationView.OnNavigationItemSelectedListener listener) {
        navigationView.setNavigationItemSelectedListener(listener);
    }
}
