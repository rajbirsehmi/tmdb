package com.creative.tmdb.presenter;

import com.creative.tmdb.adapter.PopularMovieSeeAllAdapter;

public interface PopularMoviesPaging {
    void setPopularMovieAdapterToRecyclerView(PopularMovieSeeAllAdapter popularMovieSeeAllAdapter);
    void updateMetadata(int currentPage, int totalPages, int totalResults, int currentResultMax, int currentResultMin);
    void notifyAlreadyAtFirstPage(String message);
}
