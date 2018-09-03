package com.creative.tmdb.model;

import android.content.Context;

import com.creative.tmdb.R;
import com.creative.tmdb.jsonmapping.viewcastmember.JsonCastMemberBiodata;
import com.creative.tmdb.listener.ImdbCastMemberLinkListener;
import com.creative.tmdb.presenter.ViewCastBiodata;
import com.creative.tmdb.retrofit.RetrofitInstance;
import com.creative.tmdb.retrofitcall.CallGetCastMemberBiodata;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class ViewCastBiodataImpl {
    private ViewCastBiodata viewCastBiodata;
    private Context context;
    private Retrofit retrofit;

    public ViewCastBiodataImpl(ViewCastBiodata viewCastBiodata, Context context) {
        this.viewCastBiodata = viewCastBiodata;
        this.context = context;
        retrofit = RetrofitInstance.getRetrofitInstance(context);
    }

    public void getBiodata(int personId) {
        retrofit.create(CallGetCastMemberBiodata.class)
                .getCastMemberBiodata(personId, context.getResources().getString(R.string.API_KEY))
                .enqueue(new Callback<JsonCastMemberBiodata>() {
                    @Override
                    public void onResponse(Call<JsonCastMemberBiodata> call, Response<JsonCastMemberBiodata> response) {
                        JsonCastMemberBiodata biodata = response.body();
                        viewCastBiodata.setBirthDate(biodata.getBirthday());
                        viewCastBiodata.setBirthPlace(biodata.getBirthPlace());
                        viewCastBiodata.setBiography(biodata.getBiography());
                        viewCastBiodata.setImdbLink(new ImdbCastMemberLinkListener(biodata.getImdbId()));
                    }

                    @Override
                    public void onFailure(Call<JsonCastMemberBiodata> call, Throwable t) {
                        // on error
                    }
                });
    }
}
