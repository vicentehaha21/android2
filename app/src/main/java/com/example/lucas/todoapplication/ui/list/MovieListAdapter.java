package com.example.lucas.todoapplication.ui.list;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lucas.todoapplication.R;
import com.example.lucas.todoapplication.domain.TmdbData;
import com.example.lucas.todoapplication.util.ImageDownloader;

import java.util.ArrayList;

public class MovieListAdapter extends RecyclerView.Adapter<MovieListAdapter.MovieListViewHolder> {

    private ArrayList<TmdbData> dataSet;
    private Context mContext;
    private MovieListListener movieListListener;

    public MovieListAdapter(ArrayList<TmdbData> movies, @NonNull Context context, MovieListListener movieListListener) {
        this.dataSet = movies;
        this.mContext = context;
        this.movieListListener = movieListListener;
    }

    @NonNull
    @Override
    public MovieListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.movie_cell, parent, false);
        MovieListViewHolder vh = new MovieListViewHolder(v);
        v.setOnClickListener(movieListListener);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull MovieListViewHolder holder, int i) {
        TmdbData data = dataSet.get(i);
        holder.movieOverview.setText(data.getOverview());
        holder.movieTitle.setText(data.getTitle());
        holder.movieImage.setVisibility(View.INVISIBLE);
        if (data.hasPoster()) {
            new ImageDownloader(holder.movieImage).execute(data.getSmallPosterPath());
        }
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }

    static class MovieListViewHolder extends RecyclerView.ViewHolder {
        private final ImageView movieImage;
        private final TextView movieTitle;
        private final TextView movieOverview;

        MovieListViewHolder(View itemView) {
            super(itemView);
            this.movieImage = itemView.findViewById(R.id.movieImage);
            this.movieTitle = itemView.findViewById(R.id.movieTitle);
            this.movieOverview = itemView.findViewById(R.id.movieOverview);
        }
    }

    public interface MovieListListener extends View.OnClickListener {
    }
}
