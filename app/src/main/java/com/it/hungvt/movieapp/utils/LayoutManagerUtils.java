package com.it.hungvt.movieapp.utils;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

/**
 * Define the layout manager to be set layout for RecyclerView
 */
public final class LayoutManagerUtils {

    private LayoutManagerUtils() {

    }

    public static LayoutManager linearLayout() {
        return new LayoutManager() {
            @Override
            public RecyclerView.LayoutManager layout(RecyclerView recyclerView) {
                return new LinearLayoutManager(recyclerView.getContext());
            }
        };
    }

    public static LayoutManager gridLayout(int column) {

        return new LayoutManager() {
            @Override
            public RecyclerView.LayoutManager layout(RecyclerView recyclerView) {
                return new GridLayoutManager(recyclerView.getContext(), column);
            }
        };
    }

    /**
     * Define layout manager.
     */

    public interface LayoutManager {
        RecyclerView.LayoutManager layout(RecyclerView recyclerView);
    }
}
