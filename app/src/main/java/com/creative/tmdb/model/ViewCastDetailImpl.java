package com.creative.tmdb.model;

import android.content.Context;

import com.creative.tmdb.R;
import com.creative.tmdb.jsonmapping.moviecredits.JsonCreditsCast;
import com.creative.tmdb.jsonmapping.moviecredits.JsonCreditsCastPerson;
import com.creative.tmdb.presenter.ViewCastDetail;
import com.creative.tmdb.retrofit.RetrofitInstance;
import com.creative.tmdb.retrofitcall.CallCastDetail;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class ViewCastDetailImpl {
    private ViewCastDetail viewCastDetail;
    private Context context;
    private Retrofit retrofit;

    public ViewCastDetailImpl(ViewCastDetail viewCastDetail, Context context) {
        this.viewCastDetail = viewCastDetail;
        this.context = context;
        retrofit = RetrofitInstance.getRetrofitInstance(context);
    }

    public void getCastMemberDetail(String creditId) {
        retrofit.create(CallCastDetail.class)
                .getCastDetail(creditId, context.getResources().getString(R.string.API_KEY))
                .enqueue(new Callback<JsonCreditsCast>() {
                    @Override
                    public void onResponse(Call<JsonCreditsCast> call, Response<JsonCreditsCast> response) {
                        JsonCreditsCast creditsCast = response.body();
                        JsonCreditsCastPerson castPerson = creditsCast.getCreditsCastPerson();
                        viewCastDetail.setBackgroundImage(context.getResources().getString(R.string.poster_url_prefix_high) + castPerson.getProfileImageUrl());
                        viewCastDetail.setCastMemberName(castPerson.getActorName());
                        viewCastDetail.setCastMemberDepartment(creditsCast.getDepartment());
                        viewCastDetail.setCastMemberPopularity(castPerson.getPopularity());
//                        if (castPerson.getGender() == 1)
//                            viewCastDetail.setCastGender(context.getResources().getString(R.string.gender_female));
//                        else
//                            viewCastDetail.setCastGender(context.getResources().getString(R.string.gender_male));
                        viewCastDetail.loadMoreData(castPerson.getActorId());
                    }

                    @Override
                    public void onFailure(Call<JsonCreditsCast> call, Throwable t) {
                        // on error
                    }
                });
    }
}