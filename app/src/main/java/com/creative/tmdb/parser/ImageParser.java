package com.creative.tmdb.parser;

import com.creative.tmdb.builder.ImageBuilder;
import com.creative.tmdb.jsonmapping.moviedetail.JsonMovieDetailWallpaperAndPoster;
import com.creative.tmdb.pojomapping.Image;

public class ImageParser {
    public static Image parse(JsonMovieDetailWallpaperAndPoster wallpaperOrPoster) {
        return new ImageBuilder
                .Builder()
                .setAspectRatio(wallpaperOrPoster.getAspectRatio())
                .setImageHeight(wallpaperOrPoster.getHeight())
                .setImageUrl(wallpaperOrPoster.getUrl())
                .setImageWidth(wallpaperOrPoster.getWidth())
                .setVoteAverage(wallpaperOrPoster.getVoteAverage())
                .setVoteCount(wallpaperOrPoster.getVoteCount())
                .build();
    }
}
