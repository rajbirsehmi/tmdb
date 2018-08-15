package com.creative.tmdb.retrofitcall;

import com.creative.tmdb.jsonmapping.moviedetail.JsonMovieDetail;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface CallMovieDetail {

    @GET("movie/{movie_id}")
    Call<JsonMovieDetail>  callMovieDetail(@Path("movie_id") int movieId, @Query("api_key") String apiKey);
}
