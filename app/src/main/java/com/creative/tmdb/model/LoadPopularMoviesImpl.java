package com.creative.tmdb.model;

import android.content.Context;
import android.util.Log;

import com.creative.tmdb.R;
import com.creative.tmdb.adapter.PopularMovieOverviewAdapter;
import com.creative.tmdb.jsonmapping.popularmovie.JsonPopularMovieMapping;
import com.creative.tmdb.jsonmapping.popularmovie.JsonPopularMovieMetadata;
import com.creative.tmdb.presenter.LoadPopularMovies;
import com.creative.tmdb.retrofit.RetrofitInstance;
import com.creative.tmdb.retrofitcall.CallPopularMoviesMetaData;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class LoadPopularMoviesImpl {

    private LoadPopularMovies loadPopularMovies;
    private Retrofit retrofit;
    private Context context;

    public LoadPopularMoviesImpl(LoadPopularMovies loadPopularMovies, Context context) {
        this.loadPopularMovies = loadPopularMovies;
        this.context = context;
        retrofit = RetrofitInstance.getRetrofitInstance(context);
    }

    public void loadPopularMovies(int pageNumber) {
        CallPopularMoviesMetaData callPopularMoviesMetaData = retrofit.create(CallPopularMoviesMetaData.class);
        Call<JsonPopularMovieMetadata> metadataCall = callPopularMoviesMetaData.getJsonPopularMoviesMetaData(context.getResources().getString(R.string.API_KEY), context.getResources().getString(R.string.popular_movies_sort_desc), pageNumber);
        metadataCall.enqueue(new Callback<JsonPopularMovieMetadata>() {
            @Override
            public void onResponse(Call<JsonPopularMovieMetadata> call, Response<JsonPopularMovieMetadata> response) {
                JsonPopularMovieMetadata metadata = response.body();
                JsonPopularMovieMapping[] mappings = metadata.getJsonPopularMovieMapping();
                loadPopularMovies.setPopularMovieAdapterToRecyclerView(new PopularMovieOverviewAdapter(mappings));
            }

            @Override
            public void onFailure(Call<JsonPopularMovieMetadata> call, Throwable t) {
                Log.d("CODE", "onResponse: " + t.getMessage());
            }
        });
    }
}
