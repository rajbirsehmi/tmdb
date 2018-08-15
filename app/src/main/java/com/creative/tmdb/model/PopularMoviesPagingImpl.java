package com.creative.tmdb.model;

import android.content.Context;

import com.creative.tmdb.R;
import com.creative.tmdb.adapter.PopularMovieSeeAllAdapter;
import com.creative.tmdb.jsonmapping.popularmovie.JsonPopularMovieMapping;
import com.creative.tmdb.jsonmapping.popularmovie.JsonPopularMovieMetadata;
import com.creative.tmdb.presenter.PopularMoviesPaging;
import com.creative.tmdb.retrofit.RetrofitInstance;
import com.creative.tmdb.retrofitcall.CallPopularMoviesMetaData;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class PopularMoviesPagingImpl {

    private PopularMoviesPaging popularMoviesPaging;
    private Context context;
    private Retrofit retrofit;
    private int currentPage = 1;

    public PopularMoviesPagingImpl(PopularMoviesPaging popularMoviesPaging, Context context) {
        this.popularMoviesPaging = popularMoviesPaging;
        this.context = context;
        retrofit = RetrofitInstance.getRetrofitInstance(context);
    }

    public void loadPopularMovies(int pageNumber) {
        CallPopularMoviesMetaData moviesMetaData = retrofit.create(CallPopularMoviesMetaData.class);
        Call<JsonPopularMovieMetadata> callMovieMetadata = moviesMetaData.getJsonPopularMoviesMetaData(context.getResources().getString(R.string.API_KEY), context.getResources().getString(R.string.popular_movies_sort_desc), pageNumber);
        callMovieMetadata.enqueue(new Callback<JsonPopularMovieMetadata>() {
            @Override
            public void onResponse(Call<JsonPopularMovieMetadata> call, Response<JsonPopularMovieMetadata> response) {
                JsonPopularMovieMetadata metadata = response.body();
                JsonPopularMovieMapping mappings[] = metadata.getJsonPopularMovieMapping();
                popularMoviesPaging.setPopularMovieAdapterToRecyclerView(new PopularMovieSeeAllAdapter(mappings));
                popularMoviesPaging.updateMetadata(metadata.getCurrentPage(), metadata.getTotalPages(), metadata.getTotalResults(), 20 * currentPage,(20 * (currentPage - 1)) + 1);
            }

            @Override
            public void onFailure(Call<JsonPopularMovieMetadata> call, Throwable t) {
            }
        });
    }

    public void loadNextPage() {
        currentPage++;
        loadPopularMovies(currentPage);
    }

    public void loadPrevPage() {
        if (currentPage == 1) {
            popularMoviesPaging.notifyAlreadyAtFirstPage(context.getResources().getString(R.string.error_message_already_at_first_page));
            return;
        }
        currentPage--;
        loadPopularMovies(currentPage);
    }
}
