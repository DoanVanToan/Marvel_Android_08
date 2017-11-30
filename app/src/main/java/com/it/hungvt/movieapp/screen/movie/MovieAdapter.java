package com.it.hungvt.movieapp.screen.movie;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import com.it.hungvt.movieapp.BaseRecyclerViewAdapter;
import com.it.hungvt.movieapp.R;
import com.it.hungvt.movieapp.data.model.Movie;
import com.it.hungvt.movieapp.databinding.ItemMovieBinding;
import java.util.ArrayList;
import java.util.List;

/**
 * Binding data on Movie screen
 */

public class MovieAdapter extends BaseRecyclerViewAdapter<MovieAdapter.ItemViewHolder>
        implements Filterable {

    private List<Movie> mMovies;
    private ItemMovieBinding mBinding;
    private BaseRecyclerViewAdapter.OnRecyclerViewItemClickListener<Movie> mItemClickListener;
    private List<Movie> mFilterListMovie;

    public MovieAdapter(@NonNull Context context, List<Movie> movies) {
        super(context);
        mMovies = movies;
        mFilterListMovie = movies;
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater mInflater = LayoutInflater.from(parent.getContext());

        mBinding = DataBindingUtil.inflate(mInflater, R.layout.item_movie, parent, false);

        return new ItemViewHolder(mBinding, mItemClickListener);
    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, int position) {

        holder.bind(mMovies.get(position));
    }

    @Override
    public int getItemCount() {
        return (mMovies == null) ? 0 : mMovies.size();
    }

    public void setItemClickListener(OnRecyclerViewItemClickListener<Movie> itemClickListener) {
        mItemClickListener = itemClickListener;
    }

    public List<Movie> getMovies() {
        return mMovies;
    }

    public void updateMovies(List<Movie> movies) {
        if (mMovies == null) {
            return;
        }

        mMovies.addAll(movies);
        notifyDataSetChanged();
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {

                String charString = constraint.toString();
                if (charString.isEmpty()) {

                    mFilterListMovie = mMovies;
                } else {

                    List<Movie> filteredList = new ArrayList<>();
                    for (Movie movie : mMovies) {
                        if (movie.getTitle().toLowerCase().contains(charString)
                                || (movie.getVoteAverage() + "").toLowerCase()
                                .contains(charString)) {

                            filteredList.add(movie);
                        }
                    }
                    mFilterListMovie = filteredList;
                }
                FilterResults results = new FilterResults();
                results.values = mFilterListMovie;
                return results;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {

                mFilterListMovie = (ArrayList<Movie>) results.values;
                notifyDataSetChanged();
            }
        };
    }

    /**
     * Define class ViewHolder.
     */
    public class ItemViewHolder extends RecyclerView.ViewHolder {

        private ItemMovieBinding mBinding;
        private BaseRecyclerViewAdapter.OnRecyclerViewItemClickListener<Movie> mItemClickListener;

        public ItemViewHolder(ItemMovieBinding binding,
                BaseRecyclerViewAdapter.OnRecyclerViewItemClickListener<Movie> itemClickListener) {
            super(binding.getRoot());

            mBinding = binding;
            mItemClickListener = itemClickListener;
        }

        public void bind(Movie movie) {
            mBinding.setItemViewModel(new MovieItemViewModel(movie, mItemClickListener));
            mBinding.setMovie(movie);
            mBinding.executePendingBindings();
        }
    }
}

