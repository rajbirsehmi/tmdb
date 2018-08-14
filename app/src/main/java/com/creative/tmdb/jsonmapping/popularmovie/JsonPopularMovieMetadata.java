package com.creative.tmdb.jsonmapping.popularmovie;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class JsonPopularMovieMetadata {
    @SerializedName("page")
    @Expose
    private int currentPage;

    @SerializedName("total_results")
    @Expose
    private int totalResults;

    @SerializedName("total_Pages")
    @Expose
    private int totalPages;

    @SerializedName("results")
    @Expose
    private JsonPopularMovieMapping jsonPopularMovieMapping;

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(int totalResults) {
        this.totalResults = totalResults;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public JsonPopularMovieMapping getJsonPopularMovieMapping() {
        return jsonPopularMovieMapping;
    }

    public void setJsonPopularMovieMapping(JsonPopularMovieMapping jsonPopularMovieMapping) {
        this.jsonPopularMovieMapping = jsonPopularMovieMapping;
    }
}
