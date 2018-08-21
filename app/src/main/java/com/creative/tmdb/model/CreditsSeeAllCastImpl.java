package com.creative.tmdb.model;

import android.content.Context;

import com.creative.tmdb.R;
import com.creative.tmdb.adapter.CreditsAllCastAdapter;
import com.creative.tmdb.adapter.CreditsAllCrewAdapter;
import com.creative.tmdb.jsonmapping.moviecredits.JsonMovieCreditCast;
import com.creative.tmdb.jsonmapping.moviecredits.JsonMovieCreditCrew;
import com.creative.tmdb.jsonmapping.moviecredits.JsonMovieCreditsMetadata;
import com.creative.tmdb.presenter.CreditsSeeAllCast;
import com.creative.tmdb.presenter.CreditsSeeAllCrew;
import com.creative.tmdb.retrofit.RetrofitInstance;
import com.creative.tmdb.retrofitcall.CallMovieCreditsCastCrew;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class CreditsSeeAllCastImpl {

    private CreditsSeeAllCast creditsSeeAllCast;
    private Context context;
    private Retrofit retrofit;

    public CreditsSeeAllCastImpl(CreditsSeeAllCast creditsSeeAllCast, Context context) {
        this.creditsSeeAllCast = creditsSeeAllCast;
        this.context = context;
        retrofit = RetrofitInstance.getRetrofitInstance(context);
    }

    public void loadAllCastMembers(int movieId) {
        retrofit.create(CallMovieCreditsCastCrew.class)
                .getMovieCastAndCrew(movieId, context.getResources().getString(R.string.API_KEY))
                .enqueue(new Callback<JsonMovieCreditsMetadata>() {
                    @Override
                    public void onResponse(Call<JsonMovieCreditsMetadata> call, Response<JsonMovieCreditsMetadata> response) {
                        JsonMovieCreditsMetadata metadata = response.body();
                        JsonMovieCreditCast[] castMembers = metadata.getCastMembers();
                        creditsSeeAllCast.setCastAdapter(new CreditsAllCastAdapter(castMembers));
                    }

                    @Override
                    public void onFailure(Call<JsonMovieCreditsMetadata> call, Throwable t) {
                        // on error
                    }
                });
    }
}