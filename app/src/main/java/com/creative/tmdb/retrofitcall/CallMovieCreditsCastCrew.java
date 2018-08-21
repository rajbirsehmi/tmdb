package com.creative.tmdb.retrofitcall;

import com.creative.tmdb.jsonmapping.moviecredits.JsonMovieCreditsMetadata;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface CallMovieCreditsCastCrew {

    @GET("movie/{movie_id}/credits")
    Call<JsonMovieCreditsMetadata> getMovieCastAndCrew(@Path("movie_id") int movieId, @Query("api_key") String apiKey);
}
