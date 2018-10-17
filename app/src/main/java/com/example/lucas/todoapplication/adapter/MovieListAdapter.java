package com.example.lucas.todoapplication.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lucas.todoapplication.R;
import com.example.lucas.todoapplication.domain.TmdbData;
import com.example.lucas.todoapplication.service.DownloadImageService;

import java.util.ArrayList;

public class MovieListAdapter extends ArrayAdapter<TmdbData> implements View.OnClickListener {

    private ArrayList<TmdbData> dataSet;
    private Context mContext;
    private LayoutInflater inflater;
    private MovieListListener movieListListener;

    public MovieListAdapter(ArrayList<TmdbData> movies, @NonNull Context context, MovieListListener movieListListener) {
        super(context, R.layout.movie_cell, movies);
        this.dataSet = movies;
        this.mContext = context;
        this.movieListListener = movieListListener;
    }

    @Override
    public void onClick(View v) {
        Toast.makeText(getContext(), "Clicou", Toast.LENGTH_LONG).show();
    }

    @NonNull
    @Override
    public View getView(int position, View view, @NonNull ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View vi = inflater.inflate(R.layout.movie_cell, parent, false);

        vi.setOnClickListener(v -> {
            movieListListener.onClickItem(getItem(position));
        });

        ImageView movieImage = vi.findViewById(R.id.movieImage);
        TextView movieTitle = vi.findViewById(R.id.movieTitle);
        TextView movieOverview = vi.findViewById(R.id.movieOverview);

        TmdbData data = dataSet.get(position);

        movieTitle.setText(data.getTitle());
        movieOverview.setText(data.getOverview());
        new DownloadImageService(movieImage).execute(data.getPosterPath());

        return vi;
    }

    @Override
    public int getCount() {
        return dataSet.size();
    }

    @Nullable
    @Override
    public TmdbData getItem(int position) {
        return dataSet.get(position);
    }

    @Override
    public int getPosition(@Nullable TmdbData item) {
        return dataSet.indexOf(item);
    }

    public interface MovieListListener {
        void onClickItem(TmdbData data);
    }
}
