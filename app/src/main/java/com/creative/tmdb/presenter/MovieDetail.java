package com.creative.tmdb.presenter;

public interface MovieDetail {
    void setWidePoster(String widePosterUrl);
    void setMovieTitle(String movieTitle);
    void setVoteCount(long voteCount);
    void setVoteAverage(float voteAverage);
    void setPopularity(float popularity);
    void setReleaseDate(String releaseDate);
    void setOverview(String overview);
    void setImdbListener(String imdbId);
}
