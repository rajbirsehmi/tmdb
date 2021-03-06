package com.creative.tmdb.model;

import android.content.Context;

import com.creative.tmdb.R;
import com.creative.tmdb.adapter.MovieDetailCastAdapter;
import com.creative.tmdb.adapter.MovieDetailCrewAdapter;
import com.creative.tmdb.jsonmapping.moviecredits.JsonMovieCreditCast;
import com.creative.tmdb.jsonmapping.moviecredits.JsonMovieCreditCrew;
import com.creative.tmdb.jsonmapping.moviecredits.JsonMovieCreditsMetadata;
import com.creative.tmdb.presenter.MovieDetailCastCrew;
import com.creative.tmdb.retrofit.RetrofitInstance;
import com.creative.tmdb.retrofitcall.CallMovieCreditsCastCrew;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MovieCreditCastCrewImpl {

    private MovieDetailCastCrew movieDetailCastCrew;
    private Context context;
    private Retrofit retrofit;

    public MovieCreditCastCrewImpl(MovieDetailCastCrew movieDetailCastCrew, Context context) {
        this.movieDetailCastCrew = movieDetailCastCrew;
        this.context = context;
        retrofit = RetrofitInstance.getRetrofitInstance(context);
    }

    public void loadCastAndCrew(int movieId) {
        retrofit.create(CallMovieCreditsCastCrew.class)
                .getMovieCastAndCrew(movieId, context.getResources().getString(R.string.API_KEY))
                .enqueue(new Callback<JsonMovieCreditsMetadata>() {
                    @Override
                    public void onResponse(Call<JsonMovieCreditsMetadata> call, Response<JsonMovieCreditsMetadata> response) {
                        JsonMovieCreditsMetadata metadata = response.body();
                        JsonMovieCreditCast[] castMembers = metadata.getCastMembers();
                        JsonMovieCreditCrew[] crewMembers = metadata.getCrewMembers();
                        movieDetailCastCrew.setCastAdapter(new MovieDetailCastAdapter(castMembers));
                        movieDetailCastCrew.setCrewAdapter(new MovieDetailCrewAdapter(crewMembers));
                    }

                    @Override
                    public void onFailure(Call<JsonMovieCreditsMetadata> call, Throwable t) {
                        // on error
                    }
                });
    }
}
