package com.it.hungvt.movieapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;

/**
 * Define abstract class BaseAdapter generic for classes RecyclerViewAdapter.
 */

public abstract class BaseRecyclerViewAdapter<V extends RecyclerView.ViewHolder>
        extends RecyclerView.Adapter<V> {

    private final Context mContext;

    protected BaseRecyclerViewAdapter(@NonNull Context context) {
        mContext = context;
    }

    public Context getContext() {
        return mContext;
    }

    /**
     * Provide method onItemClick() using listener itemClick on RecyclerView
     */

    public interface OnRecyclerViewItemClickListener<T> {

        void onItemRecyclerViewClick(T item);
    }
}
