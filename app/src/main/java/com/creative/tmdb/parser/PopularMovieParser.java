package com.creative.tmdb.parser;

import com.creative.tmdb.builder.PopularMovieBuilder;
import com.creative.tmdb.jsonmapping.popularmovie.JsonPopularMovieMapping;
import com.creative.tmdb.pojomapping.PopularMovie;

public class PopularMovieParser {

    public static PopularMovie parseMovie(JsonPopularMovieMapping mapping) {
        return new PopularMovieBuilder.Builder()
                .setGenreIds(mapping.getGenreId())
                .setHasVideo(mapping.isHasVideo())
                .setIsAdult(mapping.isAdult())
                .setMovieId(mapping.getMovieId())
                .setOriginalLanguage(mapping.getOriginalLanguage())
                .setOriginalTitle(mapping.getOriginalTitle())
                .setOverview(mapping.getOverview())
                .setPopularity(mapping.getPopularity())
                .setPosterPath(mapping.getPosterPath())
                .setReleaseDate(mapping.getReleaseDate())
                .setTitle(mapping.getTitle())
                .setVoteAverage(mapping.getVoteAverage())
                .setVoteCount(mapping.getVoteCount())
                .setWidePosterUrl(mapping.getWidePosterUrl())
                .build();
    }
}
