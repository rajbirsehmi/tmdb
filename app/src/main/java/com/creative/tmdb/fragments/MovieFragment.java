package com.creative.tmdb.fragments;


import android.os.Bundle;


import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.creative.tmdb.R;
import com.creative.tmdb.model.LoadPopularMoviesImpl;
import com.creative.tmdb.presenter.LoadPopularMovies;

import androidx.fragment.app.Fragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class MovieFragment extends Fragment implements LoadPopularMovies {

    private LoadPopularMoviesImpl loadPopularMovies;

    public MovieFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_movie, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();
        loadPopularMovies = new LoadPopularMoviesImpl(this, getContext());
        loadPopularMovies.loadPopularMovies();
    }
}
