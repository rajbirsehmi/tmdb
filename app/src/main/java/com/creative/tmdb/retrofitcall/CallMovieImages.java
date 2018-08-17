package com.creative.tmdb.retrofitcall;

import com.creative.tmdb.jsonmapping.moviedetail.JsonMovieDetailImage;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface CallMovieImages {
    @GET("movie/{movie_id}/images")
    Call<JsonMovieDetailImage> getMovieImages(@Path("movie_id") int movieId, @Query("api_key") String apiKey);
}
