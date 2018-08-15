package com.creative.tmdb.builder;

import android.os.Build;

import com.creative.tmdb.pojomapping.PopularMovie;

public class PopularMovieBuilder {
    public static class Builder {
        private PopularMovie movie;

        public Builder() {
            movie = new PopularMovie();
        }

        public Builder setVoteCount(int voteCount) {
            movie.setVoteCount(voteCount);
            return this;
        }

        public Builder setHasVideo(boolean hasVideo) {
            movie.setHasVideo(hasVideo);
            return this;
        }

        public Builder setMovieId(int movieId) {
            movie.setMovieId(movieId);
            return this;
        }

        public Builder setVoteAverage(float voteAverage) {
            movie.setVoteAverage(voteAverage);
            return this;
        }

        public Builder setTitle(String title) {
            movie.setTitle(title);
            return this;
        }

        public Builder setPopularity(float popularity) {
            movie.setPopularity(popularity);
            return this;
        }

        public Builder setPosterPath(String posterPath) {
            movie.setPosterPath(posterPath);
            return this;
        }

        public Builder setOriginalTitle(String originalTitle) {
            movie.setOriginalTitle(originalTitle);
            return this;
        }

        public Builder setOriginalLanguage(String originalLanguage) {
            movie.setOriginalLanguage(originalLanguage);
            return this;
        }

        public Builder setGenreIds(int[] genreIds) {
            movie.setGenreId(genreIds);
            return this;
        }

        public Builder setWidePosterUrl(String widePosterUrl) {
            movie.setWidePosterUrl(widePosterUrl);
            return this;
        }

        public Builder setIsAdult(boolean isAdult) {
            movie.setIsAdult(isAdult);
            return this;
        }

        public Builder setOverview(String overview) {
            movie.setOverview(overview);
            return this;
        }

        public Builder setReleaseDate(String releaseDate) {
            movie.setReleaseDate(releaseDate);
            return this;
        }

        public PopularMovie build() {
            return movie;
        }
    }
}
