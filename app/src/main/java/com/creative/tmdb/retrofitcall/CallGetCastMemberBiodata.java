package com.creative.tmdb.retrofitcall;

import com.creative.tmdb.jsonmapping.viewcastmember.JsonCastMemberBiodata;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface CallGetCastMemberBiodata {

    @GET("person/{person_id}")
    Call<JsonCastMemberBiodata> getCastMemberBiodata(@Path("person_id") int personId, @Query("api_key") String apiKey);
}
