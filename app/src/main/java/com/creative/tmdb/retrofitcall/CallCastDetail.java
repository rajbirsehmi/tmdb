package com.creative.tmdb.retrofitcall;

import com.creative.tmdb.jsonmapping.moviecredits.JsonCreditsCast;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface CallCastDetail {
    @GET("credit/{credit_id}")
    Call<JsonCreditsCast> getCastDetail(@Path("credit_id") String creditId, @Query("api_key") String apiKey);
}
