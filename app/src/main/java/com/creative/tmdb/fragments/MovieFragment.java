package com.creative.tmdb.fragments;


import android.os.Bundle;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.creative.tmdb.R;
import com.creative.tmdb.adapter.PopularMovieOverviewAdapter;
import com.creative.tmdb.listener.SeeAllListener;
import com.creative.tmdb.model.LoadPopularMoviesImpl;
import com.creative.tmdb.presenter.LoadPopularMovies;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/**
 * A simple {@link Fragment} subclass.
 */
public class MovieFragment extends Fragment implements LoadPopularMovies {

    private LoadPopularMoviesImpl loadPopularMovies;
    private RecyclerView rvPopularMovies;

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
        rvPopularMovies = getActivity().findViewById(R.id.rv_popular_movies);
        rvPopularMovies.setLayoutManager(new LinearLayoutManager(getActivity().getBaseContext(), LinearLayoutManager.HORIZONTAL, false));
        rvPopularMovies.setItemAnimator(new DefaultItemAnimator());

        getActivity().findViewById(R.id.btn_see_all_popular_movies).setOnClickListener(new SeeAllListener());

        loadPopularMovies = new LoadPopularMoviesImpl(this, getContext());
        loadPopularMovies.loadPopularMovies(1);
    }

    @Override
    public void setPopularMovieAdapterToRecyclerView(PopularMovieOverviewAdapter popularMovieOverviewAdapter) {
        rvPopularMovies.setAdapter(popularMovieOverviewAdapter);
    }
}
