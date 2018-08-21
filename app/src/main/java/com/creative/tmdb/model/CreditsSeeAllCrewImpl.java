package com.creative.tmdb.model;

import android.content.Context;

import com.creative.tmdb.R;
import com.creative.tmdb.adapter.CreditsAllCrewAdapter;
import com.creative.tmdb.jsonmapping.moviecredits.JsonMovieCreditCrew;
import com.creative.tmdb.jsonmapping.moviecredits.JsonMovieCreditsMetadata;
import com.creative.tmdb.presenter.CreditsSeeAllCrew;
import com.creative.tmdb.retrofit.RetrofitInstance;
import com.creative.tmdb.retrofitcall.CallMovieCreditsCastCrew;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class CreditsSeeAllCrewImpl {

    private CreditsSeeAllCrew creditsSeeAllCrew;
    private Context context;
    private Retrofit retrofit;

    public CreditsSeeAllCrewImpl(CreditsSeeAllCrew creditsSeeAllCrew, Context context) {
        this.creditsSeeAllCrew = creditsSeeAllCrew;
        this.context = context;
        retrofit = RetrofitInstance.getRetrofitInstance(context);
    }

    public void loadAllCrewMembers(int movieId) {
        retrofit.create(CallMovieCreditsCastCrew.class)
                .getMovieCastAndCrew(movieId, context.getResources().getString(R.string.API_KEY))
                .enqueue(new Callback<JsonMovieCreditsMetadata>() {
                    @Override
                    public void onResponse(Call<JsonMovieCreditsMetadata> call, Response<JsonMovieCreditsMetadata> response) {
                        JsonMovieCreditsMetadata metadata = response.body();
                        JsonMovieCreditCrew[] crewMembers = metadata.getCrewMembers();
                        creditsSeeAllCrew.setCrewAdapter(new CreditsAllCrewAdapter(crewMembers));
                    }

                    @Override
                    public void onFailure(Call<JsonMovieCreditsMetadata> call, Throwable t) {
                        // on error
                    }
                });
    }
}
