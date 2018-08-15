package com.creative.tmdb.retrofitcall;

import com.creative.tmdb.jsonmapping.popularmovie.JsonPopularMovieMetadata;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface CallPopularMoviesMetaData {
    @GET("movie/popular")
    Call<JsonPopularMovieMetadata> getJsonPopularMoviesMetaData(@Query("api_key") String apiKey, @Query("sort_by") String sortBy, @Query("page") int pageNumber);
}
